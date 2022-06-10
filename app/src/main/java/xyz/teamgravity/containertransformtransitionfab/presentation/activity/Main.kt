package xyz.teamgravity.containertransformtransitionfab.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.transition.MaterialElevationScale
import xyz.teamgravity.containertransformtransitionfab.NavigationDirections
import xyz.teamgravity.containertransformtransitionfab.R
import xyz.teamgravity.containertransformtransitionfab.core.constant.Const
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
        binding.apply {
            controller = (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
            bottomNavigation.setupWithNavController(controller)
            controller.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.articleList, R.id.favoriteList -> {
                        bottomNavigation.visibility = View.VISIBLE
                        addB.visibility = View.VISIBLE
                    }
                    else -> {
                        bottomNavigation.visibility = View.GONE
                        addB.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun button() {
        onAdd()
    }

    private fun transition() { // holds layout, when making transition
        supportFragmentManager.findFragmentById(R.id.fragment_container)
            ?.childFragmentManager
            ?.fragments
            ?.first()
            ?.apply {
                exitTransition = MaterialElevationScale(false).apply { duration = Const.DURATION_TRANSITION }
                reenterTransition = MaterialElevationScale(true).apply { duration = Const.DURATION_TRANSITION }
            }
    }

    private fun onAdd() {
        binding.addB.setOnClickListener {
            transition()
            controller.navigateSafely(NavigationDirections.actionGlobalArticleAdd())
        }
    }
}