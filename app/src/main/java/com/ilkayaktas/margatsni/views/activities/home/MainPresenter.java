package com.ilkayaktas.margatsni.views.activities.home;


import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.instagram.InstagramDialog;
import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
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
		getIDataManager().authenticate((Context) getMvpView(), Scope.ALL, new InstagramDialog.OnInstagramAuthentication() {
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
	
	private void onSuccessAuthentication(UserInfo userInfo) {
		System.out.println("presenter received: "+userInfo.user.toString());
		
	}
	
	private void onSuccessUser(UserInfo userInfo) {
		System.out.println("__"+userInfo.accessToken);
	}
}
