package com.example.mcs.forecastapp.Repo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//Singleton to make use of caching
public class VolleySingleton {
    private static VolleySingleton mInstance;
    private static RequestQueue requestQueue;

    private VolleySingleton() {
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    //Gets 1 Volley singleton synchronously to avoid deadlock
    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance==null) {
            mInstance = new VolleySingleton();
        }
        requestQueue = Volley.newRequestQueue(context);
        return mInstance;
    }

    public<T> void addToRequestQueue(Request<T> request) {
        requestQueue.add(request);
    }
}
