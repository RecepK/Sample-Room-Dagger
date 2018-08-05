package com.rkurban.sample_room_dagger2.modules.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by rkurban on 10.04.2018.
 */

@Database(entities = {Model.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user_db").allowMainThreadQueries().build();
    }

    public abstract ModelDao modelDao();

}
