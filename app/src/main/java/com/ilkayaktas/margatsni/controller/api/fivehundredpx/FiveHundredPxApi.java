package com.ilkayaktas.margatsni.controller.api.fivehundredpx;

import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.fivehundredpx.model.entity.RequestToken;

import io.reactivex.Single;

/**
 * Created by iaktas on 24.08.2017.
 */

public interface FiveHundredPxApi {
    Single<RequestToken> requestToken(Context context, String oauth_callback);

}
