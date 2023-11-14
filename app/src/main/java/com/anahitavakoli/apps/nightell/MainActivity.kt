package com.anahitavakoli.apps.nightell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anahitavakoli.apps.nightell.adapter.PagerAdapter
import com.anahitavakoli.apps.nightell.config.AppConfig
import com.anahitavakoli.apps.nightell.databinding.ActivityMainBinding
import com.anahitavakoli.apps.nightell.ui.category.CategoryFragment
import com.anahitavakoli.apps.nightell.ui.favorite.FavoriteFragment
import com.anahitavakoli.apps.nightell.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppConfig.applicationContext()

        val listFragment = mutableListOf<Fragment>()
        listFragment.add(HomeFragment())
        listFragment.add(CategoryFragment())
        listFragment.add(FavoriteFragment())

        binding.mainViewPager.adapter = PagerAdapter(this@MainActivity,listFragment)

        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_home -> binding.mainViewPager.currentItem= 0
                R.id.item_category -> binding.mainViewPager.currentItem= 1
                R.id.item_favorite -> binding.mainViewPager.currentItem= 2
            }
            true
        }

        binding.mainViewPager.registerOnPageChangeCallback(object:
            ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> binding.bottomMenu.menu.findItem(R.id.item_home).isChecked = true
                    1 -> binding.bottomMenu.menu.findItem(R.id.item_category).isChecked = true
                    2 -> binding.bottomMenu.menu.findItem(R.id.item_favorite).isChecked = true
                }
            }

        })

    }
}