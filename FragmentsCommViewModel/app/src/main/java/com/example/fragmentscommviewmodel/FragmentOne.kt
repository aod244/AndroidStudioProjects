package com.example.fragmentscommviewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentOne : Fragment() {

    // Using the activityViewModels() Kotlin property delegate from the
    // fragment-ktx artifact to retrieve the ViewModel in the activity scope
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragement_one, container, false) as
                ViewGroup

        val editTextView = rootView.findViewById<TextView>(R.id.editText)

        val btn = rootView.findViewById<Button>(R.id.btnSend)
        btn.setOnClickListener {
            val textToPass = editTextView?.text.toString()
            Log.d("FragmentOne", textToPass)

            viewModel.setText(textToPass)
        }
        return rootView
    }
}