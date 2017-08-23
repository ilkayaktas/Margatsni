package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.common;

import com.google.gson.annotations.SerializedName;

public class Caption {
	@SerializedName("created_time")
	public String createdTime;

	@SerializedName("text")
	public String text;

	@SerializedName("from")
	public FromTagData from;

	@SerializedName("id")
	public String id;


    @Override
    public String toString() {
        return String.format("Caption [createdTime=%s, from=%s, id=%s, text=%s]", createdTime, from, id, text);
    }
}
