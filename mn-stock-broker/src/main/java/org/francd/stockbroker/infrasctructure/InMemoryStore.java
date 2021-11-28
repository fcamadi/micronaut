package org.francd.stockbroker.infrasctructure;

import jakarta.inject.Singleton;
import org.francd.stockbroker.model.Symbol;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class InMemoryStore {

    private final List<Symbol> symbolList;

    /*
    public InMemoryStore(List<Symbol> symbolList) {
        this.symbolList = symbolList;
    }
    */

    public InMemoryStore() {
        this.symbolList = Stream.of("AAPL","AMZN","FB","GOOG","MSFT","NFLX","TSLA")
                .map(Symbol::new).collect(Collectors.toList());
    }

    public List<Symbol> getAllSymbols() {
        return symbolList;
    }

}
