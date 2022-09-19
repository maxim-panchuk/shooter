package com.panchuk.shooter.business.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shots")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
@ToString
public class Point implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(nullable = true, name = "id")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "x")
    private Double x;
    @Column(nullable = false, name = "y")
    private Double y;
    @Column(nullable = false, name = "r")
    private Double r;
    @Column(nullable = false, name = "result")
    private boolean result;
    @Column(nullable = false, name = "time")
    private String time;
}
