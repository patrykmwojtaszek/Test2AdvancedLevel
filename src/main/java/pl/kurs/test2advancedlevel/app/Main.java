package pl.kurs.test2advancedlevel.app;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;
import pl.kurs.test2advancedlevel.service.IEquationService;

@ComponentScan(basePackages = "pl.kurs.test2advancedlevel")
public class Main {
    public static void main(String[] args) {


        try {
            System.out.println("Passed equation: " + args[0]);

            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
            IEquationService equationService = ctx.getBean(IEquationService.class);

            System.out.println("The result = " + equationService.solveEquation(args[0]));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Arguments not passed!");
        } catch (InvalidEquationFormatException | UnknownOperatorException e) {
            System.err.println(e.getMessage());
        }
    }
}
