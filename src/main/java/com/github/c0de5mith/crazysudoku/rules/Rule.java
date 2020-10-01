package com.github.c0de5mith.crazysudoku.rules;

public interface Rule {
    boolean checkBoard(short[][] board);
    boolean isValid(short[][] board, int i, int j, short value);
}
