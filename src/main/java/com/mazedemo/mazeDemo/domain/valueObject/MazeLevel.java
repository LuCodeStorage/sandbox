package com.mazedemo.mazeDemo.domain.valueObject;

import lombok.Data;
import lombok.Getter;

import java.beans.JavaBean;

@Getter
public class MazeLevel {
    private final int value;

    public MazeLevel(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("レベルは正の数で入力してください");
        }
        this.value = value;
    }
}
