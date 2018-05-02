package com.andrewm.weatherornot.ui.base.navigation

import android.app.Activity
import android.content.Intent

interface Navigator {
    fun startActivity(intent: Intent)
    fun startActivity(activityClass: Class<out Activity>, adaptIntentFun: (Intent.() -> Unit)? = null)

    fun finishActivity()
}