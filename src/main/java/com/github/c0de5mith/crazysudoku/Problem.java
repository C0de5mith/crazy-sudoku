package com.github.c0de5mith.crazysudoku;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;
import com.github.c0de5mith.crazysudoku.rules.*;
import com.github.c0de5mith.crazysudoku.solver.ConstrainedFuture;
import com.github.c0de5mith.crazysudoku.solver.PossibilitySet;

import java.util.List;

public class Problem {
    private static short[][] seed;
    private static void set(int x, int y, int n){
        ArrayFormatter.setElement(seed, x, y, (short) n);
    }
    public static void main(String[] args){
        seed = new short[9][9];
        set(0, 0, 8);
        set(2, 1, 3);
        set(3, 1, 6);
        set(1, 2, 7);
        set(4, 2, 9);
        set(6, 2, 2);
        set(1, 3, 5);
        set(5, 3, 7);
        set(4, 4, 4);
        set(5, 4, 5);
        set(6, 4, 7);
        set(3, 5, 1);
        set(7, 5, 3);
        set(2, 6, 1);
        set(7, 6, 6);
        set(8, 6, 8);
        set(2, 7, 8);
        set(3, 7, 5);
        set(7, 7, 1);
        set(1, 8, 9);
        set(6, 8, 4);
        //seed[3][0] = 3;
        //seed[3][1] = 8;
        //seed[3][2] = 4;
        //seed[3][7] = 3;
        //seed[8][8] = 2;
        System.out.println();
        for(int i = 0; i < 9; i++){
            short[] row = ArrayFormatter.extractRow(seed, i);
            System.out.print("[");
            for(int j = 0; j < 8; j++){
                System.out.print(row[j]+", ");
            }
            System.out.println(row[8] + "]");
        }
        RuleBook ruleBook = new RuleBook();
        ruleBook.addRule(new UniqueSubSquareRule());
        ruleBook.addRule(new UniqueRowRule());
        ruleBook.addRule(new UniqueColumnRule());
        //ruleBook.addRule(new KnightRule());
        //ruleBook.addRule(new UniqueDiagonalRule());
        //ruleBook.addRule(new MagicSquareCenterRule());
        try{
            Sudoku sudoku = new Sudoku(ruleBook, seed);
            long t = System.currentTimeMillis();
            System.out.println("Found "+sudoku.solve().size()+" solutions in "+(System.currentTimeMillis() - t)+"ms");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
