package com.matheus.combaterpgapi.model.Original;

import com.matheus.combaterpgapi.model.Original.BaseCharacterOriginal;

public class RangedCharacterOriginal extends BaseCharacterOriginal {

    // Atributo Const
    private final int RANGE = 20;


    // Construtores
    public RangedCharacterOriginal(String name, int health, int position, int level){
        super(name, health, position,level);
        setRange(RANGE);
    }
}
