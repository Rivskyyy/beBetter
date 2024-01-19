package com.rivskyinc.bebetter.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.domain.entities.Quotes
import com.rivskyinc.bebetter.domain.useCases.GetPostsUseCase
import com.rivskyinc.bebetter.domain.useCases.GetQuoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase,
                                        private val getQuoteUseCase: GetQuoteUseCase): ViewModel() {

    private var _postsList= MutableLiveData<Blog>()
    val postsList : LiveData<Blog> = _postsList

    private var _quote= MutableLiveData<Quotes>()
    val quote : LiveData<Quotes> = _quote

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getAllPosts()
                getQuote()
            }
        }
    }

    private suspend fun getQuote() {
        try {
            val data = getQuoteUseCase.invoke()
            Log.d("MainViewModel", data.toString())
            _quote.postValue(data)
        } catch (e: HttpException) {
            throw RuntimeException("HttpException : $e ")
        } catch (e: IOException) {
            throw RuntimeException("IOException : $e ")
        }
    }

    private suspend fun getAllPosts() {
            try {
                val data = getPostsUseCase.invoke()
                Log.d("MainViewModel", data.toString())
                _postsList.postValue(data)
            } catch (e: HttpException) {
                throw RuntimeException("HttpException : $e ")
            } catch (e: IOException) {
                throw RuntimeException("IOException : $e ")
            }
        }

    }
