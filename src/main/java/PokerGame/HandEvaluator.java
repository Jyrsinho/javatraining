package PokerGame;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that evaluates the value of a Hand.
 */
public class HandEvaluator {

    /**
     * Evaluates the hand
     * @param hand to be evaluated
     * @return the value of a hand as a String
     */
    public String evaluateHand (Hand hand) {

        int[] valueHistogram = createValueHistogramForHand(hand);
        hand.updateHandValue(valueHistogram);
        boolean isPaired = checkIfHandIsPaired(valueHistogram);

        if (isPaired) {
            hand.updateHandValue(true);
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

        for (int j : valueHistogram) {
            if (j == 2) amountOfPairs++;
            else if (j == 3) threeOfAKind = true;
            else if (j == 4) fourOfAKind = true;
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

        return ("High Card");

    }


    /**
     * Checks whether the hand has more than one card with same value
     * @param valueHistogram array where all the values of a hand are sorted according to their appearance frequency.
     * @return true if hand has at least one pair, false if all cards in the hand are of different value
     */
    public boolean checkIfHandIsPaired(int [] valueHistogram) {

        for (int j : valueHistogram) {
            if (j > 1) return true;
        }
        return false;
    }

    /**
     * Creates a histogram filled with the amount of cards of a certain value found in a hand that is evaluated
     * @return int array histogram filled with the amount of cards of a certain value found in a hand that is evaluated
     */
    public int [] createValueHistogramForHand(Hand hand) {

        // INDICES        0  1  2  3  4  5  6  7  8  9  10  11  12  13  14
        // CARD VALUES          2  3  4  5  6  7  8  9  10  11  12  13  14

        int [] cardValueHistogram = new int[15];
        List<Card> cardList = hand.getCards();

        for (int i = 0; i < cardValueHistogram.length; i++) {
            for (Card card : cardList) {
                if (card.getValue() == i) {
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
        String firstCardSuit = hand.getCards().getFirst().getSuit();
        for (int i = 1; i < hand.getHandLength(); i++) {
            String nextCardSuit = hand.getCards().get(i).getSuit();
            if (!nextCardSuit.equals(firstCardSuit)) {
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
        Card currentCard = hand.getCards().getFirst();
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

}


