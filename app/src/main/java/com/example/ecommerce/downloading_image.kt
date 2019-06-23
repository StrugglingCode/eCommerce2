package com.example.ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_downloading_image.*

class downloading_image : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading_image)

        btndownloadImage.setOnClickListener {

            val imageUrl = "http://192.168.1.5/place_holder.png"
            //picasso library added
            Picasso.get().load("http://192.168.1.5/place_holder.png").into(imageViewdownload)


        }
    }
}
