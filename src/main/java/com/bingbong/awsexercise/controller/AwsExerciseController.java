package com.bingbong.awsexercise.controller;

import com.bingbong.awsexercise.config.AwsConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@RestController
public class AwsExerciseController {

    private final AwsConfig awsConfig;

    public AwsExerciseController(AwsConfig awsConfig) {
        this.awsConfig = awsConfig;
    }

    @GetMapping
    public String projectString() {
        return "AWS Exercise의 bingbong 프로젝트입니다.";
    }

    // https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code/secretsmanager 참고

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        SecretsManagerClient secretsManagerClient = awsConfig.secretsManagerClient();
        GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
            .secretId("production/aws-exercise")
            .build();

        GetSecretValueResponse valueResponse = secretsManagerClient.getSecretValue(valueRequest);
        String secret = valueResponse.secretString();

        return ResponseEntity.ok(secret);
    }

    @GetMapping("/health")
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok()
            .build();
    }
}
