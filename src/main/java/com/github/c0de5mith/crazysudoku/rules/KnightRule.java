package com.github.c0de5mith.crazysudoku.rules;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;

public class KnightRule implements Rule {
    @Override
    public boolean checkBoard(short[][] board) {
        return true;
    }

    public boolean isDuplicate(short[][] board, int x, int y, int n, short value){
        //System.out.println("Checking: ["+x+", "+y+"]");
        if(x > 0 && y > 0 && x < n && y < n){
            if(ArrayFormatter.extractElement(board, x, y) == value)
                return true;
        }
        return false;
    }

    @Override
    public boolean isValid(short[][] board, int i, int j, short value) {
        int n = (int) Math.sqrt(board.length);
        int xp = n*(i % n) + j % n;
        int yp = n*(i/n) + j/n;
        //System.out.println("["+i+", "+j+"] = ["+xp+", "+yp+"]");
        return !(isDuplicate(board, xp + 2, yp + 1, n, value) ||
                isDuplicate(board, xp + 1, yp + 2, n, value) ||
                isDuplicate(board, xp - 2, yp + 1, n, value) ||
                isDuplicate(board, xp - 1, yp + 2, n, value) ||
                isDuplicate(board, xp + 2, yp - 1, n, value) ||
                isDuplicate(board, xp + 1, yp - 2, n, value) ||
                isDuplicate(board, xp - 2, yp - 1, n, value) ||
                isDuplicate(board, xp - 1, yp - 2, n, value));
    }
}
