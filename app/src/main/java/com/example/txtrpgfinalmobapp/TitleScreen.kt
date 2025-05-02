package com.example.txtrpgfinalmobapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button  // Add this import

class TitleScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_title_screen)



        // Initialize the button using findViewById
        val startButton: Button = findViewById(R.id.startButton)

        // Set click listener for the button
        //startButton.setOnClickListener {
        //    val intent = Intent(this, GameScreen::class.java)
        //    startActivity(intent)
        //}
//not sure which works better
        startButton.setOnClickListener()
        {
            // Launch GameScreen when button is clicked
            startActivity(Intent(this, GameScreen::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}