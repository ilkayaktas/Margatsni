package com.ilkayaktas.margatsni.controller.api.fivehundredpx.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iaktas on 24.08.2017.
 */

public class Authorize {

    @SerializedName("oauth_token")
    public String oauth_token;

    @SerializedName("oauth_verifier ")
    public String oauth_verifier ;

}
