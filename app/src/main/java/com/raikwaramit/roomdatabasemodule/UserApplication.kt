package com.raikwaramit.roomdatabasemodule

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * For providing the application context anywhere.
 */
@HiltAndroidApp
class UserApplication : Application()