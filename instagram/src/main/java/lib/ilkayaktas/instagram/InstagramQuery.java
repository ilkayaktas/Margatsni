package lib.ilkayaktas.instagram;

import io.reactivex.Observable;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by iaktas on 21.08.2017.
 */

public interface InstagramQuery {

    @GET("users/self")
    Observable<UserInfo> getCurrentUser(@Query("access_token") String access_token);

    @FormUrlEncoded
    @POST("oauth/access_token/")
    Observable<UserInfo> authenticate(@Field("client_id") String client_id,
                                            @Field("client_secret") String client_secret,
                                            @Field("grant_type") String grant_type,
                                            @Field("redirect_uri") String redirect_uri,
                                            @Field("code") String code);

}
