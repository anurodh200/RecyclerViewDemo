package com.example.recyclerviewdemo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId", R.drawable.v3_0005787)
        val newsContent = intent.getStringExtra("newsContent")


        val headingTxtview = findViewById<TextView>(R.id.newsHeading)
        val headingImg = findViewById<ImageView>(R.id.newsImage)
        val newsContentTxtview = findViewById<TextView>(R.id.newsDescription)

        headingTxtview.text = heading
        headingImg.setImageResource(imageId)
        newsContentTxtview.text = newsContent


    }
}