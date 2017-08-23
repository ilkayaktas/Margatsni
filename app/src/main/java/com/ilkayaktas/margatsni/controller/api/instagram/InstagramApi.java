package com.ilkayaktas.margatsni.controller.api.instagram;

import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;

import io.reactivex.Single;

/**
 * Created by iaktas on 23.08.2017.
 */

public interface InstagramApi {
    Single<UserInfo> authenticate();
    Single<UserInfo> getCurrentUser();
    Single<UserInfo> getUser(String userId);
}
