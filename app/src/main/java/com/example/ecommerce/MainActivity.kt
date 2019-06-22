package com.example.ecommerce

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private var sharedP:SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            //Shared Prefernces Example
        //used when want to store un-sensitive data

//        btnAdd.setOnClickListener {
//
//            sharedP = getSharedPreferences("addData",Context.MODE_PRIVATE)       //add data is key unique to sharedP
//
//            var myEditor = sharedP?.edit()
//
//            myEditor?.putString("product_name",editText.text.toString())             //product_name is key which is unique to data entered
//            myEditor?.commit()
//
//            Toast.makeText(this,"Product Added",Toast.LENGTH_SHORT).show()
//        }
//
//        btnGet.setOnClickListener {
//            textView2.text = sharedP?.getString("product_name","Nothing")

     //get data from the server
      btngetData.setOnClickListener {
           var serverUrl:String = "http://192.168.1.5/PhpProject2/knowYourIP.php"
           var requestQ:RequestQueue = Volley.newRequestQueue(this@MainActivity)
           var stringRequest = StringRequest(Request.Method.GET,serverUrl,Response.Listener { response -> textView.text = response
           },
                Response.ErrorListener {error ->

                        textView.text = error.message
            })
            requestQ.add(stringRequest)       /* General Note
                                               1-> Give permission to access Internet
                                                2-> after setting permission error can be found
                                                3-> under application tag use android:usesCleartextTraffic="true"*/ }

        }
    }

