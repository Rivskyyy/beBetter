package com.rivskyinc.bebetter.domain

import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.domain.entities.Quotes

interface FirebaseApi {
    suspend fun getPosts(): Blog
    suspend fun getQuote(): Quotes
}