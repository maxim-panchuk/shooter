package com.panchuk.shooter.business.dao;

import com.panchuk.shooter.business.model.Point;

import java.util.List;

public interface DAO {
    void add(Point entity);
    List<Point> getAll();
    void clear();
}
