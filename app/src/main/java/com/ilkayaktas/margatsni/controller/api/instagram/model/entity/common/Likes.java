package com.ilkayaktas.margatsni.controller.api.instagram.model.entity.common;

import com.google.gson.annotations.SerializedName;

public class Likes {
	@SerializedName("count")
	private int count;

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

    @Override
    public String toString() {
        return String.format("Likes [count=%s]", count);
    }

}
