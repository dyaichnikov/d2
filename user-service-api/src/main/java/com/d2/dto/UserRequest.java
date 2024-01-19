package com.d2.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class UserRequest extends UserBaseDTO {

    @ConstructorProperties({Fields.firstName, Fields.lastName, Fields.email})
    public UserRequest(final String firstName, final String lastName, final String email) {
        super(firstName, lastName, email);
    }
}
