package com.fzc.animationlearn.activity;

import android.app.Application;
import android.content.Intent;

import com.fzc.animationlearn.activity.service.InitialService;

/**
 * Created by fanzhengchen on 9/2/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Intent intent = new Intent(this, InitialService.class);
        intent.setAction(AppConstance.APP_INIT);
        startService(intent);
    }
}
