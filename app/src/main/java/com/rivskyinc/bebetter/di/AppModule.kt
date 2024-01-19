package com.rivskyinc.bebetter.di

import com.rivskyinc.bebetter.Utils.BASE_URL
import com.rivskyinc.bebetter.data.BlogApi
import com.rivskyinc.bebetter.data.repositoryImpl.BlogRepositoryImpl
import com.rivskyinc.bebetter.domain.BlogRepository
import com.rivskyinc.bebetter.domain.useCases.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMyApi(): BlogApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlogApi::class.java)
    }


    @Provides
    fun bindsRepository(api: BlogApi): BlogRepository {
        return BlogRepositoryImpl(api)
    }

    @Provides
    fun providesUseCase(repository: BlogRepository): GetPostsUseCase {
        return GetPostsUseCase(repository)
    }


}