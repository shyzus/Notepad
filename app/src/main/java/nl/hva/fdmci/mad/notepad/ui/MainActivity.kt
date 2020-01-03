package nl.hva.fdmci.mad.notepad.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*
import nl.hva.fdmci.mad.notepad.R
import nl.hva.fdmci.mad.notepad.model.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra(EditActivity.EXTRA_NOTE, mainActivityViewModel.note.value)
            startActivity(intent)
        }
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.note.observe(this, Observer { note ->
            if (note != null) {
                tvTitle.text = note.title
                tvLastUpdated.text = getString(R.string.last_updated, note.lastUpdated.toString())
                tvNote.text = note.text
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
