package com.fzc.animationlearn.activity.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.fzc.animationlearn.activity.AppConstance;

import java.io.File;

/**
 * Created by fanzhengchen on 9/2/16.
 */
public class InitialService extends IntentService {

    private static final String IMAGE = "image";
    private static final String MAIN = "main";
    private static final String LOW = "low";
    private static final int MAX_SIZE = 300 << 20;
    private static final int MAX_SIZE_LOW = 100 << 20;
    private static final int MAX_SIZE_VERY_LOW = 50 << 20;

    public InitialService() {
        super("InitialService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("intent action", intent.getAction());
        if (TextUtils.equals(intent.getAction(), AppConstance.APP_INIT)) {
            initFresco();
        }
    }

    private void initFresco() {
        Context context = getApplicationContext();
        String cachePath = getCacheDir(context);
        String mainPath = cachePath + File.separator + MAIN;
        String lowPath = cachePath + File.separator + LOW;

        DiskCacheConfig mainConfig = DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryName(mainPath)
                .setBaseDirectoryPath(new File(mainPath))
                .setMaxCacheSize(MAX_SIZE)
                .setMaxCacheSizeOnLowDiskSpace(MAX_SIZE_LOW)
                .setMaxCacheSizeOnVeryLowDiskSpace(MAX_SIZE_VERY_LOW)
                .build();

        DiskCacheConfig smallConfig = DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryName(lowPath)
                .setBaseDirectoryPath(new File(lowPath))
                .setMaxCacheSize(MAX_SIZE >> 1)
                .setMaxCacheSizeOnLowDiskSpace(MAX_SIZE_LOW >> 1)
                .setMaxCacheSizeOnVeryLowDiskSpace(MAX_SIZE_VERY_LOW >> 1)
                .build();

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(mainConfig)
                .setSmallImageDiskCacheConfig(smallConfig)
                .build();

        Fresco.initialize(context, config);
    }

    private String getCacheDir(Context context) {
        return context.getExternalCacheDir().getAbsolutePath();
    }
}

