package com.example.stack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var tcount: TextView
    private lateinit var tpeek: TextView
    private lateinit var ename: EditText
    private lateinit var mylist: ListView
    private lateinit var bs: Button

    var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tcount = findViewById(R.id.txtcount)
        tpeek = findViewById(R.id.txtpeek)
        ename = findViewById(R.id.edtname)
        mylist = findViewById(R.id.listView)
        bs = findViewById(R.id.btns)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        mylist.adapter = arrayAdapter

        bs.setOnClickListener {
            val name = ename.text.toString()
            listAdd(name)
            arrayAdapter.notifyDataSetChanged() // Notify the adapter of the data change
            count()
            peek()
        }

        peek()
        count()
    }

    private fun count() {
        val s = list.size
        tcount.text = "items: " + s.toString()
    }

    private fun peek() {
        if (list.isNotEmpty()) {
            val v = list[0]
            tpeek.text = "peek: " + v
        } else {
            tpeek.text = "List is empty"
        }
    }

    private fun listAdd(value: String) {
        list.add(value)
    }
}
