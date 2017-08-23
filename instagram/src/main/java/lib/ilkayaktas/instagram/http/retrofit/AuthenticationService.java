package lib.ilkayaktas.instagram.http.retrofit;

import io.reactivex.Observable;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by iaktas on 23.08.2017.
 */

public interface AuthenticationService {
    @FormUrlEncoded
    @POST("oauth/access_token/")
    Observable<UserInfo> authenticate(@Field("client_id") String client_id,
                                      @Field("client_secret") String client_secret,
                                      @Field("grant_type") String grant_type,
                                      @Field("redirect_uri") String redirect_uri,
                                      @Field("code") String code);
}
