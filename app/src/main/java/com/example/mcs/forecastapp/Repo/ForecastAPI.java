package com.example.mcs.forecastapp.Repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mcs.forecastapp.Model.DayModel;
import com.example.mcs.forecastapp.Model.ForecastModel;
import com.example.mcs.forecastapp.Utils.ForecastAPIConstants;
import com.example.mcs.forecastapp.Utils.JSONConverter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ForecastAPI implements ForecastRepo{
    private static ForecastAPI mInstance;
    private VolleySingleton volley;

    //singleton constructor for the APIrepo
    private ForecastAPI(Context ctx) {
        volley = VolleySingleton.getInstance(ctx);
    }

    //prevent deadlock and ensures singleton
    public static synchronized ForecastAPI getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new ForecastAPI(ctx);
        }
        return mInstance;
    }

    /***
     * adds the request to the volley's requestque
     *@return the mutable live data object of the Forecast model. Gets updated after a response
     */
    @Override
    public LiveData<ForecastModel> getForecastModel() {
        final MutableLiveData<ForecastModel> data= new MutableLiveData<>();

        data.setValue(new ForecastModel(new ArrayList<DayModel>(),""));

        String urlString = ForecastAPIConstants.buildURLString();

        //Set the call backs for request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlString, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        data.setValue(JSONConverter.buildForecastModel(response));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //change the model for the UI to know that an error has occured
                data.setValue(new ForecastModel(new ArrayList<DayModel>(),ForecastAPIConstants.ERROR));
            }
        });

        volley.addToRequestQueue(jsonObjectRequest);
        return data;
    }
}
