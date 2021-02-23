package com.yaichnikovd.d2.controller;

import com.yaichnikovd.d2.dto.ImageMetadataDTO;
import com.yaichnikovd.d2.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    private void upload(@RequestParam final MultipartFile image,
                        @RequestParam final String description,
                        @RequestParam final UUID userId) {

        imageService.upload(image, description, userId);
    }


    @GetMapping
    private List<ImageMetadataDTO> findAllByUserId(@RequestParam final UUID userId) {
        return imageService.findImagesByUserId(userId);
    }
}
