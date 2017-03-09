package in.example.deb.mdapp.view.activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.model.proterties.login.LoginResultPrp;
import in.example.deb.mdapp.view.activity.home.HomeActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

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

    @Override
    public void onCompleteLogin(LoginResultPrp loginResult) {
        Toast.makeText(this,loginResult.getResult().getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void startProgress() {

    }

    @Override
    public void stopProgress() {

    }

    @Override
    public void showFeedbackMessage(String message) {

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onForgetPasswordComplete() {

    }
}
