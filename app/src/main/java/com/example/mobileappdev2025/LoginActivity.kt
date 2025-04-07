package com.example.mobileappdev2025

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*firebaseAuth = Firebase.auth;

        val loginButton = findViewById<Button>(R.id.login_button);

        loginButton.setOnClickListener{
            val emailEditText = findViewById<EditText>(R.id.email_edit_text);
            val passwordEditText = findViewById<EditText>(R.id.password_edit_text);

            val email = emailEditText.text.toString();
            val password = passwordEditText.text.toString();

            // check if email or password is empty

            /*firebaseAuth.signInWithEmailAndPassword(email, password)
                .setOnCompleteListener(this) { task ->
                    
                }*/
        };*/
    }
}