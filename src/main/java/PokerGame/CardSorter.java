package PokerGame;
import java.util.ArrayList;
import java.util.Collections;

public class CardSorter {

    public static ArrayList<Card> sortByValue(ArrayList<Card> cards) {
        Collections.sort(cards);
        return cards;
    }

}
