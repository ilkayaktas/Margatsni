package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.common;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("username")
	private String userName;

	@SerializedName("profile_picture")
	private String profilePictureUrl;

	@SerializedName("id")
	private String id;


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the profilePictureUrl
	 */
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	/**
	 * @param profilePictureUrl the profilePictureUrl to set
	 */
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return String.format("User [id=%s, profilePictureUrl=%s, userName=%s]",
                id, profilePictureUrl, userName);
    }
}
