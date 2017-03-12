
package in.example.deb.mdapp.model.proterties.proterties.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationPrp {

    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
