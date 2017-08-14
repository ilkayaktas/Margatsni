package com.ilkayaktas.margatsni.views.activities.home;


import com.ilkayaktas.margatsni.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 12/03/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
		implements MainMvpPresenter<V>{
	
	public MainPresenter(com.ilkayaktas.margatsni.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
	
}
