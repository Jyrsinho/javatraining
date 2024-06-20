package PokerGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Player {

private Hand hand;
private String name;
private String color;



    /**
     * Constructor for player
     * @param name of the player
     * @param color associated to a player
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * getter for the name of the Player
     * @return name of the Player
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter for the color of the Player
     * @return color associated to the Player
     */
    public String getColor() {
        return this.color;
    }

    public String toString() {
        return "Player name:" + getName() + "- Player color: " + getColor();

    }

}
