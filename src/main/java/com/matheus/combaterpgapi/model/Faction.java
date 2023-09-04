package com.matheus.combaterpgapi.model;

import com.matheus.combaterpgapi.model.Original.BaseCharacterOriginal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String factionName;
    @Transient
    private List<Character> characterList;

}
