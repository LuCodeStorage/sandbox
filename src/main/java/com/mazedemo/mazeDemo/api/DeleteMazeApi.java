package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.service.MazeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/mazes/delete")
public class DeleteMazeApi {
    private final MazeService mazeService;

    public DeleteMazeApi(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mazeService.deleteMaze(new MazeId(id));
    }
}
