package com.app.exampletesting.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.exampletesting.R
import com.app.exampletesting.databinding.ActivityMainBinding
import com.app.exampletesting.ui.other.NewTask
import com.app.exampletesting.workers.*
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.new_task.*
import kotlinx.android.synthetic.main.row_text.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var fragment: Fragment
    private val viewModel : CompletedTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener {
            val intent = Intent(this,NewTask::class.java)
            startActivity(intent)
        }
        navigationView = binding.navView
        drawerLayout = binding.drawer
        toolbar = binding.toolbar.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val allFragment = AllFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFram,allFragment).commit()

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_task -> {
                    Toast.makeText(applicationContext, "Task lists", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.actions_statistics -> {
                    Toast.makeText(applicationContext, "Statics", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_action_button, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.action_all -> {
                fragment = AllFragment()
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.mainFram, fragment)
                ft.commit()
            }
            R.id.action_active -> {
                fragment = ActiveFragment()
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.mainFram, fragment)
                ft.commit()
            }
            R.id.action_completed -> {
                fragment = CompletedFragment()
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.mainFram, fragment)
                ft.commit()
            }
        }
        return true
    }
}