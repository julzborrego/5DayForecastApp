package com.example.mcs.forecastapp.Repo;

import android.arch.lifecycle.LiveData;

import com.example.mcs.forecastapp.Model.ForecastModel;

/***
 * Repo needs to load the Forecast Model
 */
public interface ForecastRepo {
    public LiveData<ForecastModel> getForecastModel();
}
