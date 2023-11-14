package com.anahitavakoli.apps.nightell.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity, fragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = fragments

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragmentList.get(position)
    }

}