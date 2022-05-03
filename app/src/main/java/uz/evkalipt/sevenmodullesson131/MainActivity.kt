package uz.evkalipt.sevenmodullesson131

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import eightbitlab.com.blurview.RenderScriptBlur
import uz.evkalipt.sevenmodullesson131.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appBarMain.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }
        binding.navView.itemIconTintList = null
        binding.bottomNav.itemIconTintList = null
        binding.appBarMain.titleTv.text = "Home"
        var navController = findNavController(R.id.fragment)

        binding.appBarMain.randomToolbar.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.thirdFragment)
            binding.appBarMain.titleTv.text = "Random"
            binding.appBarMain.search.visibility = View.INVISIBLE
            binding.appBarMain.randomToolbar.visibility = View.VISIBLE
        }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_bottom->{
                    navController.navigateUp()
                    navController.navigate(R.id.firstFragment)
                    binding.appBarMain.titleTv.text = "Home"
                    binding.appBarMain.search.visibility = View.VISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
                R.id.popular_bottom->{
                    navController.navigateUp()
                    navController.navigate(R.id.secondFragment)
                    binding.appBarMain.titleTv.text = "Popular"
                    binding.appBarMain.search.visibility = View.VISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
                R.id.random_bottom->{
                    navController.navigateUp()
                    navController.navigate(R.id.thirdFragment)
                    binding.appBarMain.titleTv.text = "Random"
                    binding.appBarMain.search.visibility = View.INVISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.VISIBLE
                }
                R.id.liked_bottom->{
                    navController.navigateUp()
                    navController.navigate(R.id.fourthFragment)
                    binding.appBarMain.titleTv.text = "My Favourites"
                    binding.appBarMain.search.visibility = View.INVISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
            }
            true
        }
        binding.navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home->{
                    navController.navigateUp()
                    navController.navigate(R.id.firstFragment)
                    binding.appBarMain.titleTv.text = "Home"
                    binding.drawerLayout.closeDrawers()
                    binding.bottomNav.selectedItemId = R.id.home_bottom
                    binding.appBarMain.search.visibility = View.VISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
                R.id.popular->{
                    navController.navigateUp()
                    navController.navigate(R.id.secondFragment)
                    binding.appBarMain.titleTv.text = "Popular"
                    binding.drawerLayout.closeDrawers()
                    binding.bottomNav.selectedItemId = R.id.popular_bottom
                    binding.appBarMain.search.visibility = View.VISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
                R.id.random->{
                    navController.navigateUp()
                    navController.navigate(R.id.thirdFragment)
                    binding.appBarMain.titleTv.text = "Random"
                    binding.drawerLayout.closeDrawers()
                    binding.bottomNav.selectedItemId = R.id.random_bottom
                    binding.appBarMain.search.visibility = View.INVISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.VISIBLE
                }
                R.id.liked->{
                    navController.navigateUp()
                    navController.navigate(R.id.fourthFragment)
                    binding.appBarMain.titleTv.text = "My Favourites"
                    binding.drawerLayout.closeDrawers()
                    binding.bottomNav.selectedItemId = R.id.liked_bottom
                    binding.appBarMain.search.visibility = View.INVISIBLE
                    binding.appBarMain.randomToolbar.visibility = View.INVISIBLE
                }
            }

            true
        }

        val radius = 24f

        val decorView: View = window!!.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background

        binding.blurView.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurView.clipToOutline = true

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment).navigateUp()
    }

    override fun onBackPressed() {

        if (binding.bottomNav.selectedItemId!=R.id.home_bottom){
            binding.bottomNav.selectedItemId = R.id.home_bottom
        }

        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()

        }
    }
}