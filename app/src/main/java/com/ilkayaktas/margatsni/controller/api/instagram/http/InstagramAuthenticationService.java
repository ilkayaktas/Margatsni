package com.ilkayaktas.margatsni.controller.api.instagram.http;

import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by iaktas on 23.08.2017.
 */

public interface InstagramAuthenticationService {
    @FormUrlEncoded
    @POST("oauth/access_token/")
    Single<UserInfo> authenticate(@Field("client_id") String client_id,
                                  @Field("client_secret") String client_secret,
                                  @Field("grant_type") String grant_type,
                                  @Field("redirect_uri") String redirect_uri,
                                  @Field("code") String code);
}
