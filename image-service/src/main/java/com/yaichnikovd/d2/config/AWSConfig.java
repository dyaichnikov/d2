package com.yaichnikovd.d2.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Bean
    public AmazonS3 s3() {
        return AmazonS3ClientBuilder.defaultClient();
    }

    @Bean
    public TransferManager transferManager() {
        return TransferManagerBuilder.defaultTransferManager();
    }
}
