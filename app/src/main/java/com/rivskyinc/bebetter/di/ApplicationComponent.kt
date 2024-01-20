package com.rivskyinc.bebetter.di

import android.app.Application
import com.rivskyinc.bebetter.presentation.mainFragment.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

    @Component(modules = [AppModule::class])
    @Singleton
    interface ApplicationComponent {
        fun inject( activity  : MainFragment)

        @Component.Factory
        interface Factory {

            fun create (
                @BindsInstance application : Application
            ) : ApplicationComponent
        }

    }
