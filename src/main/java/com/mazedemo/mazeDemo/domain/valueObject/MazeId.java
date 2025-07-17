package com.mazedemo.mazeDemo.domain.valueObject;

import lombok.Getter;

import java.util.UUID;

@Getter
public class MazeId {
    private final UUID value;

    public MazeId() {
        this.value = UUID.randomUUID();
    }

    public MazeId(UUID value) {
        this.value = value;
    }
}
