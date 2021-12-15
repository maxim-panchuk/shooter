package com.panchuk.shooter.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.inject.Named;

@Named
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Point {
    private Integer id;
    private Double x;
    private Double y;
    private Double r;
    private boolean result;
    private String time;
}
