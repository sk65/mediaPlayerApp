package com.yefimoyevhen.mediaplayerapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavView()
        setSupportActionBar(toolbar)
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)
       // supportActionBar?.setHomeButtonEnabled(true)
        bottom_nav_view.setupWithNavController(findNavController(R.id.fragment))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initNavView() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true;
        toggle.syncState()
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                //TODO

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
