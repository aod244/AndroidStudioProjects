package com.example.fragmentscommviewmodel
import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<String>()
    val outputText: LiveData<String> get() = mutableSelectedItem

    fun setText(txt: String) {
        mutableSelectedItem.value = txt
    }
}