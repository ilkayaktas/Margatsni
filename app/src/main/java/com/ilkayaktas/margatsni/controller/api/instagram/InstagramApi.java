package com.ilkayaktas.margatsni.controller.api.instagram;

import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;

import io.reactivex.Single;

/**
 * Created by iaktas on 23.08.2017.
 */

public interface InstagramApi {
    void authenticate(Context context, Scope scope, InstagramDialog.OnInstagramAuthentication onInstagramAuthentication);
    Single<UserInfo> getCurrentUser();
    Single<UserInfo> getUser(String userId);
}
