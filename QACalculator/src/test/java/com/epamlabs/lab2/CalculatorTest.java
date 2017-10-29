package com.epamlabs.lab2;

import com.epamlabs.lab2.exceptions.DivisionByZeroException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void calcExpression_3plus4_result7(){
        Calculator calc = new Calculator();

        double actual = calc.calcExpression("3 + 4");

        double expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcExpression_5dot4minus4_result1dot4(){
        Calculator calc = new Calculator();

        double actual = calc.calcExpression("5.4 - 4");

        double expected = 5.4 - 4;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcExpression_4minus5_times8dot1_resultMinus8(){
        Calculator calc = new Calculator();

        double actual = calc.calcExpression("( 4 - 5 ) * 8");

        double expected = -8;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcExpression_6divideBy3_result2(){
        Calculator calc = new Calculator();

        double actual = calc.calcExpression("6 / 3");

        double expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = DivisionByZeroException.class)
    public void calcExpression_3divideBy0_resultIllegalArgumentException(){
        Calculator calc = new Calculator();

        double actual = calc.calcExpression("3 / 0");
    }
}
