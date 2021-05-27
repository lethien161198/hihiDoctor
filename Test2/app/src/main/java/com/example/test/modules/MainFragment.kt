package com.example.test.modules

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.test.R
import com.example.test.adapter.BottomAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentMainBinding
import com.example.test.modules.view.*
import com.example.test.modules.view.doctors.DoctorsFragment
import com.example.test.modules.view.tutorial.QuestionFragment
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
        bottomvar.selectedItemId = R.id.miHome
        bottomvar.background = null
        bottomvar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> {
                    viewPager2.setCurrentItem(0, false)
                    navigationView.setCheckedItem(R.id.nav_home)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.miAdmin -> {
                    viewPager2.setCurrentItem(1, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.miArticles -> {
                    viewPager2.setCurrentItem(2, false)
                    navigationView.setCheckedItem(R.id.placeholder)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.miTutorial -> {
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

        viewBinding.header.title.text = "Hihi Doctor"
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
        bottomAdapter.addFragment(DoctorsFragment())   //1
        bottomAdapter.addFragment(ArticlesFragment())   //1
        viewPager2.adapter = bottomAdapter
        viewPager2.isUserInputEnabled = false

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                viewPager2.setCurrentItem(0, false)
                bottomvar.selectedItemId = R.id.miHome
            }
            R.id.nav_about -> {
                viewPager2.setCurrentItem(1, false)
                bottomvar.selectedItemId = R.id.placeholder1
            }
            R.id.nav_setting -> {
                viewPager2.setCurrentItem(1, false)
                bottomvar.selectedItemId = R.id.placeholder1
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