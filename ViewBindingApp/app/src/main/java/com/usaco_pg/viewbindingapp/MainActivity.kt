package com.usaco_pg.viewbindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.usaco_pg.viewbindingapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

//        binding.dateTextView.text = Date().toString()
        updateTextView()

        binding.changeBotton.setOnClickListener {
//            Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show()
            updateTextView()
        }
    }

    private fun updateTextView() {
        val date = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        binding.dateTextView.text = sdf.format(date)
    }
}