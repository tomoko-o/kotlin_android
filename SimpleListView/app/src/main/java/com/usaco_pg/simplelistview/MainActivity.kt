package com.usaco_pg.simplelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animals = listOf("Rabbit", "Dog", "Cat", "Turtle", "Bear", "Dolphin", "Lion", "Tiger")
        
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals)
        simpleListView.adapter = adapter as ListAdapter?

        simpleListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Click: ${animals[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
