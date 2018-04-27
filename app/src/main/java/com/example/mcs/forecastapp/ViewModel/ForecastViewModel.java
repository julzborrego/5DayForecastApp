package com.example.mcs.forecastapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mcs.forecastapp.ForecastApp;
import com.example.mcs.forecastapp.Model.ForecastModel;

public class ForecastViewModel extends ViewModel {

    //The observable data field
    private LiveData<ForecastModel> forecastModel;

    //if the forecast model hasnt already been loaded, then load from the app's repository
    public void loadForecast(Application app){
        if(forecastModel==null) forecastModel = ((ForecastApp)app).getForecastRepo().getForecastModel();
    }

    //The accesor method for the forecast model to be observed
    public LiveData<ForecastModel> getForecastModel() { return forecastModel; }
}
