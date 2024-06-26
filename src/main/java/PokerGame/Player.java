package PokerGame;

public class Player {

private Hand hand;
private final String name;
private final String color;



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
    public void updateHandValue(String handValue, int rankingValue) {
        this.hand.updateHandValue(handValue, rankingValue);
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

    /**
     * getter for players hands value
     * @return players hands evaluation
     */
    public String getHandValue() {
       return hand.getHandValue();
    }

    /**
     * getter for players hands ranking value
     * @return players hands ranking value. Smaller the number better the hand.
     */
    public int getHandRankingValue() {
        return hand.getRankingValue();
    }

    public String toString() {
        return "Player name:" + getName() + "- Player color: " + getColor();

    }

}
