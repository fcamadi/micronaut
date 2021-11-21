package org.francd.service;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService {

    public String sayHelloWorld() {
        return "Hello world!";
    }

    public String sayHelloToName(String name) {
        return String.format("Hello %s",name);
    }
}
