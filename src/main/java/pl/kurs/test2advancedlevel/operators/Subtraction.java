package pl.kurs.test2advancedlevel.operators;

import org.springframework.stereotype.Service;

@Service
public class Subtraction implements IOperator{

    public Subtraction() {
    }

    @Override
    public double getResult(double a, double b) {
        return a - b;
    }
}
