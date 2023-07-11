package com.matheus.combaterpgapi;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;


class BaseCharacterTest {
    Factions factions;
    BaseCharacter meleeChar;
    BaseCharacter rangedChar;
    int testValue = (int) (Math.random()*100);


    @BeforeEach
    void setUp() {
        factions = new Factions();
        meleeChar = new MeleeCharacter("MeeleCharacter", 1000, 1,5);
        rangedChar = new RangedCharacter("RangedCharacter", 1000, 1,5);
    }

    @RepeatedTest(5)
    @DisplayName("printFaction Test")
    void printFaction() {
        for (int i = 0; i < 5; i++) {
            String generatedString = RandomStringUtils.randomAlphanumeric(10);
            factions.joinFaction(meleeChar,generatedString);
        }
        System.out.println(meleeChar.getFaction());

        assertThat(meleeChar.getFaction(),hasItems());
        assertEquals(meleeChar.getName() + " faction : " + meleeChar.getFaction().toString(), meleeChar.printFaction());
    }

    @RepeatedTest(5)
    @DisplayName("Attack test")
    void attack() {
        // Attack x1 Test
        meleeChar.setLevel(5);
        rangedChar.setLevel(5);
        meleeChar.attack(rangedChar, testValue);
        assertEquals(1000- testValue, rangedChar.getHealth());

        // Attack x0.5 Test
        rangedChar.setHealth(1000);
        meleeChar.setLevel(5);
        rangedChar.setLevel(10);
        meleeChar.attack(rangedChar, testValue);
        assertEquals(Math.round(1000-(testValue *0.5)), rangedChar.getHealth());

        // Attack x1.5 Test
        rangedChar.setHealth(1000);
        meleeChar.setLevel(10);
        rangedChar.setLevel(5);
        meleeChar.attack(rangedChar, testValue);
        assertEquals(Math.round(1000-(testValue *1.5)), rangedChar.getHealth());
    }


    @RepeatedTest(5)
    @DisplayName("Heal test")
    void heal() {
        meleeChar.setHealth(100);
        rangedChar.setHealth(100);
        factions.joinFaction(meleeChar, "TestFaction");
        factions.joinFaction(rangedChar, "TestFaction");

        meleeChar.heal(rangedChar, testValue);
        meleeChar.heal(meleeChar, testValue);

        assertEquals(100+testValue, meleeChar.getHealth());
        assertEquals(100+testValue, rangedChar.getHealth());
    }
}