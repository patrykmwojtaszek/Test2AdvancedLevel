package pl.kurs.test2advancedlevel.exceptions;

public class UnknownOperatorException extends Exception{

    public UnknownOperatorException() {
    }

    public UnknownOperatorException(String message) {
        super(message);
    }
}
