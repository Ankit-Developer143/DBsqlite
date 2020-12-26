package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter (var context: Context,data:ArrayList<Subject>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var data:List<Subject>

    init {
        this.data = data
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout  = LayoutInflater.from(context).inflate(R.layout.item_subject,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.desc.text = data[position].desc
        holder.id.text = data[position].id

    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item){

        var title:TextView
        var id:TextView
        var desc:TextView
        lateinit var btn_delete:Button
        init {
            title = item.findViewById(R.id.tv_title)
            id = item.findViewById(R.id.tv_id)
            desc = item.findViewById(R.id.tv_desc)
            btn_delete =item.findViewById(R.id.btn_delete)

        }


    }
}