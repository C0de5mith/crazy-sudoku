package com.github.c0de5mith.crazysudoku.solver;

import com.github.c0de5mith.crazysudoku.rules.RuleBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PossibilitySet {
    private List<ConstrainedFuture> constrainedFutures = new ArrayList<>();
    public PossibilitySet(RuleBook ruleBook, short[][] board){
        //System.out.println("Generating possibility set");
        int n = board.length;
        int count = 0;
        long t = System.currentTimeMillis();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    ConstrainedFuture future = new ConstrainedFuture(i, j);
                    for(int k = 1; k <= n; k++){
                        if(ruleBook.isValid(board, i, j, (short) k)){
                            future.putFuture((short) k);
                            count++;
                        }
                    }
                    constrainedFutures.add(future);
                }
            }
        }
        //constrainedFutures.sort(new FutureSorter());
        //System.out.println("Possibility set generated with "+count+" futures in "+(System.currentTimeMillis()-t)+"ms");
    }
    public List<ConstrainedFuture> getConstrainedFutures(){
        return constrainedFutures;
    }
    public static class FutureSorter implements Comparator<ConstrainedFuture> {
        @Override
        public int compare(ConstrainedFuture o1, ConstrainedFuture o2) {
            return o1.getFutures().size() - o2.getFutures().size();
        }
    }
}
