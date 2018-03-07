package com.usaco_pg.helloapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeButton.setOnClickListener(View.OnClickListener {
            val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS")
            timeTextView.text = df.format(Date())
        })
    }
}
