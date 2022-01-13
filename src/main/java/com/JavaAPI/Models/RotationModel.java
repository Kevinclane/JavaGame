package com.JavaAPI.Models;

import org.springframework.data.annotation.Id;

public class RotationModel {
    @Id
    public String id;
    public int agility;
    public int count = 0;

    public RotationModel(String id, int agility) {
        this.id = id;
        this.agility = agility;
    }
}
