package krelve.ssm.aop;

import org.springframework.stereotype.Component;

/**
 * Created by krelve on 2015/11/30.
 */
@Component("calculator")
public class CalculatorImpl implements Calculator {
    public int add(int a, int b) {
        System.out.println("add...");
        return a + b;
    }

    public int div(int a, int b) {
        System.out.println("div...");
        return a / b;
    }
}
