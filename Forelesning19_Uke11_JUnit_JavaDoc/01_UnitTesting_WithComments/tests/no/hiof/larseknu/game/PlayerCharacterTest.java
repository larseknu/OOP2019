package no.hiof.larseknu.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerCharacterTest {

    private PlayerCharacter playerCharacter;

    /**
     * Method that initialises the PlayerCharacter-object for testing.
     * This runs before each of the other testing methods.
     */
    @BeforeEach
    public void init() {
        playerCharacter = new PlayerCharacter();
    }

    @Test
    public void shouldHaveDefaultRandomGeneratedName() {
        // Checks if the player name is equal to an empty String
        assertNotEquals("", playerCharacter.getName(), "No name was generated");
    }

    @Test
    public void shouldNotHaveNickName() {
        PlayerCharacter playerCharacter = new PlayerCharacter();

        // Checks if nickName is null
        assertNull(playerCharacter.getNickName());
    }

    @Test
    public void shouldBeNewbie() {
        // Checks if noob is true
        assertTrue(playerCharacter.isNoob());
    }

    @Test
    public void shouldIncreaseHealthAfterSleeping() {
        int health = 100;

        // Sets the health
        playerCharacter.setHealth(health);

        // Calls the sleep-method, which should increase health
        playerCharacter.sleep();

        // Checks if we gained any health after sleeping
        assertTrue(health < playerCharacter.getHealth());
    }

    // This test is repeated one hundred times
    @RepeatedTest(100)
    public void shouldIncreaseHealthInExpectedRangeAfterSleeping() {
        int startHealth = 100;
        int maxHealth = 200;

        // Sets the health
        playerCharacter.setHealth(startHealth);
        // Calls the sleep method, which should increase health
        playerCharacter.sleep();
        // Retreives the new health
        int playerHealth = playerCharacter.getHealth();

        // Checks if the new health has increased, and that it hasn't increased more than the max-health
        assertTrue(startHealth < playerHealth && playerHealth < maxHealth);
    }

    @Test
    public void shouldHaveNoEmptyDefaultWeapons() {
        List<String> result = playerCharacter.getWeapons();

        // Checks that we actually have some weapons (that it's not empty)
        assertFalse(result.isEmpty());
    }

    @Test
    public void shouldHaveADagger() {
        List<String> result = playerCharacter.getWeapons();

        // Checks if one of the weapons we have are the Dagger
        assertTrue(result.contains("Dagger"));
    }

    @Test
    public void shouldNotHaveWandOfMagicMissiles() {
        List<String> result = playerCharacter.getWeapons();

        // Checks that we don't have the Wand of Magic Missiles (damn it Johnny....)
        assertFalse(result.contains("Wand of Magic Missiles"));
    }

    @Test
    public void shouldHaveAllExpectedWeapons() {
        List<String> result = playerCharacter.getWeapons();

        List<String> startingWeapons = new ArrayList<>();

        startingWeapons.add("Dagger");
        startingWeapons.add("Shortsword");
        startingWeapons.add("Javelin");

        // Checks that we have all the starting weapons
        assertEquals(startingWeapons, result, "We don't have all weapons");
     }



    @Test
    public void profanityNicknameCastException() {
        // Checks that we get an profanityexception
        assertThrows(ProfanityException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                playerCharacter.setNickName("Penis");
            }
        });

        // Same check, only with lambda instead of an anonymous inner class
        // assertThrows(ProfanityException.class, () -> playerCharacter.setNickName("Penis"));
    }

    @Test
    public void referenceEquality() {
        // Creates some PlayerCharacter objects
        PlayerCharacter player1 = new PlayerCharacter();
        PlayerCharacter player2 = new PlayerCharacter();

        // Creates an object that points to the same instance
        PlayerCharacter player1Clone = player1;

        // Checks that the playercharacter is equal to itself
        assertEquals(player1, player1);

        // Checks that the two references points at the same instance
        assertEquals(player1, player1Clone);

        // Checks that the two playercharacters aren't equal
        assertNotEquals(player1, player2);

    }
}