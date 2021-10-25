package com.fghilmany.dietmealapp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    val liveData: LiveData<SplashState>
        get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<SplashState>()
    init {
        GlobalScope.launch {
            mutableLiveData.postValue(SplashState.InitSplash)
            delay(2800)
            mutableLiveData.postValue(SplashState.MainActivity)
        }
    }
}

sealed class SplashState {
    object InitSplash : SplashState()
    object MainActivity : SplashState()
}