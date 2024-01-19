package com.d2.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
@RequiredArgsConstructor
public class ImageBaseDTO {

    @Size(max = 2200)
    private final String description;
}
