package lib.ilkayaktas.instagram.http.retrofit;

import lib.ilkayaktas.instagram.model.api.Endpoints;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface UserService {
    @GET(Endpoints.USERS_SELF)
    Call<UserInfo> getCurrentUser();

    @GET(Endpoints.USERS_WITH_ID)
    Call<UserInfo> getCurrentUSer1();

    @GET(Endpoints.USERS_SELF_RECENT_MEDIA)
    Call<UserInfo> getCurrentUSer2();

    @GET(Endpoints.USERS_RECENT_MEDIA)
    Call<UserInfo> getCurrentUSer3();

}
