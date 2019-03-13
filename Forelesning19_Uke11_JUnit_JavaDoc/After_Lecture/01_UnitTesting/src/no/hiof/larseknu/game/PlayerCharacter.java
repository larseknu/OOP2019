package no.hiof.larseknu.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayableCharacter is a class that represent a playable character in the game.
 * Holds information about the name, health and current weapons.
 *
 * @author Lars Emil
 * @author Uncle Bob
 *
 */
public class PlayerCharacter
{
    private int health;
    private String name;
    private String nickName;
    private boolean isNoob;
    private ArrayList<String> weapons;

    /**
     * Sets a default name for the PlayerCharacter, sets isNoob to true and generates a list of starting weapons.
     */
    public PlayerCharacter()
    {
        name = generateName();
        isNoob = true;
        createStartingWeapons();
    }


    /**
     * Increases the health of the character within a random range between 0 and 100.
     * Should be called when the PlayerCharacter is sleeping.
     */
    public void sleep()
    {
        Random random = new Random();

        int healthIncrease = random.nextInt(101);

        health += healthIncrease;
    }

    /**
     * Decreases the PlayerCharacter health with the set damage, down to a minimum of 0.
     *
     * @param damage amount of damage the PlayerCharacter takes
     */
    public void takeDamage(int damage)
    {
        health = Math.max(0, health -= damage);
    }

    /**
     * Generates a name from a set list
     *
     * @return the generated name
     */
    private String generateName()
    {
        String[] names = new String[]
        {
            "Saeris",
            "Ryan",
            "Mal'Ganis",
            "Thor",
            "Mario"
        };

        return names[new Random().nextInt(names.length)];
    }


    /**
     *  Creates the list of weapons the PlayerCharacter should start with when created the first time.
     */
    private void createStartingWeapons()
    {
        ArrayList<String> startingWeapons = new ArrayList<>();

        startingWeapons.add("Long Bow");
        startingWeapons.add("Short Bow");
        startingWeapons.add("Short Sword");
        //startingWeapons.add("Long Bow");
        //startingWeapons.add("Staff Of Wonder");

        weapons = startingWeapons;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the nickName of the PlayerCharacter.
     *
     * @param nickName the nickName to be set
     *
     * @exception ProfanityException if the nickName is a bad word
     */
    public void setNickName(String nickName) {
        if (nickName.contains("Penis"))
            throw new ProfanityException(nickName + " contains a bad word that's not allowed");
        else
            this.nickName = nickName;
    }

    public boolean isNoob() {
        return isNoob;
    }

    public void setNoob(boolean noob) {
        isNoob = noob;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }
}
