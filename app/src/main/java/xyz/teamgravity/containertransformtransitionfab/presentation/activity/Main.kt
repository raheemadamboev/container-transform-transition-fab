package xyz.teamgravity.containertransformtransitionfab.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.teamgravity.containertransformtransitionfab.databinding.ActivityMainBinding

class Main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}