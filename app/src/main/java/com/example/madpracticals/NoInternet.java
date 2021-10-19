package com.example.madpracticals;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NoInternet {

    public boolean isNetworkAvailable(Context context)
    {
        try
        {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;

            if(manager != null)
            {
                networkInfo = manager.getActiveNetworkInfo();
            }

            return networkInfo!=null && networkInfo.isConnected();

        }
        catch (Exception e)
        {
            return false;
        }
    }


}
