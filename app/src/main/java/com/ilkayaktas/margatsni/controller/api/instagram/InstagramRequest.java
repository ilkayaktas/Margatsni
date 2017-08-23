package com.ilkayaktas.margatsni.controller.api.instagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.AuthenticationService;
import com.ilkayaktas.margatsni.controller.api.instagram.http.retrofit.UserService;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Http request to instagram api.
 *
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 */
public class InstagramRequest {
    private String mAccessToken;
    private Retrofit retrofitApi;
    private Retrofit retrofitAuth;
    private UserService queryApi;
    private AuthenticationService queryAuth;
    private Context mContext;
    private ProgressDialog progressDlg;

    /**
     * Instantiate new object.
     */
    public InstagramRequest(Context context) {
        mAccessToken = "";
        this.mContext = context;
        this.progressDlg = new ProgressDialog(mContext);
        createRetroAuth();
    }

    /**
     * Instantiate new object.
     *
     * @param accessToken Access token.
     */
    public InstagramRequest(Context context, String accessToken) {
        mAccessToken = accessToken;
        this.mContext = context;
        this.progressDlg = new ProgressDialog(mContext);
        createRetroApi();
    }

    private void createRetroAuth() {
        retrofitAuth = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        queryAuth = retrofitAuth.create(AuthenticationService.class);
    }

    private void createRetroApi() {
        retrofitApi = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        queryApi = retrofitApi.create(UserService.class);
    }

    public Call<UserInfo> getUser() {
        Single<UserInfo> auth = queryApi.getCurrentUser(mAccessToken);

        auth.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessUser, this::onErrorUser);

        return null;
    }

    private void onSuccessUser(UserInfo userInfo) {
        System.out.println("__"+userInfo.accessToken);

        Toast.makeText(mContext, userInfo.user.username, Toast.LENGTH_SHORT).show();
    }

    private void onErrorUser(Throwable throwable) {

    }

    public UserInfo authenticate(String client_id, String client_secret, String redirect_uri, String code) {
        Single<UserInfo> auth = queryAuth.authenticate(client_id, client_secret, "authorization_code", redirect_uri, code);
    

        auth.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessAuthentication, this::onErrorAuthentication);


        return null;
    }
    
    private void onErrorAuthentication(Throwable throwable) {
        progressDlg.cancel();
    }
    
    private void onSuccessAuthentication(UserInfo userInfo) {
        createRetroApi();
    
        Toast.makeText(mContext, userInfo.accessToken, Toast.LENGTH_SHORT).show();
    
        mAccessToken = userInfo.accessToken;
    
        getUser();
        
    }

}