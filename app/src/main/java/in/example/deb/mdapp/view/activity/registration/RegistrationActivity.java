package in.example.deb.mdapp.view.activity.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationBody;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationPrp;
import in.example.deb.mdapp.view.activity.BaseActivity;

public class RegistrationActivity extends BaseActivity implements RegisterView {

    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextMobileNumber;
    IRegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registerPresenter=new RegisterPresenter(this,this);
        getui();
    }

    private void getui() {
        editTextEmail=(EditText)findViewById(R.id.EditTextEmail);
        editTextUserName=(EditText)findViewById(R.id.EditTextUserName);
        editTextPassword=(EditText)findViewById(R.id.EditTextPassword);
        editTextMobileNumber=(EditText)findViewById(R.id.EditTextMobileNumber);
    }

    public void SignUpNow(View view)
    {
        RegistrationBody registerBody=new RegistrationBody();
        registerBody.setEmail(editTextEmail.getText().toString());
        registerBody.setPassword(editTextPassword.getText().toString());
        registerBody.setUserName(editTextUserName.getText().toString());
        registerBody.setPhone(editTextMobileNumber.getText().toString());
        registerBody.setDeviceToken("abc");
        registerPresenter.RequestRegistration(registerBody);

    }

    @Override
    public void OnRegistrationComplete(RegistrationPrp response) {
        Toast.makeText(this,getString(R.string.registersucessful), Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    public void startProgress() {
        StartProgressDialogs(getString(R.string.registrationprocess));

    }

    @Override
    public void stopProgress() {
        StopProgressDialogs();

    }

    @Override
    public void showFeedbackMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }
}
