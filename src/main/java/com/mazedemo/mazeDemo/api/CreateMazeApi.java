package com.mazedemo.mazeDemo.api;

import com.mazedemo.mazeDemo.domain.MazeEntity;
import com.mazedemo.mazeDemo.domain.valueObject.MazeStatus;
import com.mazedemo.mazeDemo.service2.MazeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "MazeCreate", description = "CRUD API MAZE CREATE")
public class CreateMazeApi {
    private final MazeService mazeService;

    @Operation(summary = "迷路作成",
            description = "迷路のパラメータを受け取り、迷路情報を登録する")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "405", description = "入力チェックエラー")
    })

    @PostMapping
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Create Maze DATA")
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
