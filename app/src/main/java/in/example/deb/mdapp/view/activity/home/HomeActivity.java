package in.example.deb.mdapp.view.activity.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.sharedpref.SharedPref;
import in.example.deb.mdapp.view.activity.login.LogInActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public  void LogOut(View view)
    {
        SharedPref sharedPref=new SharedPref();
        sharedPref.ClearAll(this);
        startActivity(new Intent(this, LogInActivity.class));
        finish();
    }
}
