package com.example.memeapp

import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.memeapp.model.MemeList
import retrofit2.Call
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.memeapp.R.layout.activity_main
import com.example.memeapp.api.RetrofitHelper
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView
    private lateinit var nextBtn : Button
    private lateinit var shareBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)


        imageView = findViewById(R.id.imageView)
        nextBtn = findViewById(R.id.next_btn)
        getData()

        nextBtn.setOnClickListener { getData() }

    }

    private fun getData() {

        RetrofitHelper.apiInterface.getData().enqueue(object : Callback<MemeList?> {
            override fun onResponse(call: Call<MemeList?>, response: Response<MemeList?>) {
                if(response !=null) {
                    Glide.with(this@MainActivity).load(response.body()?.url).thumbnail(Glide.with(this@MainActivity).load(R.drawable.giphy)).into(imageView);
                }
            }

            override fun onFailure(call: Call<MemeList?>, t: Throwable) {
               Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

    }
}