package com.matheus.combaterpgapi.model;

import com.matheus.combaterpgapi.model.BaseCharacter;

public class MeleeCharacter extends BaseCharacter {

    // Atributo Const
    private final int RANGE = 2;

    // Construtores

    public MeleeCharacter(String name, int health, int position, int level){
        super(name, health, position,level);
        setRange(RANGE);
    }
}