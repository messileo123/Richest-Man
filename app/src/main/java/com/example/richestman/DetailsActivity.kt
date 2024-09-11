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


        val Name = intent.getStringExtra("name")
        val Age = intent.getStringExtra("age")
        val Netw = intent.getStringExtra("networth")
        val Img = intent.getIntExtra("img", 0)
        val Desc = intent.getStringExtra("desc")
        binding.apply {
            ManName.text = "name : $Name"
            MAnAge.text = "age : " + Age
            Networht.text = "networht: $Netw B$"
            ManImg.setImageResource(Img)
            manDesc.text = "desc : $Desc"
        }

    }
}
