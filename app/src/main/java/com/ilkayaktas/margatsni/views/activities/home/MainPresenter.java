package com.ilkayaktas.margatsni.views.activities.home;


import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.fivehundredpx.FiveHundredPxDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.InstagramDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.utils.AppConstants;
import com.ilkayaktas.margatsni.views.activities.base.BasePresenter;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ilkay on 12/03/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
		implements MainMvpPresenter<V>{
	
	public MainPresenter(com.ilkayaktas.margatsni.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
	
	@Override
	public void authenticateInstagram() {
		getIDataManager().authenticateInstagram((Context) getMvpView(), Scope.ALL, new InstagramDialog.OnInstagramAuthentication() {
			@Override
			public void onSucces(Single<UserInfo> user) {
				user.subscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(MainPresenter.this::onSuccessAuthentication);
			}
		});
		
	}
	
	@Override
	public void getCurrentUser() {
		Single<UserInfo> user = getIDataManager().getCurrentUser();
		
		user.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(MainPresenter.this::onSuccessUser);
	}

	@Override
	public void authenticateFiveHundredPx() {
		getIDataManager().authenticate500px((Context) getMvpView(), AppConstants.FIVEHUNDREDPX_CALBACK_URL, new FiveHundredPxDialog.On500pxAuthentication() {
			@Override
			public void onSucces(String accessToken) {
				System.out.println("500px access token: "+accessToken);
			}
		});

	}

	private void onSuccessAuthentication(UserInfo userInfo) {
		System.out.println("presenter received: "+userInfo.user.toString());
		getMvpView().drawUserData(userInfo);
	}
	
	private void onSuccessUser(UserInfo userInfo) {
		System.out.println("__"+userInfo.accessToken);
	}

}
