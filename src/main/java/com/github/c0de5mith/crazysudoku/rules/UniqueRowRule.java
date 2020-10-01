package com.github.c0de5mith.crazysudoku.rules;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;

import java.util.HashSet;
import java.util.Set;

public class UniqueRowRule implements Rule {
    @Override
    public boolean checkBoard(short[][] board) {
        int zeroes;
        for(int i = 0; i < board.length; i++){
            Set<Short> uniqueList = new HashSet<>();
            short[] row = ArrayFormatter.extractRow(board, i);
            zeroes = 0;
            for(short element : row){
                uniqueList.add(element);
                if(element == 0)
                    zeroes++;
            }
            if(zeroes > 0){
                zeroes--;
            }
            if(uniqueList.size() + zeroes != board.length){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(short[][] board, int i, int j, short value) {
        int zeroes = 0;
        int n = (int) Math.sqrt(board.length);
        Set<Short> uniqueList = new HashSet<>();
        board[i][j] = value;
        short[] row = ArrayFormatter.extractRow(board, (i/n)*n+j/n);
        for(short element : row){
            uniqueList.add(element);
            if(element == 0)
                zeroes++;
        }
        board[i][j] = 0;
        if(zeroes > 0){
            zeroes--;
        }
        return uniqueList.size() + zeroes == board.length;
    }
}
