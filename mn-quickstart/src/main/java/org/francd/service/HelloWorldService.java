package org.francd.service;

import jakarta.inject.Singleton;
import org.francd.config.HelloWorldTranslationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class HelloWorldService {

    private static Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    private HelloWorldTranslationConfig helloWorldTranslationConfig;

    public HelloWorldService(HelloWorldTranslationConfig helloWorldTranslationConfig) {
        this.helloWorldTranslationConfig = helloWorldTranslationConfig;
    }

    public String sayHelloWorld() {
        return "Hello world!";
    }

    public String sayHelloToName(String name) {
        log.debug(String.format("Calling sayHelloToName for name: %s",name));
        return String.format("Hello %s",name);
    }


    public String sayHelloWorldInLanguage(String language) {

        if ("ES".equalsIgnoreCase(language)) {
            return helloWorldTranslationConfig.getEs();
        }
        else if ("DE".equalsIgnoreCase(language)) {
            return helloWorldTranslationConfig.getDe();
        }
        return "Hello world!";
    }
}
