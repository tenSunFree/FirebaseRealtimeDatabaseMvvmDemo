package com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.AppPackage;

import android.app.Application;
import android.content.Context;

import com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.Component.DaggerFirebaseComponent;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.Component.FirebaseComponent;

public class MyApplication extends Application {

    public static FirebaseComponent firebaseComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        /** 这样在其它Activity中就可以通过获取Application的对象来取得单例 */
        firebaseComponent = DaggerFirebaseComponent.builder().build();
    }

    public static Context getInstance() {
        return mContext;
    }
}
