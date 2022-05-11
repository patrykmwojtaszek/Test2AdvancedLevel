package pl.kurs.test2advancedlevel.operators;

import org.springframework.stereotype.Service;

@Service
public class Multiplication implements IOperator {

    public Multiplication() {
    }

    @Override
    public double getResult(double a, double b) {
        return a * b;
    }
}
