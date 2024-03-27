package com.example.contactmanagerapp

import android.content.Intent // Import Intent class
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // Corrected delayMillis instead of delayMills3000
        Handler().postDelayed({
            // Corrected intent creation syntax
            val intent = Intent(this, second::class.java)
            startActivity(intent)
            finish()
        }, 3000) // Corrected delayMillis
    }
}
