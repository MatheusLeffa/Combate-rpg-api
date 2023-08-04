package com.matheus.combaterpgapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "factions")
@Getter
@Setter
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String factionName;
    @Transient
    private List<BaseCharacter> characterList;

}
