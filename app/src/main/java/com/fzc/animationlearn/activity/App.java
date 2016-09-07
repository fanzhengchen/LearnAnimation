package com.fzc.animationlearn.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.fzc.animationlearn.activity.service.InitialService;

import io.realm.Realm;
import io.realm.RealmConfiguration;

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
        Context context = getApplicationContext();
        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .build();
        Realm.setDefaultConfiguration(configuration);


        Intent intent = new Intent(this, InitialService.class);
        intent.setAction(AppConstance.APP_INIT);
        startService(intent);
    }
}
