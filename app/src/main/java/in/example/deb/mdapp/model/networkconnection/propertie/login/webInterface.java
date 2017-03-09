package in.example.deb.mdapp.model.networkconnection.propertie.login;

import in.example.deb.mdapp.model.proterties.login.LoginResultPrp;
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

}
