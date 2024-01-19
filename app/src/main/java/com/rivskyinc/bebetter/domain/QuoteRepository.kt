package com.rivskyinc.bebetter.domain

import com.rivskyinc.bebetter.domain.entities.Quotes

interface QuoteRepository {

    suspend fun getLastQuote() : Quotes
}