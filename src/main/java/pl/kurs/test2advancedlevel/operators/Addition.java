package pl.kurs.test2advancedlevel.operators;

import org.springframework.stereotype.Service;

@Service
public class Addition implements IOperator{


    public Addition() {
    }

    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
}
