package com.epamlabs.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String expression;
        System.out.println("Symbols should be separated with whitespaces.\n" +
                "You're able to use symbols /*-+() ,. 0-9.\n" +
                "Example: ( 8 + 2 * 5 ) / ( 1 + 3 * 2 + -4 )\n");
        while(true){
            System.out.printf("Enter expression: \n");
            try{
                expression = scan.readLine();
                System.out.printf("%f \n", calculator.calcExpression(expression));
            } catch(IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
}
