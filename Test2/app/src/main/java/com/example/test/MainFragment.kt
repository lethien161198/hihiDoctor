package com.example.test

import android.content.Intent
import android.view.Gravity
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.test.adapter.BottomAdapter
import com.example.test.base.BaseFragment
import com.example.test.databinding.FragmentMainBinding
import com.example.test.view.*
import com.example.test.view.author.LoginFragment
import com.example.test.view.author.RegisterFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.header_title.view.*

class MainFragment : BaseFragment<FragmentMainBinding>(),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var bottomvar: BottomNavigationView
    private lateinit var fab: FloatingActionButton
    private lateinit var navigationView: NavigationView
    override fun initComponent(viewBinding: FragmentMainBinding) {
        drawer = viewBinding.drawerLayout
        viewPager2 = viewBinding.viewPager

        bottomvar = viewBinding.bottomNavigationView
        bottomvar.selectedItemId = R.id.placeholder
        bottomvar.background = null
        bottomvar.menu.getItem(2).isEnabled = false
        bottomvar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miNone -> {
                    viewPager2.setCurrentItem(1, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.miNotif -> {
                    viewPager2.setCurrentItem(1, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.miHistory -> {
                    viewPager2.setCurrentItem(1, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.miMe -> {
                    viewPager2.setCurrentItem(1, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }

        navigationView = viewBinding.navView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_home)

        fab = viewBinding.fab
        fab.setOnClickListener {
            viewPager2.setCurrentItem(0, false)
            navigationView.setCheckedItem(R.id.nav_home)
            bottomvar.selectedItemId = R.id.placeholder
        }

        viewBinding.header.title.text = "My App"
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_menu)
        viewBinding.header.btnLeft.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        setViewPager()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    private fun setViewPager() {
        val bottomAdapter = BottomAdapter(context as FragmentActivity)

        bottomAdapter.addFragment(HomeFragment())   //0
        bottomAdapter.addFragment(RegisterFragment())   //1
        bottomAdapter.addFragment(LoginFragment())   //2
        viewPager2.adapter = bottomAdapter
        viewPager2.isUserInputEnabled = false

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                viewPager2.setCurrentItem(0, false)
                bottomvar.selectedItemId = R.id.placeholder
            }
            R.id.nav_search -> {
                viewPager2.setCurrentItem(1, false)
                bottomvar.selectedItemId = R.id.placeholder
            }
            R.id.nav_setting -> {
                viewPager2.setCurrentItem(2, false)
                bottomvar.selectedItemId = R.id.placeholder
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPress() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            activity?.onBackPressed()
        }
    }
}