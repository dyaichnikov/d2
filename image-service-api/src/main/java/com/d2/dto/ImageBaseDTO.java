package com.d2.dto;

import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
@RequiredArgsConstructor
public class ImageBaseDTO {

    @Max(2200)
    private final String description;
}
