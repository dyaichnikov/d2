package com.d2.service;

import com.d2.dto.ImageRequest;
import com.d2.mapper.ImageMapper;
import com.d2.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;

    @Transactional
    public UUID create(final ImageRequest body, final UUID userId) {
        final var image = imageMapper.to(body, userId);
        // TODO: add s3 file upload logic
        final var savedImage = imageRepository.save(image);

        return savedImage.getId();
    }
}
