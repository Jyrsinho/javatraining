package PokerGame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CardTest.class,
        DeckTest.class,
        HandTest.class,
        HandEvaluatorTest.class,
        PlayerTest.class,
        PokerGameTest.class

})



public class AllTests {
    // Tämä luokka pysyy tyhjänä. Se toimii vain merkintöjen kautta, jotka määrittävät ajettavat testiluokat.
}


