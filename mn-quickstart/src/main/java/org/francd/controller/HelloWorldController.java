package org.francd.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpResponseWrapper;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.francd.service.HelloWorldService;

@Controller("/hello/v1")
public class HelloWorldController {

    private HelloWorldService helloWorldService;

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


}
