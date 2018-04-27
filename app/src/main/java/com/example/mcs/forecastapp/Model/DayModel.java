package com.example.mcs.forecastapp.Model;

public class DayModel {

    private String date;
    private int minTemp;
    private int maxTemp;
    private String description;

    public DayModel(String date, int minTemp, int maxTemp, String description) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateVals(int minTemp, int maxTemp, String description) {

        if (this.minTemp > minTemp) this.minTemp = minTemp;
        if (this.maxTemp < maxTemp) this.maxTemp = maxTemp;
        if (!this.description.contains(description)) this.description+=("/"+description);

    }
}
