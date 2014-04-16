package com.fan1tuan.dao.support.common;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class Pair<T, U> {
    private T name;
    private U value;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }

    public Pair() {}

    public Pair(T name, U value) {
        this.name = name;
        this.value = value;
    }
}
