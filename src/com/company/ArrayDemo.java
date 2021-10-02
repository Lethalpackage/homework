package com.company;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ArrayDemo<E> {
    private static final int DEFAULT_CAPACITY = 10;


    private static final Object[] EMPTY_ELEMENTDATA = {};


    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    transient Object[] elementData; // non-private to simplify nested class access


    private int size;


    public ArrayDemo(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }


}











