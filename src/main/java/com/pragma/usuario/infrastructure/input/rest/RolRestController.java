package com.pragma.usuario.infrastructure.input.rest;

import com.pragma.usuario.application.dto.request.RolRequestDto;
import com.pragma.usuario.application.dto.response.RolResponseDto;
import com.pragma.usuario.application.dto.response.UserResponseDto;
import com.pragma.usuario.application.handler.IRolHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rol")
@RequiredArgsConstructor
public class RolRestController {

    private final IRolHandler rolHandler;

    @Operation(summary = "Add a new rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRol(@RequestBody RolRequestDto rolRequestDto) {
        rolHandler.saveRol(rolRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RolResponseDto>> getAllRoles() {
        return ResponseEntity.ok(rolHandler.getAllRoles());
    }


    @Operation(summary = "Get rol by id")
    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDto> getRolById(@PathVariable Long id){
        return ResponseEntity.ok(rolHandler.getRolById(id));
    }


}