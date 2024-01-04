package com.example.gatheringhaja.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class S3Config {

    //    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey = "AKIAQQTPC6YH64TSTY67";

    //    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey = "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";

//    @Value("${cloud.aws.region.static}")
    private String region = "ap-northeast-2";

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return (AmazonS3Client) AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

}
