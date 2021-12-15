package com.panchuk.shooter.business;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;


@Named
@ApplicationScoped
@Getter
@Setter
@ToString
public class ResultTable {
    private ArrayList<Point> points;
}
