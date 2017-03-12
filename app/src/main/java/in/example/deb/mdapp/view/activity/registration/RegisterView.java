package in.example.deb.mdapp.view.activity.registration;

import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationBody;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationPrp;

/**
 * Created by Deb on 10-03-2017.
 */

public interface RegisterView {
    void OnRegistrationComplete(RegistrationPrp response);
    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);
}
