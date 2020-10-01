package com.github.c0de5mith.crazysudoku.rules;

import com.github.c0de5mith.crazysudoku.math.ArrayFormatter;

public class MagicSquareCenterRule implements Rule {
    private static short arraySum(short[] array){
        short sum = 0;
        for(short element : array){
            sum+=element;
        }
        return sum;
    }
    @Override
    public boolean checkBoard(short[][] board) {
        short[] square = board[board.length/2];
        int n = (int) Math.sqrt(square.length);
        short expectedSum = 0;
        short aSum;
        for(int k = 0; k < n; k++){
            aSum = arraySum(ArrayFormatter.extractSquareRow(square, k));
            if(expectedSum == 0)
                expectedSum = aSum;
            if(expectedSum != aSum && aSum != 0)
                return false;
            aSum = arraySum(ArrayFormatter.extractSquareColumn(square, k));
            if(expectedSum == 0)
                expectedSum = aSum;
            if(expectedSum != aSum && aSum != 0)
                return false;
        }
        aSum = arraySum(ArrayFormatter.getSquareDiagonalA(square));
        if(expectedSum == 0)
            expectedSum = aSum;
        if(expectedSum != aSum && aSum != 0)
            return false;
        aSum = arraySum(ArrayFormatter.getSquareDiagonalD(square));
        if(expectedSum == 0)
            expectedSum = aSum;
        if(expectedSum != aSum && aSum != 0)
            return false;
        return true;
    }

    @Override
    public boolean isValid(short[][] board, int i, int j, short value) {
        if(i == board.length/2){
            short[] square = board[board.length/2];
            int n = (int) Math.sqrt(square.length);
            short expectedSum = 0;
            short aSum;
            for(int k = 0; k < n; k++){
                aSum = arraySum(ArrayFormatter.extractSquareRow(square, k));
                if(expectedSum == 0)
                    expectedSum = aSum;
                if(expectedSum != aSum && aSum != 0)
                    return false;
                aSum = arraySum(ArrayFormatter.extractSquareColumn(square, k));
                if(expectedSum == 0)
                    expectedSum = aSum;
                if(expectedSum != aSum && aSum != 0)
                    return false;
            }
            aSum = arraySum(ArrayFormatter.getSquareDiagonalA(square));
            if(expectedSum == 0)
                expectedSum = aSum;
            if(expectedSum != aSum && aSum != 0)
                return false;
            aSum = arraySum(ArrayFormatter.getSquareDiagonalD(square));
            if(expectedSum == 0)
                expectedSum = aSum;
            if(expectedSum != aSum && aSum != 0)
                return false;
        }
        return true;
    }
}
