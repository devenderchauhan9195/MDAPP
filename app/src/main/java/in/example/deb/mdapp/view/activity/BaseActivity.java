package in.example.deb.mdapp.view.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Deb on 10-03-2017.
 */

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    public void StartProgressDialogs(String message)
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }


    public void StopProgressDialogs()
    {

        if (progressDialog!=null)
        {
            progressDialog.dismiss();
        }

    }
}
