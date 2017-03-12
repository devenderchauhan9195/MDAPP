package in.example.deb.mdapp.view.activity.profile;

/**
 * Created by Deb on 12-03-2017.
 */

public interface ProfileView {
    void LoadProfile();
    void UpdateProfileResult();

    void startProgress();
    void stopProgress();
    void loadCities(String[] Cities);
    void LoadStates(String[] States);
}
