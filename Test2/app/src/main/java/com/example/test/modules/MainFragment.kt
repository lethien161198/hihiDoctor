package com.example.test.modules

import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.test.R
import com.example.test.adapter.BottomAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentMainBinding
import com.example.test.modules.view.*
import com.example.test.modules.view.articles.ArticlesFragment
import com.example.test.modules.view.author.signIn.SignInFragment
import com.example.test.modules.view.doctors.DoctorsFragment
import com.example.test.modules.view.home.HomeFragment
import com.example.test.modules.view.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.header_title.view.*

class MainFragment : BaseFragment<FragmentMainBinding,MainViewModel>(MainViewModel::class.java),
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

                R.id.placeholder -> {

                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }


        viewBinding.header.title.text = "Hihi Doctor"
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_menu)
        viewBinding.header.btnLeft.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        setViewPager()

        navigationView = viewBinding.navView
        navigationView.setNavigationItemSelectedListener(this)
        if(viewPager2.currentItem == 0){
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    private fun setViewPager() {
        val bottomAdapter = BottomAdapter(context as FragmentActivity)

        bottomAdapter.addFragment(HomeFragment())   //0
        bottomAdapter.addFragment(ArticlesFragment())   //1
        bottomAdapter.addFragment(ArticlesFragment())   //1
        viewPager2.adapter = bottomAdapter
        viewPager2.isUserInputEnabled = false

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                viewPager2.setCurrentItem(0, false)
                bottomvar.selectedItemId = R.id.miHome
            }
            R.id.nav_about -> {
                viewPager2.setCurrentItem(1, false)
                bottomvar.selectedItemId = R.id.placeholder
            }
            R.id.nav_setting -> {
                viewPager2.setCurrentItem(1, false)
                bottomvar.selectedItemId = R.id.placeholder
            }
            R.id.nav_logout -> {
                val builder = context?.let { AlertDialog.Builder(it) }
                builder?.setTitle("Log Out")
                builder?.setMessage("Are you sure ?")

                builder?.setPositiveButton("Yes") { dialog, which ->
                    showMessage("LogOut")
                    replaceFragment(SignInFragment(),"",false)
                }

                builder?.setNegativeButton("No") { dialog, which ->
                    showMessage("no")
                }
                builder?.show()
                bottomvar.selectedItemId = R.id.miHome
            }
            R.id.nav_profile -> {
                bottomvar.selectedItemId = R.id.miHome
                replaceFragment(ProfileFragment(),"profilefragment",true)
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