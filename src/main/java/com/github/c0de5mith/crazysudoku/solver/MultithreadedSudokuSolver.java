package com.github.c0de5mith.crazysudoku.solver;

import com.github.c0de5mith.crazysudoku.rules.RuleBook;

import java.util.List;

public class MultithreadedSudokuSolver {
    public static void solve(RuleBook ruleBook, short[][] board, int threadCount, SolverCallback callback){
        PossibilitySet possibilitySet = new PossibilitySet(ruleBook, board);
        List<ConstrainedFuture> futureList = possibilitySet.getConstrainedFutures();
        for(ConstrainedFuture future : futureList){

        }
    }
}
