package in.example.deb.mdapp.view.activity.login;

import android.app.Activity;
import android.telecom.Call;
import android.widget.Toast;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.model.networkconnection.propertie.login.BaseUrl;
import in.example.deb.mdapp.model.networkconnection.propertie.login.webInterface;
import in.example.deb.mdapp.model.proterties.login.LoginResultPrp;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Deb on 06-03-2017.
 */

public class LogInPresenter extends BaseUrl implements IlogInPresenter {

    Activity activity;
    LogInView logInView;

    public LogInPresenter(Activity activity, LogInView view) {
        this.activity = activity;
        this.logInView = view;
    }

    @Override
    public void requestLogIn(String email, String password) {
        if (checkFieldEmpty(email,password))
        {
            if (isEmailValid(email)) {
                makeLoginRequest(email, password);
            }
        }
    }
    private boolean checkFieldEmpty(String email,String password)
    {
        if(email.trim().length()==0)
        {
            logInView.showFeedbackMessage(activity.getString(R.string.emailempty));
            return false;
        }
        else if (password.trim().length()==0)
        {
            logInView.showFeedbackMessage(activity.getString(R.string.passwordempty));
            return false;
        }
        else
        {
            return true;
        }
    }



    private boolean isEmailValid(String email)
    {
        return  true;
    }



    @Override
    public void requestForgetPassword(String email) {

    }

    private void makeLoginRequest(String email,String password) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        final retrofit2.Call<LoginResultPrp> result = retrofit.create(webInterface.class).requestLogin(email, password);
        result.enqueue(new Callback<LoginResultPrp>() {
            @Override
            public void onResponse(retrofit2.Call<LoginResultPrp> call, Response<LoginResultPrp> response) {
                logInView.onCompleteLogin(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<LoginResultPrp> call, Throwable t) {
                logInView.showFeedbackMessage(activity.getString(R.string.wrongpassword));
            }

        });
    }
}