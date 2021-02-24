package com.yaichnikovd.d2.data.repository;

import com.yaichnikovd.d2.data.domain.ImageMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface ImageRepository extends JpaRepository<ImageMetadata, UUID> {

    Stream<ImageMetadata> findAllByUserId(UUID userId);
}
