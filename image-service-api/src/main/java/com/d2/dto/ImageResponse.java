package com.d2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import java.beans.ConstructorProperties;
import java.time.Instant;
import java.util.UUID;

@Getter
@FieldNameConstants
public class ImageResponse extends ImageBaseDTO {

    @NotNull
    private final UUID id;

    @NotNull
    private final String path;

    @NotNull
    private final Instant uploadDate;

    @ConstructorProperties({Fields.id, Fields.path, ImageBaseDTO.Fields.description, Fields.uploadDate})
    public ImageResponse(UUID id, String path, String description, Instant uploadDate) {
        super(description);
        this.id = id;
        this.path = path;
        this.uploadDate = uploadDate;
    }
}
