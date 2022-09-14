package com.bignerdranch.android.labs11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
private var str : String = ""
class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        var Weath : MutableList<String> = mutableListOf()
        val mPrefs = getSharedPreferences("MyWeather", AppCompatActivity.MODE_PRIVATE)
        str = mPrefs.getString("MyWeather",str).toString()
        Log.d("y",str)
    }
}