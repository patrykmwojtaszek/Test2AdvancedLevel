package pl.kurs.test2advancedlevel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "equation_events")
public class EquationEvent implements Serializable {
    static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp date;
    private String equation;
    private double result;

    public EquationEvent() {
    }

    public EquationEvent(Timestamp date, String equation, double result) {
        this.date = date;
        this.equation = equation;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getEquation() {
        return equation;
    }

    public double getResult() {
        return result;
    }


    @Override
    public String toString() {
        return "EquationEvent{" +
                "id=" + id +
                ", date=" + date +
                ", equation='" + equation + '\'' +
                ", result=" + result +
                '}';
    }
}
