package in.example.deb.mdapp.view.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.model.proterties.proterties.login.LoginResultPrp;
import in.example.deb.mdapp.utils.customcontrols.dialogs.connectionutils.sharedpref.SharedPref;
import in.example.deb.mdapp.view.activity.BaseActivity;
import in.example.deb.mdapp.view.activity.home.HomeActivity;
import in.example.deb.mdapp.view.activity.profile.ProfileActivity;
import in.example.deb.mdapp.view.activity.registration.RegistrationActivity;

public class LogInActivity extends BaseActivity implements LogInView {

    EditText editTextEmail;
    EditText editTextPassword;
    LogInPresenter logInPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        editTextEmail=(EditText)findViewById(R.id.EditTextEmail) ;
        editTextPassword=(EditText)findViewById(R.id.EditTextPassword);
        logInPresenter=new LogInPresenter(this,this);
    }
    public void SigninNow(View view)
    {
        logInPresenter.requestLogIn(editTextEmail.getText().toString(),editTextPassword.getText().toString());
    }
    public  void SignUpNow(View view)
    {
        startActivity(new Intent(LogInActivity.this, RegistrationActivity.class));
    }

    @Override
    public void onCompleteLogin(LoginResultPrp loginResult) {

        if (loginResult.getResult().getStatus()==1)
        {
            SharedPref sharedPref=new SharedPref();
            sharedPref.SetInt(this,sharedPref.User_Id,Integer.parseInt(loginResult.getResult().getId()));
           startActivity(new Intent(this, ProfileActivity.class));
            finish();
        }
        else
        {
            Toast.makeText(this,getString(R.string.wrongusernameorpassword),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void startProgress() {

        StartProgressDialogs(getString(R.string.loadingPleaseWait));
    }

    @Override
    public void stopProgress() {
        StopProgressDialogs();

    }

    @Override
    public void showFeedbackMessage(String message) {

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onForgetPasswordComplete() {

    }
}
