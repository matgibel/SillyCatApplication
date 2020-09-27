package com.example.silly_cat_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.silly_cat_api.R
import com.example.silly_cat_api.model.Breeds
import com.example.silly_cat_api.model.SillyCatAPI
import com.example.silly_cat_api.model.SillyCatResponseItem
import com.example.silly_cat_api.viewmodel.FragmentDisplay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val displayFragment:FragmentDisplay by lazy {
        FragmentDisplay()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initNetworkCall()

    }

    fun initNetworkCall(){
        SillyCatAPI.initRetrofit().getTop50Cats().enqueue(object :Callback<List<SillyCatResponseItem>>{
            override fun onResponse(
                call: Call<List<SillyCatResponseItem>>,
                response: Response<List<SillyCatResponseItem>>
            ) {
                if(response.isSuccessful){


                    initFragment(response.body())
                }
            }

            override fun onFailure(call: Call<List<SillyCatResponseItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Pay your internet connection",Toast.LENGTH_SHORT).show()            }

        })
    }


    /*
    fun initNetworkCall(){
        SillyCatAPI.initRetrofit().getTop50Cats().enqueue(object: Callback<List<SillyCatResponse>>{
            override fun onResponse(
                call: Call<List<SillyCatResponse>>,
                response: Response<SillyCatResponse>
            ) {
                if(response.isSuccessful){
                    initFragment(response.body())
                }
            }

            override fun onFailure(call: Call<List<SillyCatResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Pay your internet connection",Toast.LENGTH_SHORT).show()
            }

        })
    }
*/
    private fun initFragment(body: List<SillyCatResponseItem>?){
        body?.let {
            val fragmentDisplay = FragmentDisplay.newInstance(it)
            supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_container,fragmentDisplay).commit()

        }
    }
}