package com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit;

import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Endpoints;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.feed.MediaFeedData;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface UserService {
    @GET(Endpoints.USERS_SELF)
    Single<UserInfo> getCurrentUser(@Query("access_token") String access_token);

    @GET(Endpoints.USERS_WITH_ID)
    Observable<UserInfo> getUser(@Path("userId") String user, @Query("access_token") String access_token);

    @GET(Endpoints.USERS_SELF_RECENT_MEDIA)
    Observable<MediaFeedData> getCurrentUserRecentMedia(@Query("access_token") String access_token);

    @GET(Endpoints.USERS_RECENT_MEDIA)
    Observable<MediaFeedData> getUserRecentMedia(@Path("userId") String user, @Query("access_token") String access_token);

}
