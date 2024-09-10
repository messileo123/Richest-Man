package com.example.richestman

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.richestman.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        val name = intent.getSerializableExtra("name")
        val  age= intent.getSerializableExtra("age")
        val networth = intent.getSerializableExtra("networth")
        val img = intent.getSerializableExtra("img")
        val desc= intent.getSerializableExtra("desc")
        binding.apply {
            ManName.text = name.toString()
            MAnAge.text = "age : 60"
            Networht.text = "networht: 5B$"
            ManImg.setImageResource(img as Int)
            manDesc.text = desc.toString()
        }

        }
    }
