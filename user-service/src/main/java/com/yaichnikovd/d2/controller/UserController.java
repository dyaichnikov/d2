package com.yaichnikovd.d2.controller;

import com.yaichnikovd.d2.dto.UserDTO;
import com.yaichnikovd.d2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO fetch(@PathVariable final UUID id) {
        return userService.fetch(id);
    }

    @PostMapping
    public void create(@RequestBody final UserDTO dto) {
        userService.save(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable final UUID id, @RequestBody final UserDTO dto) {
        userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final UUID id) {
        userService.delete(id);
    }
}
