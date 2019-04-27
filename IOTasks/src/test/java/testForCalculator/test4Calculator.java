package testForCalculator;

import calc.Calculator;
import org.junit.Test;

import java.io.PrintWriter;


public class test4Calculator {

    private static Calculator calc = new Calculator("calculator.txt");

    @Test()
    public void test(){
        calc.addition(2,6);
        calc.division(3,5);
        calc.multiplication(8,0);
        calc.division(6,0);
        calc.subtraction(3,10);
        calc.showHistory();

    }



}
