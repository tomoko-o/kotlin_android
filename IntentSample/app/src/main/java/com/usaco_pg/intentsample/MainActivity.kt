package com.usaco_pg.intentsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXTDATA = "com.usaco_pg.intentsample.TEXTDATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//            Log.d("MainActivity: onCreate", "Button Clicked!")
            if (editText.text.toString() == "") {
                editText.error = "なにか入力してください"
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(EXTRA_TEXTDATA, editText.text.toString())
                startActivity(intent)
            }
        }
    }

}
