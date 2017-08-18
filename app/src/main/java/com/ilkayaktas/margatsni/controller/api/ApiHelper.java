package com.ilkayaktas.margatsni.controller.api;

import com.ilkayaktas.margatsni.controller.api.instagram.retrofit.interfaces.AuthenticationService;

import javax.inject.Singleton;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ilkay on 01/07/2017.
 */

@Singleton
public class ApiHelper implements IApiHelper {
    @Override
    public UserInfo autorize() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthenticationService authenticationService = retrofit.create(AuthenticationService.class);

        return null;
    }

    @Override
    public UserInfo getCurrentUser() {
        return null;
    }
}
