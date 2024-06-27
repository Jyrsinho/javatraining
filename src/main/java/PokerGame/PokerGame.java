package PokerGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that contains all the cards of the game
 */

public class PokerGame{

    private Deck deck;
    private final int AMOUNT_OF_PLAYERS = 2;
    private final int AMOUNT_OF_CARDS_TO_BE_DEALT = 5;
    private final ArrayList<Player> players;
    private HandEvaluator handEvaluator;

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
        deck = new Deck();
        handEvaluator = new HandEvaluator();

    }


    /**
     * Initializes the Game. Creates a new deck.
     */
    public void initialize() {
        deck.shuffle();
        // deal(deck, players); TODO CREATE A METHOD FOR DEALING THE CARDS TO PLAYERS
    }

    /**
     * adds a Player to a game
     * @param player to be added
     */
    public void addPlayerToGame(Player player) {
        players.add(player);
    }


    /**
     * returns the amount of players in the game
     * @return amount of players in the game
     */
    public int getAmountOfPlayers() {
        return players.size();
    }

    /**
     * gives a task for the HandEvaluator to evaluate hands of every player in the game
     */
    public void evaluateHands() {
        for (Player player : players) {
            handEvaluator.evaluateHand(player.getHand());
        }
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
            return listOfPotentialWinners.getFirst().getName();
        }
        else return tiebreaker(listOfPotentialWinners);
    }


    /**
     * Finds out the winner in case that the hands same basic value and are separated only by their high card.
     * @return winner's name
     */
    public String tiebreaker(ArrayList<Player> listOfPotentialWinners) {

        boolean winningHandIsPaired = listOfPotentialWinners.getFirst().getHand().isPaired;

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

    /**
     * Checks which of potential winners has the best hand in case that the winning hand is pairing one
     * and there are several players with same winning pair or two pair.
     * @param listOfPotentialWinners list of players who have best valued hand so far
     * @return winner or winners of a deal
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
            return listOfPotentialWinners2.getFirst().getName();
        }
        else return tiebreakerForNonPairedHands(listOfPotentialWinners2);
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
     * updates the hand values of all the players in the game
     */
    public void updateHandValues() {
        String handValue;
        int handRankingValue;
        for (Player player : players) {
            handValue = handEvaluator.evaluateHand(player.getHand());
            handRankingValue = getIndexValueForHandValue(handValue);
            player.updateHandValue(handValue, handRankingValue);

        }
    }

    /**
     * Test Class for Poker Game
     * @param args null
     */
    public static void main(String[] args)  {


    }

} // end of Poker Class
