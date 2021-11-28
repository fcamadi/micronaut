package org.francd.stockbroker.controller;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MarketsControllerTest {


    @Inject
    @Client("/")
    HttpClient httpClient;


    @Test
    void getAllMarketsRespondsWithProperContentAndStatusCode() {
        List<LinkedHashMap<String,String>> result = httpClient.toBlocking().retrieve("/markets/v1", List.class);
        assertEquals(7,result.size());
        assertThat(result)
                .extracting(entry -> entry.get("value"))
                .containsExactlyInAnyOrder("AAPL","AMZN","FB","GOOG","MSFT","NFLX","TSLA");
    }

}
