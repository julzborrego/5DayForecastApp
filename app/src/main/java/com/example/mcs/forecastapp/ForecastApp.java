package com.example.mcs.forecastapp;

import android.app.Application;

import com.example.mcs.forecastapp.Repo.ForecastAPI;
import com.example.mcs.forecastapp.Repo.ForecastRepo;

/**
 * Android Application class to hold repo singleton
 */
public class ForecastApp extends Application {

    ForecastRepo forecastRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        forecastRepo= ForecastAPI.getInstance(this);
    }

    public ForecastRepo getForecastRepo() {
        return forecastRepo;
    }

}