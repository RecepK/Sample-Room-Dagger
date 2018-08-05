package com.rkurban.sample_room_dagger2.di.component;

import android.app.Application;

import com.rkurban.sample_room_dagger2.App;
import com.rkurban.sample_room_dagger2.di.ActivityBuilder;
import com.rkurban.sample_room_dagger2.di.module.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
