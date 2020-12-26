package com.example.todo

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.SQLHelper.Companion.id

class MainActivity : AppCompatActivity() {
    lateinit var lists:ArrayList<Subject>
    lateinit var DB:SQLHelper
    lateinit var data:Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 1
        var go = findViewById<Button>(R.id.go_subject)
        go.setOnClickListener{

            startActivity(Intent(this@MainActivity,add_subject::class.java))
        }

        lists = ArrayList<Subject>()
        DB = SQLHelper(applicationContext)
        data  = DB.data_geter
        val adapter = Adapter(applicationContext,lists)
        val recycler = findViewById<RecyclerView>(R.id.list)

        ShowData()

        recycler.layoutManager = GridLayoutManager(applicationContext,2)
        recycler.adapter = adapter

    }
    fun ShowData() {
        if (data.count == 0){
            Toast.makeText(applicationContext,"There is no Items",Toast.LENGTH_SHORT).show()
        }
        while (data.moveToNext()){
            lists.add(Subject(data.getString(0),
            data.getString(1),
            data.getString(2)
            ))
        }




    }


    override fun onStart() {
        super.onStart()
        ShowData()
    }
}