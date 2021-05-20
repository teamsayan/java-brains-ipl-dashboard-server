package com.sayan.dataloader.converters;

import java.util.function.Function;

public class Converter<T, U> {
    private final Function<T, U> fromTypeA;
    private final Function<U, T> fromTypeB;

    public Converter(Function<T, U> fromTypeA, Function<U, T> fromTypeB) {
        this.fromTypeA = fromTypeA;
        this.fromTypeB = fromTypeB;
    }

    public final U fromTypeA(final T typeA){
        return fromTypeA.apply(typeA);
    }

    public final T fromTypeB(final U typeB){
        return  fromTypeB(typeB);
    }
}
