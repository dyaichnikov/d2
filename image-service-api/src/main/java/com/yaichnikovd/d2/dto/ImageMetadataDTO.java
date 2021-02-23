package com.yaichnikovd.d2.dto;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ImageMetadataDTO {

    private UUID id;
    private String bucket;
    private String objectPath;
    private String description;
}
