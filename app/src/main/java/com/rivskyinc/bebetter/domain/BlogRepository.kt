package com.rivskyinc.bebetter.domain

interface  BlogRepository {

    suspend fun getLatestPosts() : Blog
}