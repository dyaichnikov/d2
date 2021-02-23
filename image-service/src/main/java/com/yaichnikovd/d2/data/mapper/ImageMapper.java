package com.yaichnikovd.d2.data.mapper;

import com.yaichnikovd.d2.data.domain.ImageMetadata;
import com.yaichnikovd.d2.dto.ImageMetadataDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMapper {

    ImageMetadataDTO to(ImageMetadata entity);

    ImageMetadata to(ImageMetadataDTO dto);
}
