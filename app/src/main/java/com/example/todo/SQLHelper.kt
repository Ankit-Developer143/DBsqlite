package com.example.todo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Step 1
class SQLHelper (context: Context):SQLiteOpenHelper(context,DB_name,null,1){


      //CREATE
    override fun onCreate(db: SQLiteDatabase?) {
        //Step 3  Create table withe the help of Companion object variable
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_title TEXT , S_desc TEXT)")

    }


    //DROP
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        //step 4
        db?.execSQL("DROP TABLE IF EXISTS$TB_name")

    }

    //step 5   READ
    val data_geter:Cursor get(){

        //we need to make database writable
        val DB = this.writableDatabase
        //Hold Actual DataBase  inside data
        val data = DB.rawQuery("select * from " + TB_name,null)
        return data

    }

    //step 6 INSERT
    //Add Paremeter and parameter value pass through user

    fun ADD_DATA(title_txt:String,desc_txt:String){

        val DB = this.writableDatabase
        val values = ContentValues()

        //CompanionObject and userValue(Paremeter)
        values.put(title,title_txt)
        values.put(desc,desc_txt)

        DB.insert(TB_name,null,values)

    }



    fun Delete_Data(itemId:Long){
        val DB  = this.writableDatabase
        DB.delete(TB_name, "id = ?", arrayOf(itemId.toString()))
    }









    //Step 2
    //companion object Place where we can add Variable
    //add data inside this variable and call globally
    companion object{


        //add any name
        val DB_name = "subjects.db "
        val TB_name = "Subjects "
        val id = "ID"
        val title = "S_title"
        val desc = "S_desc"


    }

}
