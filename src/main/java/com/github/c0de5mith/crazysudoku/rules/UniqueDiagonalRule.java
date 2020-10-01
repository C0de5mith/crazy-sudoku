package com.github.c0de5mith.crazysudoku.rules;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;

import java.util.HashSet;
import java.util.Set;

public class UniqueDiagonalRule implements Rule {
    @Override
    public boolean checkBoard(short[][] board) {
        int zeroes = 0;
        int n = (int) Math.sqrt(board.length);
        Set<Short> uniqueList = new HashSet<>();
        short[] diagonal = ArrayFormatter.extractDiagonalA(board);
        for(short element : diagonal){
            uniqueList.add(element);
            if(element == 0)
                zeroes++;
        }
        if(zeroes > 0){
            zeroes--;
        }
        if(uniqueList.size() + zeroes != board.length)
            return false;
        uniqueList = new HashSet<>();
        diagonal = ArrayFormatter.extractDiagonalD(board);
        for(short element : diagonal){
            uniqueList.add(element);
            if(element == 0)
                zeroes++;
        }
        if(zeroes > 0){
            zeroes--;
        }
        if(uniqueList.size() + zeroes != board.length)
            return false;

        return true;
    }

    @Override
    public boolean isValid(short[][] board, int i, int j, short value) {
        int n = (int) Math.sqrt(board.length);
        int xp = n*(i % n) + j % n;
        int yp = n*(i/n) + j/n;
        if(xp == yp || xp == n - yp - 1){
            int zeroes = 0;
            board[i][j] = value;
            Set<Short> uniqueList = new HashSet<>();
            short[] diagonal = ArrayFormatter.extractDiagonalA(board);
            for(short element : diagonal){
                uniqueList.add(element);
                if(element == 0)
                    zeroes++;
            }
            if(zeroes > 0){
                zeroes--;
            }
            if(uniqueList.size() + zeroes != board.length)
                return false;
            zeroes = 0;
            uniqueList = new HashSet<>();
            diagonal = ArrayFormatter.extractDiagonalD(board);
            for(short element : diagonal){
                uniqueList.add(element);
                if(element == 0)
                    zeroes++;
            }
            board[i][j] = 0;
            if(zeroes > 0){
                zeroes--;
            }
            if(uniqueList.size() + zeroes != board.length)
                return false;
        }
        return true;
    }
}
