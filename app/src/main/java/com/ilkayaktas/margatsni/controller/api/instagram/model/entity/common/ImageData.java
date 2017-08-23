package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.common;

import com.google.gson.annotations.SerializedName;

/**
 * A class to denote the ImageData.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
public class ImageData {
	@SerializedName("url")
	private String imageUrl;

	@SerializedName("width")
	private int imageWidth;

	@SerializedName("height")
	private int imageHeight;

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the imageWidth
	 */
	public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

    @Override
    public String toString() {
        return String.format("ImageData [imageHeight=%s, imageUrl=%s, imageWidth=%s]",
                imageHeight, imageUrl, imageWidth);
    }
}
