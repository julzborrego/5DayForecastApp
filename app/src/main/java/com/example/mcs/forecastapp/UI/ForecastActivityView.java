package com.example.mcs.forecastapp.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;

import com.example.mcs.forecastapp.Model.DayModel;
import com.example.mcs.forecastapp.Model.ForecastModel;
import com.example.mcs.forecastapp.ViewModel.ForecastViewModel;
import com.example.mcs.forecastapp.R;
import com.example.mcs.forecastapp.databinding.ForecastActivityBinding;

import java.util.ArrayList;


public class ForecastActivityView extends AppCompatActivity {

    private ForecastViewModel viewModel;
    //auto-generated databinding class
    private ForecastActivityBinding mBinding;
    //recyclerview adapter
    private DayAdapter dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.forecast_activity);

        //initializes the adapter and sets it to the binding util
        dayAdapter= new DayAdapter(new ArrayList<DayModel>());
        mBinding.dayLis.setAdapter(dayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //gets an instance of the ViewModel
        viewModel= ViewModelProviders.of(this).get(ForecastViewModel.class);

        //calls on the viewmodel to load the data/forecast from the repo
        viewModel.loadForecast(getApplication());

        //binds viewmodel to view
        mBinding.setForecastVM(viewModel);

        //makes this activity and observable of the forecast model
        viewModel.getForecastModel().observe(this, new Observer<ForecastModel>() {
            @Override
            public void onChanged(@Nullable ForecastModel forecastModel) {

                //updates the recyclerview with the new data
                dayAdapter.setDayList(forecastModel.getDays());

                //binds viewmodel to view
                mBinding.setForecastVM(viewModel);

            }
        });
    }
}
