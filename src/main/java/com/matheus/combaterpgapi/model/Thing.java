package com.matheus.combaterpgapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "thing")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int health = 1000;
    @Column(nullable = false)
    private boolean alive = true;
    @Column(nullable = false)
    private int position = 1;
}
