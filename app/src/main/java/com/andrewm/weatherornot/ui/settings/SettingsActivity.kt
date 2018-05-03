package com.andrewm.weatherornot.ui.settings

import android.os.Bundle
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.databinding.ActivitySettingsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity

class SettingsActivity : BaseActivity<ActivitySettingsBinding, SettingsViewModel>(), SettingsMvvm.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAndBindContentView(savedInstanceState, R.layout.activity_settings)
//        setSupportActionBar(binding.toolbar)

    }
}
