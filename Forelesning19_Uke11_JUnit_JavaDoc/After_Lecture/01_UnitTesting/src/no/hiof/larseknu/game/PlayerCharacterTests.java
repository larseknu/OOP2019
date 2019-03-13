package no.hiof.larseknu.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerCharacterTests
{
    private PlayerCharacter playerCharacter;

    @BeforeEach
    public void init(){
        playerCharacter = new PlayerCharacter();
    }

    @Test
    public void shouldHaveDefaultRandomGeneratedName()
    {
        assertNotEquals("", playerCharacter.getName(), "No name was generated");
    }


    @Test
    public void shouldNotHaveANickName()
    {
        assertNull(playerCharacter.getNickName());
    }


    @Test
    public void shouldBeNewbie()
    {
        assertEquals(true, playerCharacter.isNoob());
    }


    @Test
    public void shouldIncreaseHealthAfterSleeping() {
        int health = 100;

        playerCharacter.setHealth(health);

        playerCharacter.sleep();

        assertTrue(health < playerCharacter.getHealth());
    }

    @Test
    public void shouldIncreaseHealthInExpectedRangeAfterSleeping() {
        int startingHealth = 100;
        int maxHealth = 200;

        playerCharacter.setHealth(startingHealth);
        playerCharacter.sleep();
        int playerHealth = playerCharacter.getHealth();


        assertTrue(startingHealth < playerHealth && playerHealth < maxHealth);
    }


    @Test
    public void shouldHaveNoEmptyDefaultWeapons()
    {
        List<String> result = playerCharacter.getWeapons();

        assertFalse(result.isEmpty());
    }


    @Test
    public void shouldHaveALongBow()
    {
        List<String> result = playerCharacter.getWeapons();

        assertTrue(result.contains("Long Bow"));
    }


    @Test
    public void shouldNotHaveAStaffOfWonder()
    {
        List<String> result = playerCharacter.getWeapons();

        assertFalse(result.contains("Staff Of Wonder"));
    }


    @Test
    public void shouldHaveAllExpectedWeapons()
    {
        List<String> result = playerCharacter.getWeapons();

        List<String> weapons = new ArrayList<String>();

        weapons.add("Long Bow");
        weapons.add("Short Bow");
        weapons.add("Short Sword");

        assertEquals(weapons, result, "We don't have all weapons");
    }


    @Test
    public void profanityNicknameCastException() {
        assertThrows(ProfanityException.class, () -> playerCharacter.setNickName("Penis"));
    }


    @Test
    public void referenceEquality()
    {
        PlayerCharacter player1 = new PlayerCharacter();
        PlayerCharacter player2 = new PlayerCharacter();

        PlayerCharacter player1Clone = player1;

        assertEquals(player1, player1);

        assertEquals(player1, player1Clone);

        assertNotEquals(player1, player2);
    }

}
