package PokerGame;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Class that contains all the cards of the game
 */

public class PokerGame{

    private Deck deck;
    private final int AMOUNT_OF_PLAYERS = 2;
    private Player[] players;

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
        players = new Player[AMOUNT_OF_PLAYERS];
    }


    /**
     * Initializes the Game. Creates a new deck.
     */
    public void initialize() {
        deck = new Deck();
        deck.shuffle();
        //deck.deal();
    }

    /**
     * Adds players to a game's array of players
     * TODO : NOT WORKING
     * @param player to be added
     */
    public void addPlayersToGame(Player player) {
        players[0] = player;
}


    /**
     * Evaluates the hand
     * @param hand to be evaluated
     * @return the value of a hand as a String
     */
    public String evaluateHand (Hand hand) {

        int[] valueHistogram = createValueHistogramForHand(hand);
        boolean isPaired = checkIfHandIsPaired(valueHistogram);

        if (isPaired) {
            return evaluatePairedHand(valueHistogram);
        }
        else {
            return evaluateHandWithoutAPair(hand);
        }

    }

    /**
     * evaluates a hand that has a pair
     * @param valueHistogram array of integers where cards of a hand are organized according to their values.
     * @return value of a hand.
     */
    public String evaluatePairedHand(int [] valueHistogram) {
        int amountOfPairs = 0;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;

        for (int i = 0; i < valueHistogram.length; i++) {
            if (valueHistogram[i] == 2) amountOfPairs++;
            else if (valueHistogram[i] == 3) threeOfAKind = true;
            else if (valueHistogram[i] == 4) fourOfAKind = true;
        }
        if (fourOfAKind) return "Four of a Kind";
        if ((threeOfAKind) && (amountOfPairs == 1)) return "Full House";
        if (threeOfAKind) return "Three of a Kind";
        if (amountOfPairs == 2) return "Two Pair";
        else return "One Pair";
    }


    /**
     * evaluates a hand without a pair
     * @param hand to be evaluated
     * @return value of the hand
     */
    public String evaluateHandWithoutAPair(Hand hand) {
        hand.sortHand();
        List<Card> cardList = hand.getCards();
        Card highCard = cardList.get(4);

        if (checkIfStraight(hand) && checkIfFlush(hand) && highCard.getValue() ==14) return "Royal Flush";
        if (checkIfStraight(hand) && checkIfFlush(hand)) return "Straight Flush";
        if (checkIfStraight(hand)) return "Straight";
        if (checkIfFlush(hand)) return "Flush";

        return ("High Card: " + highCard);

    }
    /**
     * Checks whether the hand has more than one card with same value
     * @param valueHistogram
     * @return true if hand has at least one pair, false if all cards in the hand are of different value
     */
    public boolean checkIfHandIsPaired(int [] valueHistogram) {

        for (int i = 0; i < valueHistogram.length; i++) {
            if (valueHistogram[i] > 1) return true;
        }
        return false;
    }

    /**
     * Creates a histogram filled with the amount of cards of a certain value found in a hand that is evaluated
     * @return int array histogram filled with the amount of cards of a certain value found in a hand that is evaluated
     */
    public int [] createValueHistogramForHand(Hand hand) {

        // INDICES      0  1  2  3  4  5  6  7   8   9  10  11  12
        // CARD VALUES  2  3  4  5  6  7  8  9  10  11  12  13  14

        int [] cardValueHistogram = new int[15];
        List<Card> cardList = hand.getCards();

        for (int i = 0; i < cardValueHistogram.length; i++) {
            for (int j = 0; j < cardList.size(); j++) {
                if (cardList.get(j).getValue() == i) {
                    cardValueHistogram[i]++;
                }
            }
            }
        return cardValueHistogram;
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

        Hand hand1 = new Hand();
        hand1.addCardToHand(new Card("diamonds",14));
        hand1.addCardToHand(new Card("diamonds",13));
        hand1.addCardToHand(new Card("clubs",7));
        hand1.addCardToHand(new Card("spades",11));
        hand1.addCardToHand(new Card("diamonds",10));

        System.out.println(game.evaluateHand(hand1));

        Hand hand2 = new Hand();
        hand2.addCardToHand(new Card("diamonds",14));
        hand2.addCardToHand(new Card("diamonds",13));
        hand2.addCardToHand(new Card("diamonds",7));
        hand2.addCardToHand(new Card("diamonds",11));
        hand2.addCardToHand(new Card("diamonds",10));


        System.out.println(game.evaluateHand(hand2));


    }

} // end of Poker Class
