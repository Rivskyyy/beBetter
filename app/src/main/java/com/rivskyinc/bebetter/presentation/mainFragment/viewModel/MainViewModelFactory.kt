package com.rivskyinc.bebetter.presentation.mainFragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.bebetter.domain.FirebaseApi
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val firebaseApi: FirebaseApi) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(firebaseApi) as T
        }
        throw RuntimeException("Unknown ViewModel class $modelClass")
    }

                                              }