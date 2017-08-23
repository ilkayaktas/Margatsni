package com.ilkayaktas.margatsni.controller.api;


import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.AuthenticationService;
import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.UserService;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.controller.api.instagram.util.LibConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by ilkay on 01/07/2017.
 */

@Singleton
public class ApiHelper implements IApiHelper {
    @Inject
    AuthenticationService queryAuth;

    @Inject
    UserService queryApi;

    @Override
    public Single<UserInfo> authenticate() {
        String code = "";
        return  queryAuth.authenticate(LibConstants.INSTAGRAM_CLIENT_ID, LibConstants.INSTAGRAM_CLIENT_SECRET, "authorization_code", LibConstants.INSTAGRAM_CALBACK_URL, code);
    }

    @Override
    public Single<UserInfo> getCurrentUser() {
        String mAccessToken = "";
        return queryApi.getCurrentUser(mAccessToken);
    }

    @Override
    public Single<UserInfo> getUser(String userId) {
        return null;
    }
}
