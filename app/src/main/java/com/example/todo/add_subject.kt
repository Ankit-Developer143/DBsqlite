package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class add_subject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)

        //Import DB

        val DB = SQLHelper(applicationContext)


        val title_input = findViewById<EditText>(R.id.et_title)
        val desc_input = findViewById<EditText>(R.id.et_desc)
        val add_btn = findViewById<Button>(R.id.btn_add)

        add_btn.setOnClickListener{
            val title_txt = title_input.text.toString().trim()
            val desc_txt = desc_input.text.toString().trim()
            DB.ADD_DATA(title_txt,desc_txt)
            Toast.makeText(this@add_subject,"The Subject has been added",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@add_subject,MainActivity::class.java))
        }

    }
}