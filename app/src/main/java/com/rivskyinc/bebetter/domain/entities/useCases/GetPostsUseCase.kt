package com.rivskyinc.bebetter.domain.entities.useCases

import com.rivskyinc.bebetter.domain.BlogRepository
import com.rivskyinc.bebetter.domain.entities.Blog

class GetPostsUseCase(private val blogRepository : BlogRepository) {

    suspend fun invoke() : Blog {
       return  blogRepository.getPosts()
    }
}