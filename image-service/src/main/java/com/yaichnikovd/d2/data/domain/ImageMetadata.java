package com.yaichnikovd.d2.data.domain;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "userId"})
public class ImageMetadata {

    private UUID id;
    private UUID userId;
    private String bucket;
    private String objectPath;
    private String description;
}
