package lib.ilkayaktas.instagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
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
    private InstagramQuery queryApi;
    private InstagramQuery queryAuth;
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

        queryAuth = retrofitAuth.create(InstagramQuery.class);
    }

    private void createRetroApi() {
        retrofitApi = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        queryApi = retrofitApi.create(InstagramQuery.class);
    }

    public Call<UserInfo> getUser() {
        Observable<UserInfo> auth = queryApi.getCurrentUser(mAccessToken);

        auth.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserInfo userInfo) {
                        System.out.println(userInfo.accessToken);

                        Toast.makeText(mContext, userInfo.user.username, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return null;
    }

    public UserInfo authenticate(String client_id, String client_secret, String redirect_uri, String code) {
        Observable<UserInfo> auth = queryAuth.authenticate(client_id, client_secret, "authorization_code", redirect_uri, code);
    
//        auth.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(this::onSubscribeAuthentication)
//                .doOnNext(this::onNextAuthentication)
//                .doOnError(this::onErrorAuthentication)
//                .doOnComplete(this::onCompletedAuthentication);

        auth.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {

                    UserInfo user;
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        progressDlg.setMessage("Getting access token...");
                        progressDlg.show();
                    }

                    @Override
                    public void onNext(@NonNull UserInfo userInfo) {
                        System.out.println(userInfo.accessToken);
                        user = userInfo;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        progressDlg.cancel();
                    }

                    @Override
                    public void onComplete() {
                        progressDlg.dismiss();

                        createRetroApi();

                        Toast.makeText(mContext, user.accessToken, Toast.LENGTH_SHORT).show();

                        mAccessToken = user.accessToken;

                        getUser();
                    }
                });


        return null;
    }
    
    private void onCompletedAuthentication() {
        progressDlg.dismiss();
        System.out.println("________1_");
    }
    
    private void onErrorAuthentication(Throwable throwable) {
        System.out.println("_________");
        progressDlg.cancel();
    }
    
    private void onNextAuthentication(UserInfo userInfo) {
        System.out.println(userInfo.toString());
        createRetroApi();
    
        Toast.makeText(mContext, userInfo.accessToken, Toast.LENGTH_SHORT).show();
    
        mAccessToken = userInfo.accessToken;
    
        getUser();
        
    }
    
    private void onSubscribeAuthentication(Disposable disposable) {
        System.out.println("_______ss__");
        progressDlg.setMessage("Getting access token...");
        progressDlg.show();
    
    }
    
}