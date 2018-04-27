package com.example.mcs.forecastapp.Utils;

import com.example.mcs.forecastapp.R;

/***
 * The Binder is going to use this to format the input of the data models
 */
public class BinderUtil {

    public static String formatMaxTemp(int maxTemp){
        return ("High: " + String.valueOf(maxTemp)+"°F");
    }
    public static String formatMinTemp(int minTemp){
        return ("Low: "+ String.valueOf(minTemp)+"°F");
    }
    public static String formatOutlook(String description){
        return ("Outlook: " + description);
    }
}
