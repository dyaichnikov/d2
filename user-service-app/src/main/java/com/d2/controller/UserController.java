package com.d2.controller;

import com.d2.dto.UserRequest;
import com.d2.dto.UserResponse;
import com.d2.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping(value = UserController.USERS_URI_PREFIX,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserController {

    public static final String USERS_URI_PREFIX = "/users";

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody final UserRequest body) throws URISyntaxException {
        final var id = userService.create(body);

        return ResponseEntity.created(new URI("%s/%s".formatted(USERS_URI_PREFIX, id)))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> fetch(@PathVariable("id") final UUID id) {
        final var user = userService.fetch(id);

        return ResponseEntity.ok(user);
    }
}
