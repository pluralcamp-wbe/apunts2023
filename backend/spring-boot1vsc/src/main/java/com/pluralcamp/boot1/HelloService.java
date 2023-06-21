package com.pluralcamp.boot1;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String message(){
        return "Hello from Spring Boot";
    }
}
