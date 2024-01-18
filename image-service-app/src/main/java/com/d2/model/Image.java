package com.d2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "images")
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Image {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String path;

    @Max(2200)
    private String description;

    @NotNull
    private Instant uploadDate = Instant.now();

    @NotNull
    private UUID userId;
}
