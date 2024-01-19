package com.d2.mapper;

import com.d2.dto.ImageRequest;
import com.d2.model.Image;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface ImageMapper {

    Image to(final ImageRequest source, final UUID userId);
}
