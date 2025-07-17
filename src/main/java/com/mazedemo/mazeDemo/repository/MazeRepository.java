package com.mazedemo.mazeDemo.repository;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeId;

import java.util.List;
import java.util.Optional;

public interface MazeRepository {
    void save(MazeEntity maze);
    Optional<MazeEntity> findById(MazeId id);
    List<MazeEntity> findAll();
    void deleteById(MazeId id);
}
