package com.yaichnikovd.d2.data.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    private UUID id;

    @Length(min = 1, max = 255)
    private String firstName;

    @Length(min = 1, max = 255)
    private String lastName;

    @Email
    private String email;

}
