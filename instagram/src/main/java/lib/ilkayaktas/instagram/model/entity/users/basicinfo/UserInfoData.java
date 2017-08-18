package lib.ilkayaktas.instagram.model.entity.users.basicinfo;

import com.google.gson.annotations.SerializedName;

public class UserInfoData {
	@SerializedName("id")
	public String id;

	@SerializedName("username")
	public String username;

	@SerializedName("full_name")
	public String fullName;

	@SerializedName("profile_picture")
	public String profilePicture;

	@SerializedName("bio")
	public String bio;

	@SerializedName("website")
	public String website;

	@SerializedName("counts")
	public Counts counts;


    @Override
    public String toString() {
        return String.format("UserInfoData [id=%s, username=%s, fullName=%s, profile_picture=%s, bio=%s, website=%s, counts=%s]",
                        id, username, fullName, profilePicture, bio, website, counts);
    }
}
