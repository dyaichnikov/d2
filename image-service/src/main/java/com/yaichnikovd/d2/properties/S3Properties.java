package com.yaichnikovd.d2.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "amazon.s3")
@ConstructorBinding
@Getter
@RequiredArgsConstructor
public class S3Properties {

    private final String imageBucket;
    private final String keyPrefix;

}
