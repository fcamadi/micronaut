package org.francd.controller;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldControllerTest {

    @Property(name = "hello.default.message")
    private String helloFromConfig;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void helloWorldEndpointRespondsWithProperContent() {
        var response = httpClient.toBlocking().retrieve("/hello/v1");
        assertEquals("Hello world!",response);
    }

    @Test
    void helloWorldEndpointRespondsWithProperContentAndStatusCode() {
        var response = httpClient.toBlocking().exchange("/hello/v1", String.class);
        assertEquals("Hello world!",response.body());
        assertEquals(HttpStatus.OK,response.getStatus());
    }


    @Test
    void helloWorldEndpointRespondsWithProperContentAndStatusCode_ForAGivenName() {
        var response = httpClient.toBlocking().exchange("/hello/v1/Jack", String.class);
        assertEquals("Hello Jack",response.body());
        assertEquals(HttpStatus.OK,response.getStatus());
    }

    @Test
    void defaultMessageFromConfig() {
        var response = httpClient.toBlocking().exchange("/hello/v1/default", String.class);
        assertEquals(helloFromConfig,response.body());
        assertEquals(HttpStatus.OK,response.getStatus());
    }
}
