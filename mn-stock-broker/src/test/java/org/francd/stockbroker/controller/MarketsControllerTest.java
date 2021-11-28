package org.francd.stockbroker.controller;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MarketsControllerTest {


    @Inject
    @Client("/")
    HttpClient httpClient;


    @Test
    void getAllMarketsRespondsWithProperContentAndStatusCode() {
        var response = httpClient.toBlocking().retrieve("/markets/v1", List.class);
        assertEquals(7,response.size());
    }



}
