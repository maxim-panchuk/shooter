package com.panchuk.shooter.business.model;

import lombok.*;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Named
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Point {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Double x;
    private Double y;
    private Double r;
    private boolean result;
    private String time;
}
