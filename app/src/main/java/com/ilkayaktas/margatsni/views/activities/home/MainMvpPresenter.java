package com.ilkayaktas.margatsni.views.activities.home;


import com.ilkayaktas.margatsni.views.activities.base.MvpPresenter;

/**
 * Created by ilkay on 12/03/2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
	void authenticateInstagram();
	
	void getCurrentUser();

	void authenticateFiveHundredPx();
}
