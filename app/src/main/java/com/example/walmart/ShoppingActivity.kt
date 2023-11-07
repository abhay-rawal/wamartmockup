package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.walmart.databinding.ActivityMainBinding
import com.example.walmart.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tempName = intent.getStringExtra("username")
        binding.userNameDisplay.text = tempName.toString();
    }

    fun showToast(view: View) {
        when (view.id)
        {
            binding.imageView2.id  -> Toast.makeText(this, "You have chosen the Electronic category", Toast.LENGTH_LONG).show()
            binding.imageView3.id  -> Toast.makeText(this, "You have chosen the food category", Toast.LENGTH_LONG).show()
            binding.imageView4.id  -> Toast.makeText(this, "You have chosen the Beauty category", Toast.LENGTH_LONG).show()
            binding.imageView5.id  -> Toast.makeText(this, "You have chosen the clothing category", Toast.LENGTH_LONG).show()
        }

    }
}