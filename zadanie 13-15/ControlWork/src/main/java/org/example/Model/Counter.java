package org.example.Model;

public class Counter implements AutoCloseable {
    static int count = 0;
    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        throw new RuntimeException("Counter dead");
    }
}
