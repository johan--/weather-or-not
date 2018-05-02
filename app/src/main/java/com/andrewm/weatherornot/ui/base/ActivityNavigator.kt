package com.andrewm.weatherornot.ui.base

import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentActivity

open class ActivityNavigator(protected val activity: FragmentActivity) : Navigator {

    override fun finishActivity() {
        activity.finish()
    }

    override fun startActivity(intent: Intent) {
        activity.startActivity(intent)
    }

    override fun startActivity(activityClass: Class<out Activity>, adaptIntentFun: (Intent.() -> Unit)?) {
        startActivityInternal(activityClass, null, adaptIntentFun)
    }

    private fun startActivityInternal(activityClass: Class<out Activity>, requestCode: Int?, adaptIntentFun: (Intent.() -> Unit)?) {
        val intent = Intent(activity, activityClass)
        adaptIntentFun?.invoke(intent)

        if (requestCode != null) {
            activity.startActivityForResult(intent, requestCode)
        } else {
            activity.startActivity(intent)
        }
    }
}