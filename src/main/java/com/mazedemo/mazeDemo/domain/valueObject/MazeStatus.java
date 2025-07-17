package com.mazedemo.mazeDemo.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MazeStatus {
    DRAFT("作成中"),
    PUBLISHED("公開中"),
    PRIVATE("非公開");

    private final String label;

    MazeStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static MazeStatus fromLabel(String label) {
        for (MazeStatus status : MazeStatus.values()) {
            if (status.label.equals(label)) {
                return status;
            }
        }
        throw new IllegalArgumentException("無効なステータス: " + label);
    }
}
