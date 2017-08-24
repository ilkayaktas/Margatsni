package com.ilkayaktas.margatsni.views.activities.home;


import com.ilkayaktas.margatsni.controller.api.instagram.model.entity.users.basicinfo.UserInfo;
import com.ilkayaktas.margatsni.views.activities.base.MvpView;

/**
 * Created by ilkay on 12/03/2017.
 */

public interface MainMvpView extends MvpView {
    void drawUserData(UserInfo userInfo);
}
