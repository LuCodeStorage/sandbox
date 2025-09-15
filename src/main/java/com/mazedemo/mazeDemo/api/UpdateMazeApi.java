package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.valueObject.MazeId;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.service.MazeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/mazes")
public class UpdateMazeApi {
    private final MazeService mazeService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody UpdateMazeRequest req) {
        mazeService.updateMaze(new MazeId(id), req.title(), req.level(), req.status());
        return ResponseEntity.noContent().build();
    }

    public record UpdateMazeRequest(String title, int level, MazeStatus status) {}
}
