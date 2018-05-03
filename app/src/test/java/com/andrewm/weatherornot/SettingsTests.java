package com.andrewm.weatherornot;

import android.content.Context;

import com.andrewm.weatherornot.data.local.ForecastRepo;
import com.andrewm.weatherornot.data.model.forecast.ForecastSettings;
import com.andrewm.weatherornot.ui.settings.SettingsMvvm;
import com.andrewm.weatherornot.ui.settings.SettingsViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class SettingsTests {

    @Mock
    Context context;

    @Mock
    ForecastRepo forecastRepo;

    @Mock
    SettingsMvvm.View settingsView;
    SettingsViewModel settingsViewModel;

    ForecastSettings settings = new ForecastSettings();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        doReturn(settings).when(forecastRepo).getForecastSettings(false);

        settingsViewModel = new SettingsViewModel(context, forecastRepo);
        settingsViewModel.attachView(settingsView, null);
    }

    @Test
    public void toggleTemperatureScaleSetting() {
        settingsViewModel.setSettings(settings);
        settingsViewModel.updateTemperatureScaleSetting();
        verify(forecastRepo).save(settings);
    }
}
