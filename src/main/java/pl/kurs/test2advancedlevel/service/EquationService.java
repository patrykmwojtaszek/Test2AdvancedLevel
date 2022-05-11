package pl.kurs.test2advancedlevel.service;

import org.springframework.stereotype.Service;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;
import pl.kurs.test2advancedlevel.model.EquationEvent;
import pl.kurs.test2advancedlevel.operators.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class EquationService implements IEquationService {

    private IEquationEventService equationEventService;
    private Addition addition;
    private Division division;
    private Multiplication multiplication;
    private Subtraction subtraction;

    public EquationService(IEquationEventService equationEventService, Addition addition, Division division, Multiplication multiplication, Subtraction subtraction) {
        this.equationEventService = equationEventService;
        this.addition = addition;
        this.division = division;
        this.multiplication = multiplication;
        this.subtraction = subtraction;
    }

    @Override
    public double solveEquation(String equation) throws InvalidEquationFormatException, UnknownOperatorException {
        validEquationString(equation);

        List<String> equationElementsList = new LinkedList<>(Arrays.asList(equation.split(" ")));

        for (int i = 0; i < equationElementsList.size(); i++) {
            if (i % 2 != 0) {
                switch (equationElementsList.get(i)) {
                    case "*":
                        equationElementsList.set(i-1, Double.toString(multiplication.getResult(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1)))));
                        equationElementsList.remove(i);
                        equationElementsList.remove(i);
                        break;
                    case "/":
                        equationElementsList.set(i-1, Double.toString(division.getResult(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1)))));
                        equationElementsList.remove(i);
                        equationElementsList.remove(i);
                        break;
                    default:
                }
            }
        }

        for (int i = 0; i < equationElementsList.size()-1; i++) {
            if (i % 2 != 0) {
                switch (equationElementsList.get(i)) {
                    case "+":
                        equationElementsList.set(i+1, Double.toString(addition.getResult(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1)))));
                        equationElementsList.set(i-1, "0");
                        break;
                    case "-":
                        equationElementsList.set(i+1, Double.toString(subtraction.getResult(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1)))));
                        equationElementsList.set(i-1, "0");
                        break;
                    default:
                }
            }
        }

        double equationResult = Double.parseDouble(equationElementsList.get(equationElementsList.size() - 1));

        equationEventService.saveEvent(new EquationEvent(Timestamp.from(Instant.now()), equation, equationResult));

        return equationResult;
    }

    public void validEquationString(String equation) throws InvalidEquationFormatException, UnknownOperatorException {
        String[] equationElements = equation.split(" ");

        for (int i = 0; i < equationElements.length; i++) {
            if (i % 2 == 0) {
                try {
                    Double.parseDouble(equationElements[i]);
                } catch (NumberFormatException e) {
                    throw new InvalidEquationFormatException("InvalidEquationFormatException!");
                }
            } else {
                String operator = equationElements[i];
                switch (operator) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        break;

                    default: throw new UnknownOperatorException("UnknownOperatorException!");
                }
            }
        }
    }


}
