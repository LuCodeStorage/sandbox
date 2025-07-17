package com.mazedemo.mazeDemo.repository;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryMazeRepository implements MazeRepository{
    private final Map<UUID, MazeEntity> store = new HashMap<>();

    @Override
    public void save(MazeEntity maze) {
        store.put(maze.getId().getValue(), maze);
    }

    @Override
    public Optional<MazeEntity> findById(MazeId id) {
        return Optional.ofNullable(store.get(id.getValue()));
    }

    @Override
    public List<MazeEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(MazeId id) {
        store.remove(id.getValue());
    }
}
