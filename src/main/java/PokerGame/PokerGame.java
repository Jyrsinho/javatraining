package PokerGame;

/**
 * Class that contains all the cards of the game
 */

public class PokerGame{

    private Deck deck;
    private Hand[] hands;
    private final int AMOUNT_OF_PLAYERS = 2;

    private final String[] pokerHandValues = {
                                                    "Royal Flush",
                                                    "Straight Flush",
                                                    "Four of a Kind",
                                                    "Full House",
                                                    "Flush",
                                                    "Straight",
                                                    "Three of a Kind",
                                                    "Two Pair",
                                                    "One Pair",
                                                    "High Card"
    };

    /**
     * Constructor for the PokerGame
     */
    public PokerGame() {
        hands = new Hand[AMOUNT_OF_PLAYERS];
    }

    /**
     * Initializes the Game. Creates a new deck.
     */
    public void initialize() {
        deck = new Deck();
    }



} // end of Poker Class
