package com.example.walmart

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walmart.databinding.ActivityRegisterBinding
import com.example.walmart.databinding.ActivityShoppingBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccountBtn.setOnClickListener{
            val firstname = binding.fname.text.toString()
            val lastname = binding.lname.text.toString()
            val email = binding.email.text.toString()
            val pwd = binding.password.text.toString()
            val account = User(firstname,lastname,email,pwd)

            val rintent = intent;
            rintent.putExtra("user_account",account);
            setResult(Activity.RESULT_OK,rintent)
            finish()
        }
    }
}