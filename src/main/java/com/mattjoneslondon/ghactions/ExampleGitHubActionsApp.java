package com.mattjoneslondon.ghactions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ExampleGitHubActionsApp {

    public static void main(String[] args) {
        log.info("Starting example github actions app...");
        SpringApplication.run(ExampleGitHubActionsApp.class, args);
    }
}