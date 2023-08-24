package com.matheus.combaterpgapi;

import com.matheus.combaterpgapi.model.Original.BaseCharacterOriginal;
import com.matheus.combaterpgapi.model.Original.FactionOriginal;
import com.matheus.combaterpgapi.model.Original.MeleeCharacterOriginal;
import com.matheus.combaterpgapi.model.Original.RangedCharacterOriginal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


class FactionOriginalTest {
    FactionOriginal factionOriginal;
    BaseCharacterOriginal meleeChar;
    BaseCharacterOriginal rangedChar;

    @BeforeEach
    void setUp() {
        factionOriginal = new FactionOriginal();
        meleeChar = new MeleeCharacterOriginal("MeeleCharacter", 1000, 1,5);
        rangedChar = new RangedCharacterOriginal("RangedCharacter", 1000, 1, 5);
    }

    @Test
    @DisplayName("joinFaction Test")
    void joinFaction() {
        factionOriginal.joinFaction(meleeChar,"TestFaction");
        factionOriginal.joinFaction(meleeChar,"TestFaction2");
        factionOriginal.joinFaction(rangedChar,"TestFaction");
        factionOriginal.joinFaction(rangedChar,"TestFaction2");

        assertThat(factionOriginal.getFactionList(),hasItems("TestFaction","TestFaction2"));
        assertThat(factionOriginal.getFactionMembers(),hasKey(meleeChar));
        assertThat(factionOriginal.getFactionMembers(),hasKey(rangedChar));

    }

    @Test
    @DisplayName("leaveFaction Test")
    void leaveFaction() {
        factionOriginal.joinFaction(meleeChar,"TestFaction");
        factionOriginal.joinFaction(rangedChar,"TestFaction");
        factionOriginal.leaveFaction(meleeChar,"TestFaction");
        factionOriginal.leaveFaction(rangedChar,"TestFaction");

        assertThat(factionOriginal.getFactionList(),not(hasItem("TestFaction")));
        assertThat(factionOriginal.getFactionMembers(),not(hasKey(meleeChar)));
        assertThat(factionOriginal.getFactionMembers(),not(hasKey(rangedChar)));

    }
}