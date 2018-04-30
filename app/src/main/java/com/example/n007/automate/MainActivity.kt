package com.example.n007.automate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.n007.automate.model.Constans
import com.example.n007.automate.model.Info
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val client = OkHttpClient()
    var pesonalInfo: Info.PersonalInfoResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        run(Constans.Url)
    }

    private fun run(url: String) {
        val request = Request.Builder()
                .url(url)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                pesonalInfo = gson.fromJson(body, Info.PersonalInfoResponse::class.java)
                initView()
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

    fun initView() {
        runOnUiThread({
            tv_name.text = pesonalInfo?._name
            tv_birthyear.text = pesonalInfo?._birth_year
            tv_gender.text = pesonalInfo?._gender
            tv_eyes.text = pesonalInfo?._eye_color
            tv_hair.text = pesonalInfo?._hair_color
            tv_mass.text = pesonalInfo?._mass.toString()
            tv_skins.text = pesonalInfo?._skin_color
            tv_height.text = pesonalInfo?._height.toString()

        })
    }
}





