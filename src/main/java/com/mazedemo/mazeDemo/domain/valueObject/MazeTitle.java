package com.mazedemo.mazeDemo.domain.valueObject;

public class MazeTitle {
    private final String value;

    public MazeTitle(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("タイトルは必須です");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
