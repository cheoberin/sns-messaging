package com.cheobs.sns_messaging.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSSNSConfig {

    @Value("${cloud.aws.permissions.access-key}")
    private String accessKey;

    @Value("${cloud.aws.permissions.secret}")
    private String secret;

    @Value("${cloud.aws.region.static}")
    private String region;


    @Primary
    @Bean
    public AmazonSNS getSnsClient() {
        return AmazonSNSClientBuilder.standard()
                .withRegion(region)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(accessKey, secret)
                        )
                )
                .build();
    }

}
