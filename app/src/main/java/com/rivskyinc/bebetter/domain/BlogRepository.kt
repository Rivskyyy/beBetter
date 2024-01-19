package com.rivskyinc.bebetter.domain

import com.rivskyinc.bebetter.domain.entities.Blog

interface  BlogRepository {

    suspend fun getPosts() : Blog
}