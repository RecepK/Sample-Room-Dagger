package com.rkurban.sample_room_dagger2.modules.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by rkurban on 10.04.2018.
 */

@Entity
public class Model {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Model(String name) {
        this.name = name;
    }
}
