package in.example.deb.mdapp.view.activity.login;

import in.example.deb.mdapp.model.proterties.proterties.login.LoginResultPrp;

/**
 * Created by Deb on 06-03-2017.
 */

public interface LogInView {

    void onCompleteLogin(LoginResultPrp loginResult);
    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);
    void onForgetPasswordComplete();
}
