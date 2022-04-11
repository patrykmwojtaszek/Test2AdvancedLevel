package pl.kurs.test2advancedlevel.service;

import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;

public interface IEquationService {

    double solveEquation(String equation) throws InvalidEquationFormatException, UnknownOperatorException;

}
