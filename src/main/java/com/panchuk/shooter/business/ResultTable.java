package com.panchuk.shooter.business;

import com.panchuk.shooter.business.utils.PointService;
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
    private ArrayList<Point> points = new ArrayList<>();

    @Inject
    private UserInput userInput;

    public void add() {
        if (valid()) {
            Point point = new Point();
            point.setX(Double.parseDouble(userInput.getXVal()));
            point.setY(Double.parseDouble(userInput.getYVal()));
            point.setR(Double.parseDouble(userInput.getRVal()));
            PointService pointService = new PointService(point);
            pointService.handle();
            points.add(point);
        }
    }

    public void clear() {
        points.clear();
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
