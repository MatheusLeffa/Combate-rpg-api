package com.matheus.combaterpgapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CharacterDTO extends ThingDTO{
    private Integer id;
    private int level = 1;
    private int range = 1;

}
