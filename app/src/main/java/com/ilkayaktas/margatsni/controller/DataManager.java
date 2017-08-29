package com.ilkayaktas.margatsni.controller;

import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.IApiHelper;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.FiveHundredPxDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.InstagramDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.controller.db.IDbHelper;
import com.ilkayaktas.margatsni.controller.pref.IPreferenceHelper;
import com.ilkayaktas.margatsni.di.annotations.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;


/**
 * Created by ilkay on 11/03/2017.
 */

@Singleton
public class DataManager implements IDataManager {
	
	private final Context mContext;
	private final IDbHelper mIDbHelper;
	private final IPreferenceHelper mIPreferenceHelper;
	private final IApiHelper mIApiHelper;
	
	@Inject
	public DataManager(@ApplicationContext Context mContext, IDbHelper mIDbHelper, IPreferenceHelper mIPreferenceHelper, IApiHelper mIApiHelper) {
		this.mContext = mContext;
		this.mIDbHelper = mIDbHelper;
		this.mIPreferenceHelper = mIPreferenceHelper;
		this.mIApiHelper = mIApiHelper;
	}

	@Override
	public boolean getDatabaseCreatedStatus() {
		return mIPreferenceHelper.getDatabaseCreatedStatus();
	}

	@Override
	public void setDatabaseCreatedStatus() {
		mIPreferenceHelper.setDatabaseCreatedStatus();
	}

	@Override
	public void authenticateInstagram(Context context, Scope scope, InstagramDialog.OnInstagramAuthentication onInstagramAuthentication) {
		mIApiHelper.authenticateInstagram(context, scope, onInstagramAuthentication);
	}

	@Override
	public Single<UserInfo> getCurrentUser() {
		return mIApiHelper.getCurrentUser();
	}

	@Override
	public Single<UserInfo> getUser(String userId) {
		return mIApiHelper.getUser(userId);
	}

	@Override
	public void authenticate500px(Context context, String oauth_callback, FiveHundredPxDialog.On500pxAuthentication on500pxAuthentication) {
		mIApiHelper.authenticate500px(context, oauth_callback, on500pxAuthentication);
	}
}
