package xyz.teamgravity.containertransformtransitionfab.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import xyz.teamgravity.containertransformtransitionfab.NavigationDirections
import xyz.teamgravity.containertransformtransitionfab.R
import xyz.teamgravity.containertransformtransitionfab.core.extension.navigateSafely
import xyz.teamgravity.containertransformtransitionfab.databinding.ActivityMainBinding

class Main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation()
        button()
    }

    private fun navigation() {
        controller = (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
        binding.bottomNavigation.setupWithNavController(controller)
    }

    private fun button() {
        onAdd()
    }

    private fun onAdd() {
        binding.addB.setOnClickListener {
            controller.navigateSafely(NavigationDirections.actionGlobalArticleAdd())
        }
    }
}