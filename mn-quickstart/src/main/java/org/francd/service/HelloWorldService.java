package org.francd.service;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class HelloWorldService {

    private static Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    public String sayHelloWorld() {
        return "Hello world!";
    }

    public String sayHelloToName(String name) {
        log.debug(String.format("Calling sayHelloToName for name: %s",name));
        return String.format("Hello %s",name);
    }
}
