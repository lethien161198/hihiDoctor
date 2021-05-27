package com.example.test.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val mListFragment = mutableListOf<Fragment>()
    override fun getItemCount(): Int {
        return mListFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return mListFragment[position]
    }

    fun addFragment(fragment: Fragment) {
        mListFragment.add(fragment)
    }
}