package com.bingbong.awsexercise.config;

import java.net.URI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

@Configuration
public class AwsConfig {

    private final String accessKeyId = "";
    private final String secretAccessKey = "";

    @Bean
    public SecretsManagerClient secretsManagerClient() {
        Region region = Region.AP_NORTHEAST_2;
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        return SecretsManagerClient.builder()
            .endpointOverride(URI.create("https://secretsmanager.ap-northeast-2.amazonaws.com"))
            .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
            .region(region)
            .build();
    }
}
