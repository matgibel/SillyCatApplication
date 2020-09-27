package com.example.silly_cat_api.model

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


interface SillyCatAPI {

    //Base url "https://api.thecatapi.com/"
    //https://api.thecatapi.com/v1/images/search?limit=10&page=10&order=Desc

    //Your API key:
    //
    //67fa6a95-2491-441e-a32d-285fa5f1f8c5

    @GET("v1/images/search")
    fun getTop50Cats(@Query("limit") limit:Int = 50 , @Query("page") page:Int = 50):
            Call<List<SillyCatResponseItem>>


    //breeds
    //
    @GET("v1/breeds")
    fun getCatBreed():Call<List<Breeds>>


    companion object {
        var INSTANCE: SillyCatAPI? = null

        fun initRetrofit():SillyCatAPI{
            var tmpInstance = INSTANCE

            if(tmpInstance != null){
                return tmpInstance
            }
            else{
                tmpInstance = Retrofit.Builder()
                    .baseUrl("https://api.thecatapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SillyCatAPI::class.java)
                return tmpInstance
            }
        }



    }
}