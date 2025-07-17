package com.mazedemo.mazeDemo.domain;

import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.domain.valueObject.MazeLevel;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.domain.valueObject.MazeTitle;
import lombok.Getter;

@Getter
public class MazeEntity {
    private final MazeId id;
    private final MazeTitle title;
    private final MazeLevel level;
    private final MazeStatus status;

    public MazeEntity(MazeId id, MazeTitle title, MazeLevel level, MazeStatus status) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.status = status;
    }
}
