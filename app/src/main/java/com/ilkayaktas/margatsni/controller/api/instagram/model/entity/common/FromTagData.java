package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.common;

import com.google.gson.annotations.SerializedName;

public class FromTagData {
	@SerializedName("username")
	public String username;

	@SerializedName("full_name")
	public String fullName;

	@SerializedName("type")
	public String type;

	@SerializedName("id")
	public String id;


    @Override
    public String toString() {
        return String.format("FromTagData [fullName=%s, id=%s, type=%s, username=%s]",
                fullName, id, type, username);
    }
}
