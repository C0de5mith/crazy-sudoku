package com.github.c0de5mith.crazysudoku.math;

public class ArrayFormatter {
    public static short[] getSquare(short[][] board, int x, int y){
        return board[y*3+x];
    }
    public static short extractElement(short[][] board, int x, int y){
        return board[(y/3) *3+ (x/3)][(y%3)*3+x%3];
    }
    public static short[] extractSquareRow(short[] square, int i){
        int n = (int) Math.sqrt(square.length);
        short[] row = new short[n];
        int index = i*n;
        for(int k = 0; k < n; k++){
            row[k] = square[k + index];
        }
        return row;
    }
    public static short[] extractSquareColumn(short[] square, int i){
        int n = (int) Math.sqrt(square.length);
        short[] column = new short[n];
        int index = i%n;
        for(int k = 0; k < n; k++){
            column[k] = square[k*n + index];
        }
        return column;
    }
    public static void setElement(short[][] board, int x, int y, short value){
        board[(y/3) *3+ (x/3)][(y%3)*3+x%3] = value;
    }
    public static short[] extractRow(short[][] board, int index){
        short[] row = new short[board.length];
        int n = board.length;
        for(int i = 0; i < n; i++){
            row[i] = extractElement(board, i, index);
        }
        return row;
    }
    public static short[] extractColumn(short[][] board, int index){
        short[] row = new short[board.length];
        int n = board.length;
        for(int i = 0; i < n; i++){
            row[i] = extractElement(board, index, i);
        }
        return row;
    }
    public static short[] extractDiagonalD(short[][] board){
        int n = board.length;
        short[] diagonal = new short[n];
        for(int i = 0; i < n; i++){
            diagonal[i] = extractElement(board, i, i);
        }
        return diagonal;
    }
    public static short[] extractDiagonalA(short[][] board){
        int n = board.length;
        short[] diagonal = new short[n];
        for(int i = 0; i < n; i++){
            diagonal[i] = extractElement(board, i, n - i - 1);
        }
        return diagonal;
    }

    public static short[] getSquareDiagonalD(short[] square) {
        int n = (int) Math.sqrt(square.length);
        short[] diagonal = new short[n];
        for(int i = 0; i < n; i++){
            diagonal[i] = square[i*n+i];
        }
        return diagonal;
    }
    public static short[] getSquareDiagonalA(short[] square) {
        int n = (int) Math.sqrt(square.length);
        short[] diagonal = new short[n];
        for(int i = 0; i < n; i++){
            diagonal[i] = square[i*n+(n-i-1)];
        }
        return diagonal;
    }
}
