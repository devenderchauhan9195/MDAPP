package in.example.deb.mdapp.view.activity.registration;

import android.app.Activity;

import in.example.deb.mdapp.R;
import in.example.deb.mdapp.model.networkconnection.propertie.login.BaseUrl;
import in.example.deb.mdapp.model.networkconnection.propertie.login.webInterface;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationBody;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationPrp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Deb on 10-03-2017.
 */

public class RegisterPresenter extends BaseUrl implements IRegisterPresenter {

    Activity activity;
    RegisterView  registerView;
    public RegisterPresenter(Activity activity,RegisterView view) {
        this.activity=activity;
        this.registerView=view;
    }

    @Override
    public void RequestRegistration(RegistrationBody response) {

        if (!isFieldEmpty(response.getUserName()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.emptyusername));
        }
       else if (!isFieldEmpty(response.getEmail()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.emptyemail));
        }
        else if (!isFieldEmpty(response.getPassword()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.emptypassword));
        }
        else if (!isFieldEmpty(response.getPhone()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.emptyphone));
        }
        else {
            makeRegistrationRequest(response);

        }
    }
    private boolean isFieldEmpty(String value)
    {
        if (value.trim().length()==0)
        {
            return false;
        }
        return true;
    }

    private void makeRegistrationRequest(RegistrationBody registrationBody)
    {
        registerView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        Call<RegistrationPrp> result=retrofit.create(webInterface.class).requestRegistration(registrationBody.getEmail(),registrationBody.getPassword(),registrationBody.getUserName(),registrationBody.getPhone(),registrationBody.getUserName());
        result.enqueue(new Callback<RegistrationPrp>() {
            @Override
            public void onResponse(Call<RegistrationPrp> call, Response<RegistrationPrp> response) {
                registerView.stopProgress();
                if(response.body().getResult().getStatus()>0)
                {
                    registerView.OnRegistrationComplete(response.body());
                }
                else if (response.body().getResult().getStatus()==-2)
                {

                    registerView.showFeedbackMessage(activity.getString(R.string.thisemailalreadyexist));
                }

            }

            @Override
            public void onFailure(Call<RegistrationPrp> call, Throwable t) {
                registerView.stopProgress();
                registerView.showFeedbackMessage(activity.getString(R.string.wrongusernameorpassword));
            }
        });
    }

}

