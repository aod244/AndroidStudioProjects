package com.example.asyncapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    private val viewModel: ProgressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDoAsync = findViewById<Button>(R.id.btnDoAsync)

        val pb = findViewById<ProgressBar>(R.id.progressBar)

        viewModel.counter.observe(this) { c ->
            // Update the selected filters UI
            val tx = findViewById<TextView>(R.id.textView)
            tx.text = c.toString()
        }

        viewModel.inProgress.observe(this) { isInProgress ->
            if (isInProgress) {
                pb.visibility = View.VISIBLE
            } else {
                pb.visibility = View.GONE
            }
        }

        btnDoAsync.setOnClickListener {
            viewModel.start()
        }
    }
}