package com.bingbong.awsexercise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsExerciseController {

    @GetMapping
    public String projectString() {
        return "AWS Exercise의 v4 bingbong 프로젝트입니다.";
    }

    @GetMapping("/health")
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok()
            .build();
    }
}
