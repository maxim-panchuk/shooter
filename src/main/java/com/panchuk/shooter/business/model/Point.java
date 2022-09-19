package com.panchuk.shooter.business.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shots")
@NoArgsConstructor
@AllArgsConstructor

    @Column(nullable = false, name = "r")
    private Double r;
    @Column(nullable = false, name = "result")
    private boolean result;
    @Column(nullable = false, name = "time")
    private String time;
}
