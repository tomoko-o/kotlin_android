package com.usaco_pg.fortuneapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getFortune(view: View) {
        val results = listOf("大吉", "中吉", "小吉", "吉", "末吉", "凶", "大凶")
        val random = Random().nextInt(results.count())
//        resultText.text = random.toString()
        resultText.text = results[random]

        if(random == 0) {
            resultText.setTextColor(Color.RED)
        } else {
            resultText.setTextColor(Color.BLACK)
            Color.argb(0xff, 0xff, 0xa5, 0x00)
        }

//        result_text.setTextColor(if (random == 0) Color.RED else Color.BLACK)
    }
}
