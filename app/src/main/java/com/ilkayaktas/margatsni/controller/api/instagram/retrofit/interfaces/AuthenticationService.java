package com.ilkayaktas.margatsni.controller.api.instagram.retrofit.interfaces;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by iaktas on 18.08.2017.
 */

public interface AuthenticationService {
    @GET("/oauth/access_token?client_id={client_id}&client_secret={client_secret}&grant_type=authorization_code&redirect_uri={redirect_uri}&code={code}")
    Call<UserInfo> getAccessToken(@Path("client_id") String client_id,@Path("client_secret") String client_secret,@Path("redirect_uri") String redirect_uri, @Path("code") String code);
}
