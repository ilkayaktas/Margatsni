package com.ilkayaktas.margatsni.views.fragments.another;


import com.ilkayaktas.margatsni.views.activities.base.BasePresenter;

/**
 * Created by iaktas on 14.03.2017.
 */

public class AnotherFragmentPresenter<V extends AnotherFragmentMvpView> extends BasePresenter<V> implements AnotherFragmentMvpPresenter<V> {
    public AnotherFragmentPresenter(com.ilkayaktas.margatsni.controller.IDataManager dataManager) {
        super(dataManager);
    }

}
