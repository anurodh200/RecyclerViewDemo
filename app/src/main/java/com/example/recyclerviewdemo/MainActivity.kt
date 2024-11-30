package com.example.recyclerviewdemo

import android.content.Intent
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

        // Set the layout manager
        myRecyclerView.layoutManager = LinearLayoutManager(this) // Vertical scrolling by default
        // Alternatively, you can use GridLayoutManager or StaggeredGridLayoutManager based on your UI needs
        // myRecyclerView.layoutManager = GridLayoutManager(this, 2) // For a grid layout with 2 columns

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

        val newsContent = arrayOf(
            "At this week's UN summit, global leaders are coming together to discuss pressing climate change issues. The discussions focus on setting new goals for reducing carbon emissions and implementing sustainable energy solutions.",
            "The latest advancements in artificial intelligence are set to transform industries ranging from healthcare to transportation. Breakthroughs in machine learning algorithms and robotics hold the promise of making daily tasks easier and more efficient.",
            "The annual cultural festival in the local community brings people together to celebrate heritage through vibrant music, lively dance performances, and delicious traditional food. It's a time for family and friends to enjoy and reconnect.",
            "In a groundbreaking discovery, scientists exploring the Pacific Ocean's uncharted depths have identified a new species of marine life. These findings shed light on the biodiversity of the ocean and its vast unexplored ecosystems.",
            "A major tech company has unveiled its latest smartphone model, boasting cutting-edge features like enhanced camera quality, improved battery life, and a sleek new design. The device is expected to set new standards in the mobile industry."
        )


        newsArrayList = arrayListOf<News>()

        for(i in newsImageArray.indices){
            val news = News(newsHeading[i], newsImageArray[i], newsContent[i])
            newsArrayList.add(news)
        }

        var adapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //on click of item what to do
                val intent = Intent(applicationContext, NewsActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsDescription)
                startActivity(intent)
            }

        })
    }


}
