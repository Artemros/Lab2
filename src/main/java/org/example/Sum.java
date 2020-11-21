package org.example;

public class Sum {

    public Sum() {
        System.out.println("NEW");
    }

    private int a = 0;

    public int increase() {
        return a++;
    }

    public int decrease() {
        return a--;
    }
}
