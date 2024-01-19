package com.rivskyinc.bebetter.data.repositoryImpl

import com.rivskyinc.bebetter.data.BlogApi
import com.rivskyinc.bebetter.domain.BlogRepository
import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.domain.entities.Quotes
import retrofit2.Response


class BlogRepositoryImpl(private val blogApi : BlogApi) : BlogRepository {
    override suspend fun getPosts(): Blog {
        return try {
            val response: Response<Blog> = blogApi.getPostsResponse()

            if (response.isSuccessful) {
                response.body() ?: throw RuntimeException("Response body is null")
            } else {
                throw RuntimeException("Unsuccessful response: ${response.code()}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Error fetching data: ${e.message}")
        }
    }

    override suspend fun getLastQuote(): Quotes {
        return try {
            val response: Response<Quotes> = blogApi.getQuoteResponse()

            if (response.isSuccessful) {
                response.body() ?: throw RuntimeException("Response body is null")
            } else {
                throw RuntimeException("Unsuccessful response: ${response.code()}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Error fetching data: ${e.message}")
        }
    }
}