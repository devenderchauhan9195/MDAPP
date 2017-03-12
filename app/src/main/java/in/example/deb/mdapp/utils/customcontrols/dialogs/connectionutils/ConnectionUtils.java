package in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Deb on 06-03-2017.
 */

public class ConnectionUtils {
    public boolean CheckInternetConnection(Activity activity)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        boolean isNetworkConnected=false;
        try {
            if (networkInfo.isConnected()==true)
            {
                isNetworkConnected=true;
            }
            else
            {
                isNetworkConnected=false;
            }
            isNetworkConnected=false;
        }
        catch (NullPointerException e)
        {
            isNetworkConnected=false;
        }

        try {
            if (networkInfo.isConnectedOrConnecting()==true)
            {
                isNetworkConnected=true;
            }
            else
            {
                isNetworkConnected=false;
            }
        }
        catch (NullPointerException e)
        {
            isNetworkConnected=false;
        }


        return isNetworkConnected;
    }
}
