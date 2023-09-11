package com.matheus.combaterpgapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Character extends Thing{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private int level = 1;
    @Column(nullable = false)
    private int range = 1;
    @Column
    @ManyToMany(mappedBy = "characterList")
    private Set<Faction> factions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id.equals(character.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
