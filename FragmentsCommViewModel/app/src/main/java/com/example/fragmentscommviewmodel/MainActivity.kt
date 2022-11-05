package com.example.fragmentscommviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {


    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentOne,
            FragmentOne()
        ).commit()

        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentTwo,
            FragmentTwo()
        ).commit()

        viewModel.outputText.observe(this) { _ ->
            // Perform an action with the latest item data
        }
    }
}