package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.service.MazeService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mazes/update")
public class UpdateMazeApi {
    private final MazeService mazeService;

    public UpdateMazeApi(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody UpdateMazeRequest req) {
        mazeService.updateMaze(new MazeId(id), req.title(), req.level(), req.status());
    }

    public record UpdateMazeRequest(String title, int level, MazeStatus status) {}
}
