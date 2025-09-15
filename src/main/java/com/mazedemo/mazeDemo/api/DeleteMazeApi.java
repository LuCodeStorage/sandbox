package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.service.MazeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/mazes")
public class DeleteMazeApi {
    private final MazeService mazeService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mazeService.deleteMaze(new MazeId(id));
    }
}
