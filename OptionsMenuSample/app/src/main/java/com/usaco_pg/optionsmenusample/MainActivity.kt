package com.usaco_pg.optionsmenusample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.action_delete)?.isVisible = false
        menu?.findItem(R.id.action_save)?.isEnabled = false
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }

        var message = when (item.itemId) {
            R.id.action_settings -> resources.getString(R.string.action_settings)
            R.id.action_add -> resources.getString(R.string.action_add)
            R.id.action_delete -> resources.getString(R.string.action_delete)
            R.id.action_save -> resources.getString(R.string.action_save)
            else -> resources.getString(R.string.select_menu_text)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }
}
