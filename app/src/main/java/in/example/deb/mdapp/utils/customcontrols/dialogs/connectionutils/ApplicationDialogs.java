package in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import in.example.deb.mdapp.R;

/**
 * Created by Deb on 11-03-2017.
 */

public class ApplicationDialogs {
    public void ShowMessageDialogsWithFinish(final Activity activity, String message)
    {
        AlertDialog.Builder dialogs=new AlertDialog.Builder(activity);
        dialogs.setCancelable(false);
        dialogs.setMessage(message);
        dialogs.setTitle(activity.getString(R.string.feedback));
        dialogs.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                activity.finish();
            }
        });
        dialogs.show();
    }

    public void ShowMessageDialogs(Activity activity,String message)
    {

        AlertDialog.Builder dialods=new AlertDialog.Builder(activity);
        dialods.setCancelable(false);
        dialods.setMessage(message);
        dialods.setTitle(activity.getString(R.string.feedback));
        dialods.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialods.show();
    }
}

