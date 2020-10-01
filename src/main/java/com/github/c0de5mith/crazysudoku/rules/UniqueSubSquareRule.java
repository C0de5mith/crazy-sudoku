package com.github.c0de5mith.crazysudoku.rules;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubSquareRule implements Rule {
    @Override
    public boolean checkBoard(short[][] board){
        for(short[] square : board){
            Set<Short> uniqueList = new HashSet<>();
            int zeroes = 0;
            for(short element : square){
                uniqueList.add(element);
                if(element == 0)
                    zeroes++;
            }
            if(zeroes > 0){
                zeroes--;
            }
            if(uniqueList.size() + zeroes != square.length){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(short[][] board, int i, int j, short value) {
        short[] square = board[i];
        square[j] = value;
        Set<Short> uniqueList = new HashSet<>();
        int zeroes = 0;
        for(short element : square){
            uniqueList.add(element);
            if(element == 0)
                zeroes++;
        }
        square[j] = 0;
        if(zeroes > 0){
            zeroes--;
        }
        return uniqueList.size() + zeroes == square.length;
    }
}
