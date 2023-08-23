package com.matheus.combaterpgapi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCharacterOriginal extends ThingOriginal {

    // Atributos
    private int level = 1;
    private int range;
    private final List<String> faction = new ArrayList<>();


    // Constructor
    public BaseCharacterOriginal(String name, int health, int position, int level){
        super(name, health, position);
        this.level = level;
    }


    // Getter
    public int getLevel() {
        return level;
    }

    public int getRange() {
        return range;
    }

    public List<String> getFaction() {
        return faction;
    }


    // Setter
    public void setRange(int range) {
        this.range = range;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Metodos
    public String printFaction() {
        return (this.getName() + " faction : " + this.faction.toString());
    }

    public void attack(ThingOriginal target, int damageValue) {
        if (attackExceptions(target, damageValue)) {
            int damage = calculateDamage(target, damageValue);
            if (damage >= target.getHealth()) {
                target.setHealth(0);
                target.setAlive(false);
            } else {
                target.setHealth(target.getHealth() - damage);
            }
            System.out.println("O personagem " + target.getName() + " levou " + damage + " de dano.");
            System.out.println(target.isAliveStr());
        }
    }

    private int calculateDamage(ThingOriginal target, int damageValue) {
        if (target instanceof BaseCharacterOriginal charTarget) {
            int levelDifference = charTarget.level - this.level;
            if (levelDifference >= 5) return (int) (damageValue * 0.5);
            if (levelDifference <= -5) return (int) (damageValue * 1.5);
            return damageValue;
        }
        return damageValue;
    }

    public void heal(BaseCharacterOriginal target, int healValue) {
        if (healExceptions(target, healValue)) {
            target.setHealth(Math.min(healValue + target.getHealth(), 1000));
            System.out.println("O personagem " + this.getName() + " curou " + healValue + " da vida do personagem " + target.getName() + ".");
        }
    }

    private boolean isAllies(BaseCharacterOriginal target) {
        for (String targetFaction : target.faction) {
            if (this.faction.contains(targetFaction)) {
                return true;
            }
        }
        return false;
    }


    // Exceptions
    private Boolean attackExceptions(ThingOriginal target, double damage) {
        if(target instanceof BaseCharacterOriginal charTarget){
            if (isAllies(charTarget)) {
                System.out.println("Não é possivel atacar aliados!");
                return false;
            }
        }
        if (target.equals(this)) {
            System.out.println("O personagem não pode atacar a si mesmo!");
            return false;
        }
        if (this.distance(target) > this.range) {
            System.out.println("O alvo está muito longe!");
            return false;
        }
        if (damage < 1) {
            System.out.println("O dano deve ter valores positivos!");
            return false;
        }
        if (!target.getAlive()) {
            System.out.println("O personagem já está morto!");
            return false;
        }
        return true;
    }

    private Boolean healExceptions(BaseCharacterOriginal target, int healValue) {
        if (!isAllies(target) && !target.equals(this)) {
            System.out.println("Só é possivel curar aliados!");
            return false;
        }
        if (healValue < 1) {
            System.out.println("A cura deve ter valores positivos.");
            return false;
        }
        if (!target.getAlive()) {
            System.out.println("O personagem já está morto.");
            return false;
        }
        return true;
    }
}
