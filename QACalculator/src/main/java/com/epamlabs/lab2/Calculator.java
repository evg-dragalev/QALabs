package com.epamlabs.lab2;

import com.epamlabs.lab2.exceptions.DivisionByZeroException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Calculator {

    private NotationConverter nc;

    public Calculator(){
        this.nc = new NotationConverter();
    }

    public double calcExpression(String expression){
        nc.setExpression(expression);
        ArrayList<String> tokens = nc.parse();
        return calculate(tokens);
    }

    private double calculate(ArrayList<String> tokens){
        Stack<Double> result = new Stack<Double>();
        Iterator<String> tokensIter = tokens.iterator();
        String next;

        while(tokensIter.hasNext()){
            next = tokensIter.next();
            if (isNumber(next)){
                result.add(Double.valueOf(next));
            } else if (isSign(next)){
                result.add(operation(next, result.pop(), result.pop()));
            }
        }
        return result.pop();
    }

    private double operation(String sign, Double o1, Double o2){
        switch(sign.charAt(0)) {
            case '/':
                return divide(o2, o1);
            case '*':
                return multiply(o2, o1);
            case '+':
                return add(o2, o1);
            case '-':
                return subtract(o2, o1);
            default:
                throw new IllegalArgumentException(String.format("Unresolved sign: '%s'", sign));
        }
    }

    private double add(double a, double b){
        return a + b;
    }

    private double subtract(double a, double b){
        return a - b;
    }

    private double multiply(double a, double b){
        return a * b;
    }

    private double divide(double a, double b){
        if (b == 0) throw new DivisionByZeroException();
        return a / b;
    }

    private boolean isSign(String token){
        return token.matches("[*/\\-+]");
    }

    private boolean isNumber(String token){
        return token.matches("-?[0-9]+[.,]?[0-9]*");
    }
}
