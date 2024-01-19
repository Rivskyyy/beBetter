package com.rivskyinc.bebetter.presentation

import android.app.Application
import com.rivskyinc.bebetter.di.DaggerApplicationComponent

class BlogApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}