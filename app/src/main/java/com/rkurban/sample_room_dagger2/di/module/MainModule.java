package com.rkurban.sample_room_dagger2.di.module;


import com.rkurban.sample_room_dagger2.modules.main.MainView;
import com.rkurban.sample_room_dagger2.modules.main.Presenter;
import com.rkurban.sample_room_dagger2.modules.room.AppDatabase;
import com.rkurban.sample_room_dagger2.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    MainView provideMainView(MainActivity activity) {
        return activity;
    }

    @Provides
    Presenter providePresenter(MainView mainView) {
        return new Presenter(mainView);
    }

    @Provides
    AppDatabase provideAppDatabase(MainActivity activity) {
        return AppDatabase.getDatabase(activity.getApplication());
    }

}
