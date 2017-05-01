package com.usaco_pg.intentsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object Factory {
        val EXTRA_TEXT = "com.usaco_pg.intentsample.EXTRA_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("onCreate", "*********")
    }
    
    fun changeActivity(view: View) {
        val text = editText.text?.toString()
        if (text == null || text == "") {
            AlertDialog.Builder(this)
//                    .setTitle("Error")
                    .setTitle(resources.getText(R.string.alert_title))
//                    .setMessage("テキストを入力してください")
                    .setMessage(resources.getText(R.string.hint_text))
                    .setPositiveButton(resources.getText(R.string.alert_button), null)
                    .show()
            return
        }
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra(EXTRA_TEXT, text)
        startActivity(intent)
    }
}
