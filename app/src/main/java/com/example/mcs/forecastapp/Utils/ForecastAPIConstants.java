package com.example.mcs.forecastapp.Utils;

import android.net.Uri;

public class ForecastAPIConstants {

    public final static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";
    public final static String ZIP_QUERY ="zip";
    public final static String ZIP_PARAM ="77095,us";
    public final static String APPID_QUERY ="appid";
    public final static String APPID_PARAM= "308f8b6df2cf69a1efa3932c8ae1b899";
    public final static String UNITS_QUERY= "units";
    public final static String UNITS_PARAM= "imperial";

    public final static String ERROR="SERVICE REQUEST ERROR";

    public final static String buildURLString(){
        //uri for open weather map
        Uri endPoint = Uri
                .parse(ForecastAPIConstants.BASE_URL)
                .buildUpon()
                .appendQueryParameter(ForecastAPIConstants.ZIP_QUERY,
                        ForecastAPIConstants.ZIP_PARAM)
                .appendQueryParameter(ForecastAPIConstants.APPID_QUERY,
                        ForecastAPIConstants.APPID_PARAM)
                .appendQueryParameter(ForecastAPIConstants.UNITS_QUERY,
                        ForecastAPIConstants.UNITS_PARAM)
                .build();

        return endPoint.toString();
    }

}
