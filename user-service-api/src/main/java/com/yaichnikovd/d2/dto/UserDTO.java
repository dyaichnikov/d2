package com.yaichnikovd.d2.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UserDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
