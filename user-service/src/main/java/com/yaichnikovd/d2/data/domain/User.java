package com.yaichnikovd.d2.data.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Length(min = 1, max = 255)
    private String firstName;

    @Length(min = 1, max = 255)
    private String lastName;

    @Email
    private String email;

}
