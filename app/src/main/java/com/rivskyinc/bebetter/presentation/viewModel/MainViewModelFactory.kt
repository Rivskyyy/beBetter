package com.rivskyinc.bebetter.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.bebetter.domain.useCases.GetPostsUseCase
import com.rivskyinc.bebetter.domain.useCases.GetQuoteUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val getPostsUseCase: GetPostsUseCase,
                                              private val getQuoteUseCase: GetQuoteUseCase ) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getPostsUseCase, getQuoteUseCase) as T
        }
        throw RuntimeException("Unknown ViewModel class $modelClass")
    }

                                              }