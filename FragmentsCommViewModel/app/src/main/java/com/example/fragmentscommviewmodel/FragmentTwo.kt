package com.example.fragmentscommviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentTwo : Fragment() {

    // Using the activityViewModels() Kotlin property delegate from the
    // fragment-ktx artifact to retrieve the ViewModel in the activity scope
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragement_two, container, false)

        viewModel.outputText.observe(viewLifecycleOwner) { inputText ->
            // Update the selected filters UI
            val tv = rootView.findViewById<TextView>(R.id.outPutTextView)
            tv.text = inputText
        }
        return rootView
    }

}