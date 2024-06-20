package PokerGame;

public class Player {

private Hand hand;
private String name;
private String color;
private String value;



    /**
     * Constructor for player
     * @param name of the player
     * @param color associated to a player
     */
    public Player(Hand hand, String name, String color) {
        this.hand = hand;
        this.name = name;
        this.color = color;
    }

    /**
     * updates player's hand's value
     * @param handValue new value for players hand
     */
    public void updateHandValue(String handValue) {
        this.hand.updateHandValue(handValue);
    }

    public Hand getHand() {
        return this.hand;
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
