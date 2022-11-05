package com.example.asyncapp

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel()  {

    private val mutableCounter = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = mutableCounter

    private val mutableInProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> get() = mutableInProgress

    private val timer = object: CountDownTimer(4000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            mutableCounter.value = mutableCounter.value?.plus(1)
        }

        override fun onFinish() {
            mutableInProgress.value = false
        }
    }

    fun start() {
        mutableCounter.value = 0
        mutableInProgress.value = true
        timer.start()
    }
}