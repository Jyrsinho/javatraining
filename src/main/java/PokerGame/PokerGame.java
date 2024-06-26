package PokerGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Class that contains all the cards of the game
 */

public class PokerGame{

    private Deck deck;
    private final int AMOUNT_OF_PLAYERS = 2;
    private final ArrayList<Player> players;

    private final String[] pokerHandValues = {
                                                    "Royal Flush",          //0
                                                    "Straight Flush",       //1
                                                    "Four of a Kind",       //2
                                                    "Full House",           //3
                                                    "Flush",                //4
                                                    "Straight",             //5
                                                    "Three of a Kind",      //6
                                                    "Two Pair",             //7
                                                    "One Pair",             //8
                                                    "High Card"             //9
    };

    /**
     * Constructor for the PokerGame
     */
    public PokerGame() {
        players = new ArrayList<>();
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
     * adds a Player to a game
     * @param player to be added
     */
    public void addPlayerToGame(Player player) {
        players.add(player);
    }


    /**
     * updates the hand values of all the players in the game
     */
    public void updateHandValues() {
        String handValue;
        int handRankingValue;
        for (Player player : players) {
            handValue = evaluateHand(player.getHand());
            handRankingValue = getIndexValueForHandValue(handValue);
            player.updateHandValue(handValue, handRankingValue);

        }
    }

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
            hand.updateHandValue(isPaired);
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

        return ("High Card");

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

        // INDICES        0  1  2  3  4  5  6  7  8  9  10  11  12  13  14
        // CARD VALUES          2  3  4  5  6  7  8  9  10  11  12  13  14

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
     * Finds out the winner of the game
     * @return winner of the game
     */
    public String findOutWinner() {

        ArrayList<Player> listOfPotentialWinners = new ArrayList<>();
        int bestIndexValue = players.getFirst().getHandRankingValue();
        listOfPotentialWinners.add(players.getFirst());


        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getHandRankingValue() < bestIndexValue) {
                listOfPotentialWinners.add(players.get(i));
                listOfPotentialWinners.removeFirst();
            }
            else if (players.get((i)).getHandRankingValue() == bestIndexValue) {
                listOfPotentialWinners.add(players.get(i));
            }
        }

        if (listOfPotentialWinners.size() == 1) {
            return listOfPotentialWinners.get(0).getName();
        }
        else return tiebreaker(listOfPotentialWinners);
    }



    /**
     * Finds out the winner in case that the hands same basic value and are separated only by their high card.
     * TODO right now only works with hands that do not pair.
     * @return winner's name
     */
    public String tiebreaker(ArrayList<Player> listOfPotentialWinners) {

        boolean winningHandIsPaired = listOfPotentialWinners.get(0).getHand().isPaired;

        if (winningHandIsPaired) {
           return tiebreakerForPairedHands(listOfPotentialWinners);
        }
        else return tiebreakerForNonPairedHands(listOfPotentialWinners);
    }

    /**
     * Checks which of potential winners has the best hand in case that the winning hand is not pairing one
     * and there are several players with same valued hand.
     * @param listOfPotentialWinners arraylist containing all the players that have the potential winning hand
     * @return winner/winners
     */
    public String tiebreakerForNonPairedHands(ArrayList<Player> listOfPotentialWinners) {

        Player playerWithBestHand = listOfPotentialWinners.getFirst();
        ArrayList <Player> listOfWinners =  new ArrayList<>();
        listOfWinners.add(playerWithBestHand);

        for (int i = 0; i < listOfPotentialWinners.size()-1; i++) {         // Go through all the players
                Player comparablePlayer = listOfPotentialWinners.get(i+1);
                Hand bestPlayersHand = playerWithBestHand.getHand();
                Hand comparablePlayerHand = comparablePlayer.getHand();

                for (int j = 4; j >= 0; j--) {      // Go throuhg all the cards
                    int bestPlayerCardValue = bestPlayersHand.getCards().get(j).getValue();
                    int comparablePlayerCardValue = comparablePlayerHand.getCards().get(j).getValue();
                    if (bestPlayerCardValue < comparablePlayerCardValue) {
                        playerWithBestHand = comparablePlayer;
                        listOfWinners.clear();
                        listOfWinners.add(comparablePlayer);
                         break;
                    }
                    if (bestPlayerCardValue > comparablePlayerCardValue){
                        break;
                    }
                    if (j ==0 ){
                        listOfWinners.add(comparablePlayer);
                    }
                }
        }
        if (listOfWinners.size() == 1) return listOfWinners.getFirst().getName();

        return convertWinnersArrayToString(listOfWinners);
    }


    public String convertWinnersArrayToString(ArrayList<Player> t) {
        StringBuilder sb = new StringBuilder("Tie: ");

        for (int i = 0, j =1; i <t.size() ; i++, j++) {
            sb.append(t.get(i).getName());
            if (j < t.size()) sb.append(" & ");
        }


        return String.valueOf(sb);

    }



    /**
     * Checks which of potential winners has the best hand in case that the winning hand is pairing one
     * and there are several players with same winning pair or two pair.
     * @param listOfPotentialWinners
     * @return
     */
    public String tiebreakerForPairedHands(ArrayList <Player> listOfPotentialWinners) {
        ArrayList<Player> listOfPotentialWinners2 = new ArrayList<>();
        listOfPotentialWinners2.add(listOfPotentialWinners.getFirst());
        Player playerWithBestHand;
        Player comparablePlayer;
        int playerWithBestHandHighestPairOrSet = 0;
        int comparablePlayerHighestPairOrSet = 0;

//find the highest valued pairs
        for (int i = 0, j=1; j < listOfPotentialWinners.size(); i++, j++) {
            playerWithBestHand = listOfPotentialWinners.get(i);
            comparablePlayer = listOfPotentialWinners.get(j);
            for (int k = 4; k >= 2 ; k--) {
                for (int l = 14; l > 1; l--) {
                    if (playerWithBestHand.getHand().cardHistogram[l] == k) {
                        playerWithBestHandHighestPairOrSet = l;
                    }
                    if (comparablePlayer.getHand().cardHistogram[l] == k) {
                        comparablePlayerHighestPairOrSet = l;
                    }
                }
            }
            if (comparablePlayerHighestPairOrSet > playerWithBestHandHighestPairOrSet) {
                listOfPotentialWinners.removeFirst();
                listOfPotentialWinners2.add(comparablePlayer);
            } else if (playerWithBestHandHighestPairOrSet == comparablePlayerHighestPairOrSet){
                listOfPotentialWinners2.add(comparablePlayer);
            }
        }


        if (listOfPotentialWinners2.size() == 1) {
            return listOfPotentialWinners2.get(0).getName();
        }
        else return tiebreakerForNonPairedHands(listOfPotentialWinners2);
    }


    /**
     * returns the amount of players in the game
     * @return amount of players in the game
     */
    public int getAmountOfPlayers() {
        return players.size();
    }


    /**
     * Help method for rating and comparing hands. Takes hand's value and assigns it a numerical value based on the poker
     * hand rankings. Smaller the number better the hand
     * @return the index value of handValue in the array pokerHandValues. -1 if handvalue is not a valid poker hand
     */
    public int getIndexValueForHandValue (String handValue) {
        for (int i = 0; i < pokerHandValues.length; i++) {
            if (Objects.equals(handValue, pokerHandValues[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Test Class for Poker Game
     * @param args null
     */
    public static void main(String[] args) throws TooManyElementsException {



    }

} // end of Poker Class
