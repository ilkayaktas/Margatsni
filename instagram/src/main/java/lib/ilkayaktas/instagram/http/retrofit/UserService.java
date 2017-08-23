package lib.ilkayaktas.instagram.http.retrofit;

import io.reactivex.Observable;
import lib.ilkayaktas.instagram.model.api.Endpoints;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface UserService {
    @GET(Endpoints.USERS_SELF)
    Observable<UserInfo> getCurrentUser(@Query("access_token") String access_token);

    @GET(Endpoints.USERS_WITH_ID)
    Observable<UserInfo> getUser(@Path("userId") String user, @Query("access_token") String access_token);

    @GET(Endpoints.USERS_SELF_RECENT_MEDIA)
    Observable<UserInfo> getCurrentUserRecentMedia(@Query("access_token") String access_token);

    @GET(Endpoints.USERS_RECENT_MEDIA)
    Observable<UserInfo> getUserRecentMedia(@Path("userId") String user, @Query("access_token") String access_token);

}
