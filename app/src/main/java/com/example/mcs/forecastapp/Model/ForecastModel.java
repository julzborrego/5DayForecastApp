package com.example.mcs.forecastapp.Model;

import java.util.List;

public class ForecastModel {

    private List<DayModel> days;
    private String city;


    public ForecastModel(List<DayModel> days, String city) {
        this.days = days;
        this.city = city;
    }

    public List<DayModel> getDays() {
        return days;
    }

    public void setDays(List<DayModel> days) {
        this.days = days;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
