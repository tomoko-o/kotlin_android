package com.usaco_pg.simplelistview2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Map<String, String>>()
        for (i in 0..20) {
            list.add(mapOf("title" to "title $i", "detail" to "detail $i"))
        }

        val adapter = SimpleAdapter(
                this,
                list,
                android.R.layout.simple_list_item_2,
                arrayOf("title", "detail"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        myListView.adapter = adapter as ListAdapter

        myListView.setOnItemClickListener { parent, view, position, id ->
            val title = view.findViewById(android.R.id.text1) as TextView
            val detail = view.findViewById(android.R.id.text2) as TextView
            Toast.makeText(this, "${title.text} (${detail.text})", Toast.LENGTH_SHORT).show()
        }
    }
}
