package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeLevel;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.service.MazeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/mazes")
public class CreateMazeApi {
    private final MazeService mazeService;

    @PostMapping
    public ResponseEntity<MazeEntity> create(@RequestBody CreateMazeRequest req, UriComponentsBuilder uriBuilder) {
        MazeEntity maze = mazeService.createMaze(req.title(), req.level(), req.status());
        URI location = uriBuilder.path("mazes/{id}")
                .buildAndExpand(maze.getId().getValue())
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(maze, headers, HttpStatus.CREATED);
    }

    public record CreateMazeRequest(String title, int level, MazeStatus status) {}
}
