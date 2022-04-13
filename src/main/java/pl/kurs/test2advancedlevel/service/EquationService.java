package pl.kurs.test2advancedlevel.service;

import org.springframework.stereotype.Service;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;
import pl.kurs.test2advancedlevel.model.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class EquationService implements IEquationService {

    private IEquationEventService equationEventService;

    public EquationService(IEquationEventService equationEventService) {
        this.equationEventService = equationEventService;
    }

    @Override
    public double solveEquation(String equation) throws InvalidEquationFormatException, UnknownOperatorException {
        validEquationString(equation);

        List<String> equationElementsList = new LinkedList<>(Arrays.asList(equation.split(" ")));

        for (int i = 0; i < equationElementsList.size(); i++) {
            if (i % 2 != 0) {
                switch (equationElementsList.get(i)) {
                    case "*":
                        equationElementsList.set(i-1, Double.toString(new Multiplication(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1))).getResult()));
                        equationElementsList.remove(i);
                        equationElementsList.remove(i);
                        break;
                    case "/":
                        equationElementsList.set(i-1, Double.toString(new Division(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1))).getResult()));
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
                        equationElementsList.set(i+1, Double.toString(new Addition(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1))).getResult()));
                        equationElementsList.set(i-1, "0");
                        break;
                    case "-":
                        equationElementsList.set(i+1, Double.toString(new Subtraction(Double.parseDouble(equationElementsList.get(i-1)), Double.parseDouble(equationElementsList.get(i+1))).getResult()));
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

    private void validEquationString(String equation) throws InvalidEquationFormatException, UnknownOperatorException {
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
