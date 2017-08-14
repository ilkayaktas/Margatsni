package com.ilkayaktas.margatsni.di.components;


import android.app.Application;
import android.content.Context;

import com.ilkayaktas.margatsni.App;
import com.ilkayaktas.margatsni.controller.IDataManager;
import com.ilkayaktas.margatsni.di.annotations.ApplicationContext;
import com.ilkayaktas.margatsni.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ilkay on 26/02/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App app);
    
    @ApplicationContext
    Context context();
    
    Application application();
    
    IDataManager getDataManager();
    
}
