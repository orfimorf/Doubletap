package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SecondActivity", "Отрисовка второй страницы")
        setContentView(R.layout.activity_second)
        findViewById<TextView>(R.id.textView2).text =
            Storage.getNumber().toDouble().pow(2.toDouble()).toString()

        findViewById<Button>(R.id.backButton).setOnClickListener {
            Log.i("SecondActivity", "Закрытие второй страницы")
            Storage.switchChange()
            this.finish()
        }

    }

}