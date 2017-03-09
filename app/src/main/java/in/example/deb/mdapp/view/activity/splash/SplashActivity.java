package in.example.deb.mdapp.view.activity.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.view.activity.login.LogInActivity;

public class SplashActivity extends AppCompatActivity {

    Button buttonGetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        buttonGetStarted=(Button)findViewById(R.id.buttonGetstarted);
        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
