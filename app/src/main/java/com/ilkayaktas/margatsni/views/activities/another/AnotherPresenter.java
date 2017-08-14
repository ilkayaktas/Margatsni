package com.ilkayaktas.margatsni.views.activities.another;


import com.ilkayaktas.margatsni.views.activities.base.BasePresenter;

/**
 * Created by ilkay on 02/08/2017.
 */

public class AnotherPresenter<V extends AnotherMvpView> extends BasePresenter<V>
		implements AnotherMvpPresenter<V> {
	public AnotherPresenter(com.ilkayaktas.margatsni.controller.IDataManager IDataManager) {
		super(IDataManager);
	}
}
