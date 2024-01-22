package com.rivskyinc.bebetter.di



import com.rivskyinc.bebetter.data.repositoryImpl.FirebaseImpl

import com.rivskyinc.bebetter.domain.FirebaseApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


//    @Provides
//    @Singleton
//    fun provideMyApi(): BlogApi {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(BlogApi::class.java)
//    }

    @Provides
    fun provideFirebaseApi(): FirebaseApi {
        return FirebaseImpl()
    }
//    @Provides
//    fun bindsRepository(api: BlogApi): BlogRepository {
//        return BlogRepositoryImpl(api)
//    }

//    @Provides
//    fun providesUseCase(repository: FirebaseApi): GetPostsUseCase {
//        return GetPostsUseCase(repository)
//    }


}