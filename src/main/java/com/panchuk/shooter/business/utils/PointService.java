package com.panchuk.shooter.business.utils;

import com.panchuk.shooter.business.model.Point;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PointService {
    private final Point point;
    private final double x;
    private final double y;
    private final double r;



    public PointService (Point point) {
        this.point = point;
        x = point.getX();
        y = point.getY();
        r = point.getR();
    }

    public void handle () {
        point.setResult(isInArea());
        String currentTime = new SimpleDateFormat("hh:mm:ss").format(new Date());
        point.setTime(currentTime);
    }

    public boolean isInArea () {
        return x <= 0 && y >= 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r / 2 ||
                x <= 0 && y <= 0 && x >= -r && y >= -r ||
                x >= 0 && y <= 0 && y >= (x - r);
    }

}
