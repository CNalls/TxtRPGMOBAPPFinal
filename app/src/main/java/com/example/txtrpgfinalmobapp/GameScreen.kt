package com.example.txtrpgfinalmobapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Story AFTER setContentView
        val story = Story(this)

        val choiceButton1: Button = findViewById(R.id.choiceButton1)
        val choiceButton2: Button = findViewById(R.id.choiceButton2)
        val choiceButton3: Button = findViewById(R.id.choiceButton3)
        val choiceButton4: Button = findViewById(R.id.choiceButton4)


        choiceButton1.setOnClickListener{

            story.selectPosition(story.nextPosition1)

        }
        choiceButton2.setOnClickListener{

            story.selectPosition(story.nextPosition2)

        }
        choiceButton3.setOnClickListener{

            story.selectPosition(story.nextPosition3)

        }
        choiceButton4.setOnClickListener{

            story.selectPosition(story.nextPosition4)

        }

        story.startingPoint()
    }
}