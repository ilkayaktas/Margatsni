package lib.ilkayaktas.instagram;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.Context;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;

/**
 * Manage access token and user data. Token and user data data are stored in shared preferences.
 * 
 * @author Lorensius W. L T <lorenz@londatiga.net>
 *
 */
public class InstagramSession {
	private Context mContext;
	private SharedPreferences mSharedPref;
	
	private static final String SHARED = "Instagram_Preferences";
	private static final String USERID	= "userid";
	private static final String USERNAME = "username";
	private static final String FULLNAME = "fullname";
	private static final String PROFILPIC = "profilpic";
	private static final String ACCESS_TOKEN = "access_token";
	
	public InstagramSession(Context context) {
		mContext	= context;
		mSharedPref = context.getSharedPreferences(SHARED, Context.MODE_PRIVATE);
	}
	
	/**
	 * Save user data
	 * 
	 * @param user User data
	 */
	public void store(UserInfo user) {
		Editor editor = mSharedPref.edit();
		
		editor.putString(ACCESS_TOKEN, user.accessToken);
		editor.putString(USERID, user.user.id);
		editor.putString(USERNAME, user.user.username);
		editor.putString(FULLNAME, user.user.fullName);
		editor.putString(PROFILPIC, user.user.profilePicture);
		
		editor.commit();
	}
	
	/**
	 * Reset user data
	 */
	public void reset() {
		Editor editor = mSharedPref.edit();
		
		editor.putString(ACCESS_TOKEN, "");
		editor.putString(USERID, "");
		editor.putString(USERNAME, "");
		editor.putString(FULLNAME, "");
		editor.putString(PROFILPIC, "");
		
		editor.commit();
		
		CookieSyncManager.createInstance(mContext);
		
		CookieManager cookieManager = CookieManager.getInstance();
		cookieManager.removeAllCookie();
	}
	
	/**
	 * Get user data
	 * 
	 * @return User data
	 */
	public UserInfo getUser() {
		if (mSharedPref.getString(ACCESS_TOKEN, "").equals("")) {
			return null;
		}

		UserInfo user 	= new UserInfo();
		
		user.user.id = mSharedPref.getString(USERID, "");
		user.user.username = mSharedPref.getString(USERNAME, "");
		user.user.fullName = mSharedPref.getString(FULLNAME, "");
		user.user.profilePicture = mSharedPref.getString(PROFILPIC, "");
		user.accessToken = mSharedPref.getString(ACCESS_TOKEN, "");
		
		return user;
	}
	
	/**
	 * Get access token
	 * 
	 * @return Access token
	 */
	public String getAccessToken() {
		return mSharedPref.getString(ACCESS_TOKEN, "");
	}
	
	/**
	 * Check if ther is an active session.
	 * 
	 * @return true if active and vice versa
	 */
	public boolean isActive() {
		return (mSharedPref.getString(ACCESS_TOKEN, "").equals("")) ? false : true;
	}
}