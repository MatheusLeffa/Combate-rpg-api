package com.matheus.combaterpgapi.model.Original;

public class ThingOriginal {

    // Atributos
    private String name;
    private int health = 1000;
    private boolean alive = true;
    private int position = 1;


    // Constructor
    public ThingOriginal(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public ThingOriginal(String name, int health, int position) {
        this.name = name;
        this.health = health;
        setPosition(position);
    }


    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
    }

    public int getPosition() {
        return position;
    }


    // Setter
    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPosition(int position) {
        if (position > 0) {
            this.position = position;
        } else {
            throw new RuntimeException("Deve ser informado valores maiores que 0, na posição do objeto: " + this.name);
        }
    }


    // Methods
    public String isAliveStr() {
        if (this.alive) {
            return (this.name + " ainda está vivo, com " + this.health + " de vida.");
        }
        if (this instanceof BaseCharacterOriginal) {
            return (this.name + " foi morto!");
        }
        return (this.name + " foi destruida!");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseCharacterOriginal x) {
            return this.name.equals(x.getName());
        }
        return false;
    }

    public int distance(ThingOriginal target) {
        return Math.max(Math.abs(this.position - target.position), 0);
    }
}
