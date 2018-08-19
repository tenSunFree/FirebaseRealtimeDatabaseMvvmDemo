package com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.Module;

import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseChangeDataViewModel;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class FirebaseModule {

    @Singleton
    @Provides
    public FirebaseDatabaseViewModel firebaseDatabaseViewModel() {
        return new FirebaseDatabaseViewModel();
    }

    @Singleton
    @Provides
    public FirebaseDatabaseChangeDataViewModel firebaseDatabaseChangeDataViewModel() {
        return new FirebaseDatabaseChangeDataViewModel();
    }
}

