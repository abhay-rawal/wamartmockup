package com.example.walmart

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.walmart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val user1 = User("John", "Doe", "johndoe1@gmail.com", "pass123")
        val user2 = User("Jane", "Smith", "janesmith2@gmail.com", "pass456")
        val user3 = User("Alice", "Johnson", "alicej3@gmail.com", "pass789")
        val user4 = User("Bob", "Brown", "bobbrown4@gmail.com", "pass012")
        val user5 = User("Abhay", "Rawal", "abhayrwl@gmail.com", "pass345")
        val user6 = User("a", "b", "a@gmail.com", "a")

        val users = mutableListOf(user1, user2, user3, user4,user5,user6)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signInButton.setOnClickListener{
            val userName = binding.email.text.toString()
            val password = binding.pwd.text.toString()
            val userExists = users.any{
                user -> user.userName.toString() == userName && user.password.toString() == password
            }
            if (userExists)
            {
                val intent = Intent(this,ShoppingActivity::class.java)
                intent.putExtra("username",userName)
                startActivity(intent)
            }
            else Toast.makeText(this,"Incorrect Pwd $userName $password",Toast.LENGTH_LONG).show()
        }

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
                result ->
            if (result.resultCode == Activity.RESULT_OK)
            {
                val data = result.data?.getSerializableExtra("user_account") as User
                if (data != null) {
                    users.add(data)
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Failed to get user data", Toast.LENGTH_LONG).show()
                }
            }
            else
                Toast.makeText(this,"Filed",Toast.LENGTH_LONG).show()
        }

        binding.createAccountBtn.setOnClickListener{
            var intent = Intent(this,RegisterActivity::class.java)
            resultContracts.launch(intent)
        }
        binding.forgotPwd.setOnClickListener{
            val email = binding.email.text.toString();
            var pwd = users.firstOrNull { it.userName == email }?.password

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,pwd)
            try {
                startActivity(Intent.createChooser(intent, "Share using"))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show()
            }

        }
    }

}