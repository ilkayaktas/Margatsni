package com.ilkayaktas.margatsni.controller.api.fivehundredpx;

import android.content.Context;

/**
 * Created by iaktas on 24.08.2017.
 */

public interface FiveHundredPxApi {
    void authenticate500px(Context context, String oauth_callback, FiveHundredPxDialog.OnApiAuthentication onApiAuthentication);

}
