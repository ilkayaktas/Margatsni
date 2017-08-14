package com.ilkayaktas.margatsni.views.activities.splash;


import com.ilkayaktas.margatsni.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 11/03/2017.
 */

public class SplashScreenPresenter <V extends SplashScreenMvpView> extends BasePresenter<V>
		implements SplashScreenMvpPresenter<V>{
	
	public SplashScreenPresenter(com.ilkayaktas.margatsni.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
	
}
