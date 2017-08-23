package com.ilkayaktas.margatsni.controller.api;


import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.instagram.InstagramDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.AuthenticationService;
import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.UserService;
import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
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

    public ApiHelper(AuthenticationService queryAuth, UserService queryApi){
        this.queryAuth = queryAuth;
        this.queryApi = queryApi;
    }
    
    @Override
    public void authenticate(Context context, Scope scope, InstagramDialog.OnInstagramAuthentication onInstagramAuthentication) {
        final Single<UserInfo>[] user = new Single[1];
        
        String authUrl = LibConstants.AUTH_URL + "client_id=" +
                        LibConstants.INSTAGRAM_CLIENT_ID +
                        "&redirect_uri=" + LibConstants.INSTAGRAM_CALBACK_URL +
                        "&response_type=code"+"&scope="+ scope.toString();
    
        // Create dialog and callback result
        InstagramDialog mDialog = new InstagramDialog(context, authUrl, queryAuth, onInstagramAuthentication);
        mDialog.show();
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
