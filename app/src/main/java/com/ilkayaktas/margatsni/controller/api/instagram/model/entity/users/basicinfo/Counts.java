package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo;

import com.google.gson.annotations.SerializedName;

public class Counts {

	@SerializedName("media")
	public int media;

	@SerializedName("follows")
	public int follows;

	@SerializedName("followed_by")
	public int followedBy;

    @Override
    public String toString() {
        return String.format("Counts [media=%s, follows=%s, followed_by=%s]", media, follows, followedBy);
    }
}
