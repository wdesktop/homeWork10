package com.example.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    var fragment: Fragment? = null
    lateinit var bottomNavigatorView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigatorView = findViewById(R.id.bottom_navigation_view)

        bottomNavigatorView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_one -> {fragment = OneFragment()}
                R.id.menu_two -> {fragment = TwoFragment()}
            }
            replaceFragment(fragment!!)

            true
        }
        bottomNavigatorView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.menu_one


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigatorView.selectedItemId)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}