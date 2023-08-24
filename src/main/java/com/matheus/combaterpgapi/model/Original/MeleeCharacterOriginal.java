package com.matheus.combaterpgapi.model.Original;

import com.matheus.combaterpgapi.model.Original.BaseCharacterOriginal;

public class MeleeCharacterOriginal extends BaseCharacterOriginal {

    // Atributo Const
    private final int RANGE = 2;

    // Construtores

    public MeleeCharacterOriginal(String name, int health, int position, int level){
        super(name, health, position,level);
        setRange(RANGE);
    }
}