package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.service.MazeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mazes")
public class ReferMazeApi {
    private final MazeService mazeService;

    public ReferMazeApi(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @GetMapping
    public List<MazeEntity> getAll() {
        return mazeService.getAllMazes();
    }

    @GetMapping("/{id}")
    public MazeEntity get(@PathVariable UUID id) {
        return mazeService.getMaze(new MazeId(id)).orElseThrow();
    }
}
