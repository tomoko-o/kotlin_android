package com.usaco_pg.simplelistview2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = List<Map<String, String>>(20, { i -> mapOf("title" to "title-$i", "detail" to "detail-$i")})

        val adapter = SimpleAdapter(
                this,
                items,
                android.R.layout.simple_list_item_2,
                arrayOf("title", "detail"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        myListView.adapter = adapter

        myListView.setOnItemClickListener { adapterView, view, position, id ->
            val title = view.findViewById<TextView>(android.R.id.text1).text
            val detail = view.findViewById<TextView>(android.R.id.text2).text
            Toast.makeText(this, "$title: $detail", Toast.LENGTH_SHORT).show()
        }
    }
}
