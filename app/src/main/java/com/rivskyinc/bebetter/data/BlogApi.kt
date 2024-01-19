package com.rivskyinc.bebetter.data

import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.domain.entities.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface BlogApi {
    @GET("posts.json")
    suspend fun getPostsResponse(): Response<Blog>

    @GET("quotes.json")
    fun getQuoteResponse() : Response<Quotes>
}