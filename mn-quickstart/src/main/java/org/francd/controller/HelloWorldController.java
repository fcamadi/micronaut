package org.francd.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello/v1")
public class HelloWorldController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello world!";
    }

}
