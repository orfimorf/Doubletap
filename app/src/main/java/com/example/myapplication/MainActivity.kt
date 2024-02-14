package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<TextView>(R.id.textView).text = Storage.getNumber().toString()

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.i("MainActivity", "Переход на вторую страницу")
            Storage.switchChange()
            val sendIntent = Intent(this, SecondActivity::class.java).apply {  }
            startActivity(sendIntent)
        }

        Log.i("MainActivity", "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if(Storage.getChange()) {
            Log.i("MainActivity", "+1 к значению")
            Storage.plusNumber()
        }
        Log.i("MainActivity", "onSaveInstanceState")
        outState.putInt("valueCounter", Storage.getNumber())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MainActivity", "onRestoreInstanceState")
        Storage.setNumber(savedInstanceState.getInt("valueCounter"))
    }


}