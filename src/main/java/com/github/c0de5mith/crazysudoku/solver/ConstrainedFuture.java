package com.github.c0de5mith.crazysudoku.solver;

import java.util.HashSet;
import java.util.Set;

public class ConstrainedFuture {
    public final int i;
    public final int j;
    private Set<Short> futures = new HashSet<>();
    public ConstrainedFuture(int i, int j){
        this.i = i;
        this.j = j;
    }
    public void putFuture(short n){
        futures.add(n);
    }
    public Set<Short> getFutures(){
        return futures;
    }
}
