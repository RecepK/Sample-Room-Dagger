package com.rkurban.sample_room_dagger2.di;

import android.app.Activity;

import com.rkurban.sample_room_dagger2.di.component.MainComponent;
import com.rkurban.sample_room_dagger2.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMAinActivity(MainComponent.Builder builder);
}
