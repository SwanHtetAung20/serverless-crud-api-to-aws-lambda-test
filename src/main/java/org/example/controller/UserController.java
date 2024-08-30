package org.example.controller;

import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.add(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDto>> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletedUser(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updatedUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserDto(id, userDto));
    }
}
