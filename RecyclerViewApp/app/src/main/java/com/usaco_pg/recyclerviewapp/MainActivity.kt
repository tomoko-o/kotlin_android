package com.usaco_pg.recyclerviewapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = Array(20) { i -> "item-$i" }

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(this, items)
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)

        myRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(dividerItemDecoration)
        }
    }

    class MyAdapter(private val context: Context, private val items: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val textView = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
            return ViewHolder(textView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = items[position]

            holder.textView.setOnClickListener {
                Toast.makeText(context, "Clicked ${items[position]}", Toast.LENGTH_LONG).show()
            }
        }

//        override fun getItemCount(): Int {
//            return items.size
//        }

        override fun getItemCount(): Int  = items.size
    }

}