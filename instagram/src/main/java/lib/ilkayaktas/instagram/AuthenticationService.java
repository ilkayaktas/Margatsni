package lib.ilkayaktas.instagram;

import java.util.Map;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface AuthenticationService {
    @GET("/oauth/access_token")
    Call<UserInfo> getAccessToken(@QueryMap Map<String, String> options);
}
