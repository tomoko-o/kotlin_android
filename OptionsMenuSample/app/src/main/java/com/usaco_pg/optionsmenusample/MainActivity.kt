package com.usaco_pg.optionsmenusample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val deleteItem = menu?.findItem(R.id.action_delete)
        deleteItem?.isEnabled = false

        val addItem = menu?.findItem(R.id.action_add)
        addItem?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val message = when (item?.itemId) {
            R.id.action_add -> resources.getString(R.string.action_add)
            R.id.action_delete -> resources.getString(R.string.action_delete)
            R.id.action_save -> resources.getString(R.string.action_save)
            else -> "Please select menu"
        }

        textView.text = message

        return super.onOptionsItemSelected(item)
    }
}
