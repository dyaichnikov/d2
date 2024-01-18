package com.d2.dto;

import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import java.beans.ConstructorProperties;

@Getter
@FieldNameConstants
public class ImageRequest extends ImageBaseDTO {

    @ConstructorProperties({Fields.description})
    public ImageRequest(String description) {
        super(description);
    }
}
