package PokerGame;

import java.lang.reflect.Array;
import java.util.List;

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
        deck.shuffle();
    }


    /**
     * Evaluates the hand
     * @param hand to be evaluated
     * @return the value of a hand as a String
     */
    public String evaluateHand (Hand hand) {

        hand.sortHand();
        List<Card> cardList = hand.getCards();
        Card highCard = cardList.get(4);

        for (int i = 0; i < hand.getHandLength(); i++) {
            for (int j = i+1; j < hand.getHandLength(); j++) {
                if (cardList.get(i).getValue() == cardList.get(j).getValue()) return "One Pair";
            }
        }

        if (checkIfFlush(hand)) return "Flush";
        if (checkIfStraight(hand)) return "Straight";


        return "High Card: " + highCard.toString();
    }


    /**
     * Checks if the hand is a flush
     * @return True if hand is a flush - False if hand is not a flush
     */
    public boolean checkIfFlush (Hand hand) {
        String firsCardSuit = hand.getCards().get(0).getSuit();
        for (int i = 1; i < hand.getHandLength(); i++) {
            if (hand.getCards().get(i).getSuit().equals(firsCardSuit)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand is a straight
     * @param hand to be checked
     * @return true if hand is a straight - false if not
     */
    public boolean checkIfStraight (Hand hand) {
        int maxDifference = 1;
        Card currentCard = hand.getCards().get(0);
        Card nextCard;

        for (int i = 1; i < hand.getHandLength(); i++) {
            nextCard = hand.getCards().get(i);
            if (Math.abs(currentCard.getValue() - nextCard.getValue()) > maxDifference)
            {
                return false;
            }
            currentCard = hand.getCards().get(i);
        }
        return true;
    }

    /**
     * Test Class for Poker Game
     * @param args null
     */
    public static void main(String[] args) throws TooManyElementsException {

        PokerGame game = new PokerGame();
        game.initialize();

        Hand hand = new Hand();
        hand.addCardToHand(new Card("diamonds",14));
        hand.addCardToHand(new Card("diamonds",13));
        hand.addCardToHand(new Card("clubs",7));
        hand.addCardToHand(new Card("spades",11));
        hand.addCardToHand(new Card("diamonds",10));

        game.evaluateHand(hand);
        game.checkIfStraight(hand);
    }

} // end of Poker Class
