package com.github.c0de5mith.crazysudoku.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleBook {
    private final List<Rule> rules = new ArrayList<>();
    public RuleBook(){
        rules.add(new UniqueSubSquareRule());
    }
    public void addRule(Rule rule){
        rules.add(rule);
    }
    public boolean checkBoard(short[][] board){
        for(Rule rule : rules){
            if(!rule.checkBoard(board)){
                //System.out.println("Violation of "+rule.getClass().getSimpleName());
                return false;
            }
        }
        return true;
    }
    public boolean isValid(short[][] board, int i, int j, short value){
        for(Rule rule : rules){
            if(!rule.isValid(board, i, j, value)){
                return false;
            }
        }
        return true;
    }
}
