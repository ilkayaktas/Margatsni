package com.ilkayaktas.margatsni.views.activities.splash;


import com.ilkayaktas.margatsni.di.annotations.PerActivity;
import com.ilkayaktas.margatsni.views.activities.base.MvpPresenter;

/**
 * Created by ilkay on 11/03/2017.
 */

@PerActivity
public interface SplashScreenMvpPresenter<V extends SplashScreenMvpView> extends MvpPresenter<V> {
}
