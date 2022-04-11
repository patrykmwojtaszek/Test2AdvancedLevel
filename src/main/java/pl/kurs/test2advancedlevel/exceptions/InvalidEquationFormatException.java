package pl.kurs.test2advancedlevel.exceptions;

public class InvalidEquationFormatException extends Exception{

    public InvalidEquationFormatException() {
    }

    public InvalidEquationFormatException(String message) {
        super(message);
    }
}
