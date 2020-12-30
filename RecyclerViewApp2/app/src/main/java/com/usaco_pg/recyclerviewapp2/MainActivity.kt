package com.usaco_pg.recyclerviewapp2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memos = List<Map<String, String>>(20) { mapOf("title" to "title-$it", "detail" to "detail-$it")}

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(memos)
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)

        myRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(dividerItemDecoration)
        }

        viewAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClickListener(position: Int, memo: Map<String, String>) {
                Toast.makeText(this@MainActivity, "Clicked ${memo["title"]}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    class MyAdapter(private val memos: List<Map<String, String>>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        interface OnItemClickListener{
            fun onItemClickListener(position: Int, memo: Map<String, String>)
        }

        lateinit var listener: OnItemClickListener

        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(android.R.id.text1)
            val detail: TextView = view.findViewById(android.R.id.text2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.text = memos[position]["title"]
            holder.detail.text = memos[position]["detail"]

            holder.view.setOnClickListener {
                listener.onItemClickListener(position, memos[position])
            }
        }

        override fun getItemCount(): Int  = memos.size

        fun setOnItemClickListener(listener: OnItemClickListener){
            this.listener = listener
        }
    }

}