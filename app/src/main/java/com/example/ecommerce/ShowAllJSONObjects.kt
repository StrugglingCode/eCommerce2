package com.example.ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_jsonobjects.*

class ShowAllJSONObjects : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_jsonobjects)

        /* Get All JSON Objects and Show it on the Emulator*/
        textAllProducts.setOnClickListener {
            val allProductsUrl= "http://192.168.1.5/PhpProject1/present_JSON_Array.php"
            var allProducts =""                                                              //to hold all objects
            val requestQ:RequestQueue = Volley.newRequestQueue(this@ShowAllJSONObjects)
            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET,allProductsUrl,null,
                Response.Listener { response ->
                    for(productIndex in 0.until(response.length()))
                    {
                           // allProducts+=response.getJSONObject(productIndex).getString("name")+ "-"+ response.getJSONObject(productIndex).getString("price")
                            var productName = response.getJSONObject(productIndex).getString("name")
                            var productPrice = response.getJSONObject(productIndex).getInt("price")

                        allProducts = allProducts + productName + "-" + productPrice + "\n"

                    }

                    textAllProducts.text =allProducts



                },
                Response.ErrorListener { error -> textAllProducts.text= error.message })

            requestQ.add(jsonArrayRequest)
}

    }
}
