package com.pragma.usuario.infrastructure.input.rest;

import com.pragma.usuario.application.dto.request.UserRequestDto;
import com.pragma.usuario.application.dto.request.UserRequestDtoD;
import com.pragma.usuario.application.dto.response.UserResponseDto;
import com.pragma.usuario.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)
    })
    @PostMapping("/createOwner")
    public ResponseEntity<Void> saveUserOwner(@Valid @RequestBody UserRequestDto userRequestDto) {
        userRequestDto.setRol(2L);
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Add a new user")
    @PostMapping("/createUser")
    public ResponseEntity<Void> saveUserEmployed(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userHandler.getAllUsers());
    }

    @Operation(summary = "Delete a user")
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteuser(@Valid @RequestBody UserRequestDtoD userRequestDto) {
        userHandler.deleteUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Get a user")
    @PostMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
        UserResponseDto user = userHandler.getUserById(id);
        return ResponseEntity.ok(userHandler.getUserById(id));
    }

    @Operation(summary = "Get a  user by email")
    @PostMapping("/getUserEmail/{correo}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable("correo") String correo) {
        return ResponseEntity.ok(userHandler.getUserByEmail(correo));
    }

    @Operation(summary = "User Owner exist")
    @PostMapping("/userOwnerExist/{id}")
    public ResponseEntity<Boolean> userExist(@PathVariable("id") Long id){
        return ResponseEntity.ok(userHandler.userOwnerExist(id));
    }

}