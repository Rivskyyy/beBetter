package com.rivskyinc.bebetter.domain.entities.useCases

import com.rivskyinc.bebetter.domain.QuoteRepository
import com.rivskyinc.bebetter.domain.entities.Quotes

class GetQuoteUseCase(private val quoteRepository: QuoteRepository){

    suspend fun invoke() : Quotes{
        return quoteRepository.getLastQuote()
    }
}