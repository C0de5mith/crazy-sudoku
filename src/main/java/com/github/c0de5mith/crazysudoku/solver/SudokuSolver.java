package com.github.c0de5mith.crazysudoku.solver;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;
import com.github.c0de5mith.crazysudoku.rules.RuleBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuSolver {
    private static int count = 0;
    public static List<short[][]> solve(RuleBook ruleBook, short[][] board, int depth, boolean allSolutions){
        List<short[][]> solutions = new ArrayList<>();
        PossibilitySet possibilities = new PossibilitySet(ruleBook, board);
        if(possibilities.getConstrainedFutures().size() == 0){
            solutions.add(board);
            System.out.println("Found a solution");
            for(int i = 0; i < 9; i++){
                short[] row = ArrayFormatter.extractRow(board, i);
                System.out.print("[");
                for(int j = 0; j < 8; j++){
                    System.out.print(row[j]+", ");
                }
                System.out.println(row[8] + "]");
            }
            return solutions;
        }
        ConstrainedFuture selectedFuture = possibilities.getConstrainedFutures().get(0);
        Set<Short> futures = selectedFuture.getFutures();
        for(short future : futures){
            if(depth == 0){
                System.out.println("New depth "+depth+" future: ["+selectedFuture.i+", "+selectedFuture.j+"] @ "+future);
            }
            board[selectedFuture.i][selectedFuture.j] = future;
            solutions.addAll(solve(ruleBook, board, depth + 1, allSolutions));
            if(solutions.size() > 0 && !allSolutions){
                return solutions;
            }
        }
        board[selectedFuture.i][selectedFuture.j] = 0;
        return solutions;
    }
}
