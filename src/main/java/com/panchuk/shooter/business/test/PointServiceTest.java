package com.panchuk.shooter.business.test;

import com.panchuk.shooter.business.model.Point;
import com.panchuk.shooter.business.utils.PointService;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointServiceTest {
    private Point point;

    @Before
    public void setUp() {
        point = new Point();
    }

    @Test
    public void isHitCircleTrue() {
        double r = 3.0d;
        double y = 1.0d;
        double x = -1.0d;

        point.setX(x);
        point.setY(y);
        point.setR(r);

        PointService pointService = new PointService(point);
        boolean result = pointService.isInArea();

        assertTrue(result);
    }

    @Test
    public void isHitCircleFalse() {
        double r = 3.0d;
        double y = 3.0d;
        double x = 3.0d;

        point.setX(x);
        point.setY(y);
        point.setR(r);

        PointService pointService = new PointService(point);
        boolean result = pointService.isInArea();

        assertFalse(result);
    }

    @Test
    public void isHitSquareTrue() {
        double r = 3.0d;
        double y = -1.0d;
        double x = -1.0d;

        point.setX(x);
        point.setY(y);
        point.setR(r);

        PointService pointService = new PointService(point);
        boolean result = pointService.isInArea();

        assertTrue(result);
    }

    @Test
    public void isHitSquareFalse() {
        double r = 3.0d;
        double y = 1.0d;
        double x = -1.0d;

        point.setX(x);
        point.setY(y);
        point.setR(r);

        PointService pointService = new PointService(point);
        boolean result = pointService.isInArea();

        assertTrue(result);
    }
}
