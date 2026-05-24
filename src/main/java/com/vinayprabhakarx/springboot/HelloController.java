package com.vinayprabhakarx.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public ApiResponse home() {
        return new ApiResponse(
                "java-playground",
                "Spring Boot application is running."
        );
    }

    @GetMapping("/api/health")
    public ApiResponse health() {
        return new ApiResponse(
                "UP",
                "Application is healthy."
        );
    }

    @GetMapping("/api/greeting")
    public GreetingResponse greeting(
            @RequestParam(name = "name", defaultValue = "Spring Boot") String name
    ) {
        return new GreetingResponse(
                name,
                "Hello, " + name + "!"
        );
    }

    @GetMapping("/api/greeting/{name}")
    public GreetingResponse greetingByPath(@PathVariable("name") String name) {
        return new GreetingResponse(
                name,
                "Welcome, " + name + "!"
        );
    }

    private record ApiResponse(String status, String message) {
    }

    private record GreetingResponse(String name, String message) {
    }
}
