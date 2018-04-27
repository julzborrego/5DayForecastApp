package com.example.mcs.forecastapp.Utils;

import com.example.mcs.forecastapp.Model.DayModel;
import com.example.mcs.forecastapp.Model.ForecastModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JSONConverter {

    /***
     * Parces the json response into the forecast model
     */
    public static ForecastModel buildForecastModel(JSONObject obj){

        ArrayList<DayModel> days = new ArrayList<DayModel>();

        String city = obj.optJSONObject("city").optString("name");
        int cnt = obj.optInt("cnt");
        JSONArray list = obj.optJSONArray("list");

        String currDate = "";

        //loops throught the ~38 json objects for the 5 days(every 3 hours for each day) and builds a list of days model
        for(int i =0;i<cnt;i++){
            DayModel day;
            String dt = new SimpleDateFormat("MM/dd")
                    .format(new Date(list.optJSONObject(i).optInt("dt") * 1000L));
            int minTemp = (int)Math.round(list.optJSONObject(i).optJSONObject("main").optDouble("temp_min"));
            int maxTemp = (int)Math.round(list.optJSONObject(i).optJSONObject("main").optDouble("temp_max"));
            String description = list.optJSONObject(i).optJSONArray("weather").optJSONObject(0).optString("main");

            //creates a new day and adds it to the list of days
            if(!currDate.equals(dt)){
                currDate=dt;
                day=new DayModel(dt,minTemp,maxTemp,description);
                days.add(day);
            }
            //gets the last day on the list and updates the high/low temps and description
            else{
                day = days.get(days.size()-1);
                day.updateVals(minTemp,maxTemp,description);
            }
        }

        //creates the forecast model with list of days and the city
        return new ForecastModel(days,city);

    }
}
