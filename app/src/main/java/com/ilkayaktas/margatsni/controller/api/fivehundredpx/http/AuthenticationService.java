package com.ilkayaktas.margatsni.controller.api.fivehundredpx.http;

import com.ilkayaktas.margatsni.controller.api.fivehundredpx.model.entity.RequestToken;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by iaktas on 23.08.2017.
 */

public interface AuthenticationService {
    @FormUrlEncoded
    @POST("oauth/request_token")
    Single<RequestToken> requestToken(@Field("oauth_callback") String oauth_callback);


    @FormUrlEncoded
    @POST("oauth/authorize")
    Single<UserInfo> authorize(@Field("oauth_token") String oauth_token,
                                  @Field("oauth_callback ") String oauth_callback);


    @FormUrlEncoded
    @POST("oauth/access_token")
    Single<UserInfo> accessToken(@Field("oauth_callback ") String oauth_callback);
}
