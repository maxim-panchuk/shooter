package com.panchuk.shooter.business;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;


@Named
@ApplicationScoped
@Getter
@Setter
@ToString
public class ResultTable {
    private ArrayList<Point> points;

    @Inject
    private UserInput userInput;

    public void add() {
        if (valid()) {
            System.out.println(userInput.getXVal() + " " + userInput.getYVal() + " " + userInput.getRVal());
        }
    }

    private boolean valid() {
        if (userInput != null && userInput.getXVal() != null && userInput.getYVal() != null && userInput.getRVal() != null) {
            try {
                double x = Double.parseDouble(userInput.getXVal());
                double y = Double.parseDouble(userInput.getYVal());
                double r = Double.parseDouble(userInput.getRVal());

                if (y < 3.0 && y > -5.0) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
