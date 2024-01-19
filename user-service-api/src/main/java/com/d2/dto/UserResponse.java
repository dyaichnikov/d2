package com.d2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import java.beans.ConstructorProperties;
import java.time.Instant;
import java.util.UUID;

@Getter
@FieldNameConstants
public class UserResponse extends UserBaseDTO {

    @NotNull
    private final UUID id;

    @NotNull
    private final Instant regDate;

    @ConstructorProperties({Fields.id, Fields.regDate, UserBaseDTO.Fields.firstName, UserBaseDTO.Fields.lastName, UserBaseDTO.Fields.email})
    public UserResponse(final UUID id, final Instant regDate, final String firstName, final String lastName, final String email) {
        super(firstName, lastName, email);
        this.id = id;
        this.regDate = regDate;
    }
}
