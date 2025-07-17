package com.mazedemo.mazeDemo.service;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.domain.valueObject.MazeLevel;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.domain.valueObject.MazeTitle;
import com.mazedemo.mazeDemo.repository.MazeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MazeService {
    private final MazeRepository mazeRepository;

    public MazeService(MazeRepository mazeRepository) {
        this.mazeRepository = mazeRepository;
    }

    public MazeEntity createMaze(String title, int level, MazeStatus status) {
        MazeEntity maze = new MazeEntity(new MazeId(), new MazeTitle(title), new MazeLevel(level), status);
        mazeRepository.save(maze);
        return maze;
    }

    public Optional<MazeEntity> getMaze(MazeId id) {
        return mazeRepository.findById(id);
    }

    public List<MazeEntity> getAllMazes() {
        return mazeRepository.findAll();
    }

    public void updateMaze(MazeId id, String title, int level, MazeStatus status) {
        MazeEntity maze = new MazeEntity(new MazeId(mazeRepository.findById(id).orElseThrow().getId().getValue()),
                new MazeTitle(title), new MazeLevel(level), status);
        mazeRepository.save(maze);
    }

    public void deleteMaze(MazeId id) {
        mazeRepository.deleteById(id);
    }
}
