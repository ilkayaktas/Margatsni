package com.ilkayaktas.margatsni.controller.api;


import android.app.Activity;
import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.fivehundredpx.FiveHundredPxDialog;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.http.FiveHundredPxAuthenticationService;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.model.entity.RequestToken;
import com.ilkayaktas.margatsni.controller.api.instagram.InstagramDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.http.InstagramAuthenticationService;
import com.ilkayaktas.margatsni.controller.api.instagram.http.UserService;
import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.controller.services.AsyncResponse;
import com.ilkayaktas.margatsni.controller.services.MobssAsyncTask;
import com.ilkayaktas.margatsni.controller.strategy.OAuthAccessTokenStrategy;
import com.ilkayaktas.margatsni.controller.strategy.OAuthStrategy;
import com.ilkayaktas.margatsni.utils.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by ilkay on 01/07/2017.
 */

@Singleton
public class ApiHelper implements IApiHelper {
    @Inject
    InstagramAuthenticationService queryAuth;

    @Inject
    UserService queryApi;

    @Inject
    FiveHundredPxAuthenticationService authenticetionFiveHundred;

    public ApiHelper(InstagramAuthenticationService queryAuth, UserService queryApi, FiveHundredPxAuthenticationService authenticetionFiveHundred){
        this.queryAuth = queryAuth;
        this.queryApi = queryApi;
        this.authenticetionFiveHundred = authenticetionFiveHundred;
    }
    
    @Override
    public void authenticate(Context context, Scope scope, InstagramDialog.OnInstagramAuthentication onInstagramAuthentication) {
        final Single<UserInfo>[] user = new Single[1];
        
        String authUrl = AppConstants.INSTAGRAM_AUTH_URL + "client_id=" +
                        AppConstants.INSTAGRAM_CLIENT_ID +
                        "&redirect_uri=" + AppConstants.INSTAGRAM_CALBACK_URL +
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

    @Override
    public Single<RequestToken> requestToken(Context context, String oauth_callback) {

        new MobssAsyncTask(new OAuthStrategy(context), new AsyncResponse() {
            @Override
            public void processFinish(String authorizationUrl) {

                System.out.println(authorizationUrl);

                new FiveHundredPxDialog(context, service, requestToken, authorizationUrl, new FiveHundredPxDialog.OnApiAuthentication() {

                    @Override
                    public void onSucces(String verifier) {
                        new MobssAsyncTask((Activity) context, new OAuthAccessTokenStrategy(service,requestToken,verifier)).execute();
                    }

                }).show();
            }
        }).execute();

        return null;
    }
}
