package com.epamlabs.lab2;

import java.util.*;

public class NotationConverter {

    private ArrayList<String> postfixNotation;

    private Stack<String> signs;

    private String[] tokens;

    public NotationConverter(){
        this.signs = new Stack<String>();
        this.postfixNotation = new ArrayList<String>();
    }

    public void setExpression(String expression) {
        this.tokens = expression.split(" ");
    }

    ArrayList<String> parse(){
        signs.add(".");

        for (int iter = 0; iter < tokens.length; iter++) {
//            System.out.printf("parsefor at %d \n", iter);
            if(isNumber(tokens[iter])){
                addNumber(tokens[iter]);
            } else if (isSign(tokens[iter])) {
                addSign(tokens[iter]);
            } else {
                throw new IllegalArgumentException(String.format("Incorrect token in expression: '%s'", tokens[iter]));
            }
        }
        addSign(".");
        return postfixNotation;
    }

    private void addNumber(String number){
        postfixNotation.add(number);
    }

    private void addSign(String sign){
        int texasPriority = getPriority(signs.peek());
        int signPriority = getPriority(sign);

        if(sign.equals("(")) {
            signs.add(sign);
            return;
        }

        while (signPriority <= texasPriority && !signs.empty()) {
//            System.out.printf("while on s = %s  t = %s \n", sign, signs.peek());
            if (sign.equals(")")){
                if(signs.peek().equals("(")) {
                    signs.pop();
                    return;
                } else if(signs.peek().equals(")")){
                    throw new IllegalArgumentException("Expression is unbalanced");
                }
            }

            postfixNotation.add(signs.pop());
            if (!signs.isEmpty()) texasPriority = getPriority(signs.peek());
        }

        if (signPriority > texasPriority) {
            signs.add(sign);
        }
    }

    private int getPriority(String sign){
        String[] priorityRegex = {"\\.", "[)(]", "[+\\-]", "[/*]", "[0-9]+"};
        for(int i = 0; i < priorityRegex.length; i++){
            if (sign.matches(priorityRegex[i])) return i;
        }
        throw new IllegalArgumentException(String.format("Unresolved sign: '%s'", sign));
    }

    private boolean isSign(String token){
        return token.matches("[/*+\\-()]");
    }

    private boolean isNumber(String token){
        return token.matches("-?[0-9]+[.,]?[0-9]*");
    }


}
