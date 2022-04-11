package pl.kurs.test2advancedlevel.app;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;
import pl.kurs.test2advancedlevel.model.Addition;
import pl.kurs.test2advancedlevel.model.Division;
import pl.kurs.test2advancedlevel.model.Multiplication;
import pl.kurs.test2advancedlevel.model.Subtraction;
import pl.kurs.test2advancedlevel.service.EquationService;
import pl.kurs.test2advancedlevel.service.IEquationService;

import javax.script.ScriptException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@ComponentScan(basePackages = "pl.kurs.test2advancedlevel")
public class Main {
    public static void main(String[] args) {


        try {

            System.out.println("Passed equation: " + args[0]);


            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
            IEquationService equationService = ctx.getBean(IEquationService.class);

//        System.out.println("Welcome in EquationSolverApp! Enter the equation, please: ");
//        Scanner scanner = new Scanner(System.in);
//        String equation = scanner.nextLine();

//        validEquationString(equation);


            System.out.println("The result = " + equationService.solveEquation(args[0]));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Arguments not passed!");
        } catch (InvalidEquationFormatException | UnknownOperatorException e) {
            System.err.println(e.getMessage());
        }


//        double resultEval = eval(equation);
//        System.out.println("wynik string to java code " + resultEval);


        // ZNALEZIONE W INTERNECIE - NIE DZIAŁA W TEJ WERSJI JAVA
//        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
//        try {
//            String result2 = engine.eval(equation).toString();
//            System.out.println(result2);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }


        // scanner.close();
    }


    // ZNALEZIONE W INTERNECIE
//    public static double eval(final String str) {
//        return new Object() {
//            int pos = -1, ch;
//
//            void nextChar() {
//                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
//            }
//
//            boolean eat(int charToEat) {
//                while (ch == ' ') nextChar();
//                if (ch == charToEat) {
//                    nextChar();
//                    return true;
//                }
//                return false;
//            }
//
//            double parse() {
//                nextChar();
//                double x = parseExpression();
//                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
//                return x;
//            }
//
//            double parseExpression() {
//                double x = parseTerm();
//                for (;;) {
//                    if      (eat('+')) x += parseTerm(); // addition
//                    else if (eat('-')) x -= parseTerm(); // subtraction
//                    else return x;
//                }
//            }
//
//            double parseTerm() {
//                double x = parseFactor();
//                for (;;) {
//                    if      (eat('*')) x *= parseFactor(); // multiplication
//                    else if (eat('/')) x /= parseFactor(); // division
//                    else return x;
//                }
//            }
//
//            double parseFactor() {
//                if (eat('+')) return +parseFactor(); // unary plus
//                if (eat('-')) return -parseFactor(); // unary minus
//
//                double x;
//                int startPos = this.pos;
//                if (eat('(')) { // parentheses
//                    x = parseExpression();
//                    if (!eat(')')) throw new RuntimeException("Missing ')'");
//                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
//                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
//                    x = Double.parseDouble(str.substring(startPos, this.pos));
//                } else if (ch >= 'a' && ch <= 'z') { // functions
//                    while (ch >= 'a' && ch <= 'z') nextChar();
//                    String func = str.substring(startPos, this.pos);
//                    if (eat('(')) {
//                        x = parseExpression();
//                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
//                    } else {
//                        x = parseFactor();
//                    }
//                    if (func.equals("sqrt")) x = Math.sqrt(x);
//                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
//                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
//                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
//                    else throw new RuntimeException("Unknown function: " + func);
//                } else {
//                    throw new RuntimeException("Unexpected: " + (char)ch);
//                }
//
//                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
//
//                return x;
//            }
//        }.parse();
//    }
}
