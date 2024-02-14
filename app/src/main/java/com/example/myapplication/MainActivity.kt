package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<TextView>(R.id.textView).text = Storage.getNumber().toString()

        findViewById<Button>(R.id.button).setOnClickListener {
            Storage.switchChange()
            val sendIntent = Intent(this, SecondActivity::class.java).apply {  }
            startActivity(sendIntent)


        }


    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.textView).text = Storage.getNumber().toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if(Storage.getChange()) Storage.plusNumber()
        outState.putInt("valueCounter", Storage.getNumber())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Storage.setNumber(savedInstanceState.getInt("valueCounter"))
    }




}