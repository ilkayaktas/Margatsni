package com.ilkayaktas.margatsni.controller.api.instagram.retrofit.interfaces;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface UserService {
    @GET("/users/self")
    Call<UserInfo> getCurrentUser();

    @GET("/users/{userId}")
    Call<UserInfo> getUser(@Path("userId") String userId);


}
