package in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.sharedpref;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Deb on 12-03-2017.
 */

public class SharedPref {

   public String User_Id="USER_ID";
    String Pref_Name="MW_SharedPref";
    public void SetInt(Activity activity, String variable, int value)
    {
        SharedPreferences sharedPreferences=activity.getSharedPreferences(Pref_Name,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(variable,value);
        editor.commit();

    }

    public int GetInt(Activity activity,String Variable)
    {
      SharedPreferences sharedPreferences=activity.getSharedPreferences(Pref_Name,0);
        int value=sharedPreferences.getInt(Variable,-1);
        return value;

    }
    public void ClearAll(Activity activity)
    {
     SharedPreferences sharedPreferences=activity.getSharedPreferences(Pref_Name,0);
        sharedPreferences.edit().clear().commit();

    }

}
