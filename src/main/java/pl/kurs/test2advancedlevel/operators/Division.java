package pl.kurs.test2advancedlevel.operators;

import org.springframework.stereotype.Service;

@Service
public class Division implements IOperator {

    public Division() {
    }

    @Override
    public double getResult(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("We cannot divide by 0");}
        else {
            return a / b;
        }
    }
}
