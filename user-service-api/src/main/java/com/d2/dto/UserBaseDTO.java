package com.d2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
@RequiredArgsConstructor
public class UserBaseDTO {

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    @Size(max = 320)
    private final String email;
}
