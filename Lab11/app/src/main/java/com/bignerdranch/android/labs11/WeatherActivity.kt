package com.bignerdranch.android.labs11

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
var Weath : MutableList<String> = mutableListOf()
private lateinit var DateTime: EditText
private lateinit var Daytime_Temperature: EditText
private lateinit var NightTemp: EditText
private lateinit var btn: Button
class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        DateTime = findViewById(R.id.editTextTextPersonName)
        Daytime_Temperature = findViewById(R.id.editTextTextPersonName2)
        NightTemp = findViewById(R.id.editTextTextPersonName3)
        btn = findViewById(R.id.button3)
        val dateTime : String = DateTime.text.toString()
        val daytimeTemperature : String = Daytime_Temperature.text.toString()
        val nightTemp : String = NightTemp.text.toString()
        val Info : String = "$dateTime $daytimeTemperature $nightTemp"
        btn.setOnClickListener {
            Weath.add(Info)
        }



    }

    override fun onDestroy() {
        super.onDestroy();
        val mPrefs = getSharedPreferences("MyWeather", AppCompatActivity.MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = mPrefs.edit()
        val gson = Gson()
        val json = gson.toJson(Weath)
        prefsEditor.putString("MyWeather", json)
        prefsEditor.apply()
    }
}