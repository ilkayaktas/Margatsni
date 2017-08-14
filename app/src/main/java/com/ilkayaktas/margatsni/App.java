package com.ilkayaktas.margatsni;

import android.app.Application;

import com.ilkayaktas.margatsni.controller.IDataManager;
import com.ilkayaktas.margatsni.di.components.ApplicationComponent;
import com.ilkayaktas.margatsni.di.components.DaggerApplicationComponent;
import com.ilkayaktas.margatsni.di.modules.ApplicationModule;

import javax.inject.Inject;

import io.realm.Realm;

public class App extends Application {
	
	ApplicationComponent appComponent;
	
	@Inject
	IDataManager mIDataManager;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Realm.init(this);
		
		initializeInjector();
		
	}
	
	private void initializeInjector(){
		appComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.build();
		
		appComponent.inject(this);
		
	}
	
	public ApplicationComponent getAppComponent(){
		return appComponent;
	}
	
}