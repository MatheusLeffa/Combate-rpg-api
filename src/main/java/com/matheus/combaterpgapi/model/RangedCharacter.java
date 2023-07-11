package com.matheus.combaterpgapi.model;

import com.matheus.combaterpgapi.model.BaseCharacter;

public class RangedCharacter extends BaseCharacter {

    // Atributo Const
    private final int RANGE = 20;


    // Construtores
    public RangedCharacter(String name, int health, int position, int level){
        super(name, health, position,level);
        setRange(RANGE);
    }
}
