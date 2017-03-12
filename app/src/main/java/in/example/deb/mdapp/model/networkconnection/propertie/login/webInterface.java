package in.example.deb.mdapp.model.networkconnection.propertie.login;

import in.example.deb.mdapp.model.proterties.proterties.login.LoginResultPrp;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationBody;
import in.example.deb.mdapp.model.proterties.proterties.registration.RegistrationPrp;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Deb on 08-03-2017.
 */

public interface webInterface {


    @FormUrlEncoded
    @POST("milkwala/ws/login.php")
    public retrofit2.Call<LoginResultPrp> requestLogin(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("milkwala/ws/register.php")
    Call<RegistrationPrp> requestRegistration(@Field("email") String email, @Field("password") String password,@Field("userName") String userName,@Field("phone") String phone,@Field("deviceToken") String deviceToken);




}
