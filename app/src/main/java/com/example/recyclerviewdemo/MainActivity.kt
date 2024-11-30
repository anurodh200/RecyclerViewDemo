package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.v3_0005787,
            R.drawable.v3_0046489,
            R.drawable.v3_0282119,
            R.drawable.v3_0795178,
            R.drawable.v3_0046489,
        )

        val newsHeading = arrayOf(
            "World leaders gather to discuss climate change initiatives at the UN summit this week.",
            "New advancements in AI technology promise to revolutionize industries and improve daily life.",
            "Local community celebrates annual cultural festival with music, dance, and traditional food.",
            "Scientists discover new species of marine life in the unexplored depths of the Pacific Ocean.",
            "Major tech company unveils its latest smartphone model with innovative features and improved performance."
        )

        newsArrayList = arrayListOf<News>()

        for(i in newsImageArray.indices){
            val news = News(newsHeading[i], newsImageArray[i])
            newsArrayList.add(news)
        }

        //It set the scrolling behaviour items inside recycler view as vertically, horizontally, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyAdapter(newsArrayList, this)

    }


}
