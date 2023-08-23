package com.matheus.combaterpgapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ThingDTO {
    private Integer id;
    @NotEmpty
    private String name;
    private int health = 1000;
    private boolean alive = true;
    private int position = 1;
}
