package com.rkurban.sample_room_dagger2.modules.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by rkurban on 10.04.2018.
 */

@Dao
public interface ModelDao {

    @Query("select * from Model")
    List<Model> getList();

    @Insert(onConflict = REPLACE)
    void addModel(Model model);

    @Delete
    void deleteModel(Model model);

}
