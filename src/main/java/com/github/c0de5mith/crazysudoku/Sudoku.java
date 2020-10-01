package com.github.c0de5mith.crazysudoku;

import com.github.c0de5mith.crazysudoku.rules.RuleBook;
import com.github.c0de5mith.crazysudoku.solver.MultithreadedSudokuSolver;
import com.github.c0de5mith.crazysudoku.solver.SolverCallback;
import com.github.c0de5mith.crazysudoku.solver.SudokuSolver;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    short[][] board;
    RuleBook ruleBook;
    public Sudoku(RuleBook ruleBook, short[][] seed){
        board = seed;
        this.ruleBook = ruleBook;
    }
    public List<short[][]> solve(){
        return SudokuSolver.solve(ruleBook, board, 0, false);
    }
    public List<short[][]> multithreadedSolve(){
        List<short[][]> solutions = new ArrayList<>();
        MultithreadedSudokuSolver.solve(ruleBook, board, 4, new SolverCallback() {
            @Override
            public void call(short[][] solution) {
                solutions.add(solution);
            }
        });
        return solutions;
    }
}
