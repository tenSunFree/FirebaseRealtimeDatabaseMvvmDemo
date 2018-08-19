package com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.Component;

import com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.Module.FirebaseModule;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseChangeDataViewModel;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton                                                                                          // 一般需要创建单例时, 我们需要在Module和Component中都添加@Singleton注解
@Component(modules = {FirebaseModule.class})                                                        // @Component这个注解用于构建接口, 该接口把所有封装在一起, 这里我们定义需要依赖的模块(或组件), 这里定义了那些依赖可注入, 我们的组件可以注入哪里, @Component是连接@Module和@Inject的桥梁
public interface FirebaseComponent {

    FirebaseDatabaseViewModel firebaseDatabaseViewModel();
    FirebaseDatabaseChangeDataViewModel FirebaseDatabaseChangeDataViewModel();
}
