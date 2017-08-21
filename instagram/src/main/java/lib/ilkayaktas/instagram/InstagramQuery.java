package lib.ilkayaktas.instagram;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iaktas on 21.08.2017.
 */

public interface InstagramQuery {

    @GET("users/self")
    Call<UserInfo> getCurrentUser(@Query("access_token") String access_token);

}
