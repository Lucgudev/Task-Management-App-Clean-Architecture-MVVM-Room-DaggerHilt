package com.lucgu.taskme

import android.app.Application
import androidx.compose.runtime.Stable
import dagger.hilt.android.HiltAndroidApp

@Stable
@HiltAndroidApp
class BaseApplication : Application() {

}