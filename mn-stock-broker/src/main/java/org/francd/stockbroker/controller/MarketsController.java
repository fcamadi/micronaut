package org.francd.stockbroker.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.francd.stockbroker.infrasctructure.InMemoryStore;
import org.francd.stockbroker.model.Symbol;

import java.util.ArrayList;
import java.util.List;

@Controller("/markets/v1")
public class MarketsController {

    private InMemoryStore inMemoryStore;

    public MarketsController(InMemoryStore inMemoryStore) {
        this.inMemoryStore = inMemoryStore;
    }

    @Get
    public List<Symbol> getAll() {
        return inMemoryStore.getAllSymbols();
    }
}
