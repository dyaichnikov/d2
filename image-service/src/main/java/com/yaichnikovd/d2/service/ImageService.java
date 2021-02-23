package com.yaichnikovd.d2.service;

import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.yaichnikovd.d2.data.domain.ImageMetadata;
import com.yaichnikovd.d2.data.mapper.ImageMapper;
import com.yaichnikovd.d2.data.repository.ImageRepository;
import com.yaichnikovd.d2.dto.ImageMetadataDTO;
import com.yaichnikovd.d2.properties.S3Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    private final TransferManager transferManager;
    private final S3Properties s3Properties;

    @Transactional
    public void upload(final MultipartFile image, final String description, final UUID userId) {
        final String objectPath = composeObjectPath();
        final String bucket = s3Properties.getImageBucket();
        final PutObjectRequest request;
        try {
            request = new PutObjectRequest(bucket, objectPath, image.getInputStream(), new ObjectMetadata());
        } catch (IOException e) {
            log.error("An error occurred: ", e);
            throw new RuntimeException(); //todo throw custom exception
        }

        final Upload upload = transferManager.upload(request);

        upload.addProgressListener((ProgressListener) progressEvent ->
                log.info("Uploaded {} % of {}", upload.getProgress().getPercentTransferred(), objectPath));

        imageRepository.save(ImageMetadata.builder()
                .bucket(bucket)
                .userId(userId)
                .objectPath(objectPath)
                .description(description)
                .build());
    }

    public List<ImageMetadataDTO> findImagesByUserId(final UUID userId) {
        return imageRepository.findAllByUserId(userId)
                .map(imageMapper::to)
                .collect(Collectors.toList());
    }

    private String composeObjectPath() {
        return format("%s/%s_%s", s3Properties.getKeyPrefix(), Instant.now().toEpochMilli(), randomAlphanumeric(8));
    }
}
