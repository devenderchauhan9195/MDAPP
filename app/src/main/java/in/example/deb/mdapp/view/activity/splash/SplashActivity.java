package in.example.deb.mdapp.view.activity.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.ApplicationDialogs;
import in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.ConnectionUtils;
import in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.sharedpref.SharedPref;
import in.example.deb.mdapp.view.activity.home.HomeActivity;
import in.example.deb.mdapp.view.activity.login.LogInActivity;
import in.example.deb.mdapp.view.activity.profile.ProfileActivity;

public class SplashActivity extends AppCompatActivity {

    Button buttonGetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        buttonGetStarted = (Button) findViewById(R.id.buttonGetstarted);

    }
        @Override
    protected void onPostResume() {
        super.onPostResume();
        checkConnecion();
    }

    private void checkConnecion() {

        ConnectionUtils connectionUtils=new ConnectionUtils();
        boolean values=connectionUtils.CheckInternetConnection(this);
        if (values==true)
        {
            StartSplash();
        }
        else
        {
            ApplicationDialogs applicationDialogs=new ApplicationDialogs();
            applicationDialogs.ShowMessageDialogsWithFinish(this,getString(R.string.internetconnectionerror));
        }
    }

    private void StartSplash() {
        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref sharedPref=new SharedPref();
                if (sharedPref.GetInt(SplashActivity.this,sharedPref.User_Id)>0)
                {
                    Intent intent=new Intent(SplashActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });
    }




    }

