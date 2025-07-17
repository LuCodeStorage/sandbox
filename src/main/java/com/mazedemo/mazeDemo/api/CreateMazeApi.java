package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeLevel;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.service.MazeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mazes/create")
public class CreateMazeApi {

    private final MazeService mazeService;

    public CreateMazeApi(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @PostMapping
    public MazeEntity create(@RequestBody CreateMazeRequest req) {
        return mazeService.createMaze(req.title(), req.level(), req.status());
    }

    public record CreateMazeRequest(String title, int level, MazeStatus status) {}
}
