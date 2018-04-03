package de.iisys.drossner.algodat.listen;

import java.util.function.Function;

public interface CoolList<T> {

    void insert(T data);
    T delete(Function<T, Boolean> func);
    T find(Function<T, Boolean> func);
    void print();

}
