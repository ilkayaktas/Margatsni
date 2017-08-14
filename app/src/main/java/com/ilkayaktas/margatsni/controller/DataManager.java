package com.ilkayaktas.margatsni.controller;

import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.IApiHelper;
import com.ilkayaktas.margatsni.controller.db.IDbHelper;
import com.ilkayaktas.margatsni.controller.pref.IPreferenceHelper;
import com.ilkayaktas.margatsni.di.annotations.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;


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
}
