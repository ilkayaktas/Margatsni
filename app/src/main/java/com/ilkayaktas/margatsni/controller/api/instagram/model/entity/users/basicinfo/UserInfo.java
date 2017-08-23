package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.data;

public class UserInfo {

    @SerializedName("access_token")
    public String accessToken;

	@SerializedName(value="user", alternate={"data"})
	public UserInfoData user;

    @Override
    public String toString() {
        return String.format("UserInfo [token=%s][data=%s]", accessToken, data);
    }
}
