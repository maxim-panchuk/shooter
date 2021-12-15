package com.panchuk.shooter.business;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@Getter
@Setter
@ToString
@RequestScoped
@NoArgsConstructor
public class UserInput {
    private String xVal;
    private String yVal;
    private String rVal;
}
