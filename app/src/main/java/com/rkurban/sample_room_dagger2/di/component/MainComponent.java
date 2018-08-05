package com.rkurban.sample_room_dagger2.di.component;


import com.rkurban.sample_room_dagger2.di.module.MainModule;
import com.rkurban.sample_room_dagger2.ui.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MainModule.class})
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {  }
}
