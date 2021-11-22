package org.francd.controller;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.francd.service.HelloWorldService;

@Controller("/hello/v1")
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    @Property(name = "hello.default.message")
    private String helloFromConfig;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return helloWorldService.sayHelloWorld();
    }

    /*
    @Get(value = "/{name}", produces = MediaType.TEXT_PLAIN)
    public String helloToName(@PathVariable(name = "name") String name) {
        return helloWorldService.sayHelloToName(name);
    }
    */

    @Get(value = "/{name}", produces = MediaType.TEXT_PLAIN)
    public HttpResponse helloToName2(@PathVariable(name = "name") String name) {
        return  HttpResponse.ok(helloWorldService.sayHelloToName(name));
    }

    @Get(uri = "/default", produces = MediaType.TEXT_PLAIN)
    public String defaultHelloMessage() {
        return helloFromConfig;
    }


    @Get(value = "/language/{language}", produces = MediaType.TEXT_PLAIN)
    public String helloWorldLanguages(@PathVariable(name = "language") String language) {
        return helloWorldService.sayHelloWorldInLanguage(language);
    }

}
