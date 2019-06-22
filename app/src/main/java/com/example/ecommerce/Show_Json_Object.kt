package com.example.ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show__json__object.*

class Show_Json_Object : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show__json__object)


        /*Get JSON Object From Server and Show it on the emulator*/

        btnSubmit.setOnClickListener {
            val productUrl:String = "http://192.168.1.5/PhpProject1/present_JSON.php?id="+editTextid.text.toString()
            var requestQ:RequestQueue= Volley.newRequestQueue(this@Show_Json_Object)
            val jasonObjectRequest = JsonObjectRequest(Request.Method.GET,productUrl,null,
                Response.Listener { response-> textView8.text = response.getString("name")
                                                    textView7.text = response.getInt("price").toString()

                },
                Response.ErrorListener { error -> textView8.text = error.message })

            requestQ.add(jasonObjectRequest)

        }
    }
}
