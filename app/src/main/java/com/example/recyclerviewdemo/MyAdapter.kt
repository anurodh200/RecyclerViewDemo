package com.example.recyclerviewdemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val newsArrayList: ArrayList<News>, val context: Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //It holds the views of the items in the RecyclerView, so memory can be saved
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headTxt)
        val hImage = itemView.findViewById<ImageView>(R.id.headImg)
    }

    //LayoutManager calls these methods for positioning items in the RecyclerView
    //If layoutManager fails to find suitable view in all of those places, it creates one by calling adapter's onCreateViewHolder method
    //then it binds the view via onBindViewHolder() method if necessary, and finally returns it to the RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.each_row_layout, parent, false)
        return MyViewHolder(v)
    }

    //Data population in views
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.hTitle.text = newsArrayList[position].newsHeaing
        holder.hImage.setImageResource(newsArrayList[position].newsImage)
    }

    //About number of items
    override fun getItemCount(): Int {
       return newsArrayList.size
    }

}
