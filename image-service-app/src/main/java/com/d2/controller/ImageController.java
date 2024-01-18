package com.d2.controller;

import com.d2.dto.ImageRequest;
import com.d2.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping(value = ImageController.IMAGES_URI_PREFIX,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class ImageController {

    public static final String IMAGES_URI_PREFIX = "/images";

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam("userId") UUID userId, @Valid @RequestBody ImageRequest body) throws URISyntaxException {
        final var id = imageService.create(body, userId);

        return ResponseEntity.created(new URI("%s/%s".formatted(IMAGES_URI_PREFIX, id)))
                .build();
    }
}
