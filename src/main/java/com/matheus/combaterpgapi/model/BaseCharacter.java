package com.matheus.combaterpgapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseCharacter{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int level = 1;
    private int range;
}
