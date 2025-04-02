package AlgorithmsTwo.DataStructures.Heap;


/**
 * 1. push()
 *     Tarkoitus: Lisää uuden alkion prioriteettijonoon.
 *     Käyttö: pq.push(value);
 *     Tämä operaatio lisää arvon value prioriteettijonon oikealle paikalle säilyttääkseen jonon järjestyksen.
 * 2. pop()
 *     Tarkoitus: Poistaa ja palauttaa jonon kärki (eli suurimman tai pienimmän elementin, riippuen siitä, onko käytössä maksimi- vai minimikasasta).
 *     Käyttö: pq.pop();
 *     Tämä operaatio poistaa kärki-elementin ja järjestää jäljelle jääneet elementit uudelleen. Huomaa, että pop() ei palauta poistettua arvoa, mutta se muokkaa sisäistä rakennetta.
 * 3. top()
 *     Tarkoitus: Palauttaa jonon kärjen (suurimman tai pienimmän elementin).
 *     Käyttö: pq.top();
 *     Tämä operaatio ei poista elementtiä, vaan palauttaa sen arvon. Se ei muuta jonoa.
 * 4. empty()
 *     Tarkoitus: Tarkistaa, onko prioriteettijono tyhjä.
 *     Käyttö: pq.empty();
 *     Palauttaa true, jos jono on tyhjä, ja false, jos siinä on elementtejä.
 * 5. size()
 *     Tarkoitus: Palauttaa jonossa olevien alkioiden lukumäärän.
 *     Käyttö: pq.size();
 *     Palauttaa kokonaismäärän alkioista, jotka ovat jonossa.
 */
public class MyPriorityQueue {
        int INTIAL_CAPACITY = 11;
        int[] priorityQueue;

    public MyPriorityQueue() {
        this.priorityQueue = new int[INTIAL_CAPACITY];

    }


    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < priorityQueue.length; i++) {
            if (priorityQueue[i] != 0) {
                return false;
            }
        }
        return isEmpty;
    }


    public void tulosta(){
        for (int i = 0; i < priorityQueue.length; i++) {
            System.out.println(priorityQueue[i]);
        }
    }

    public static void main(String[] args) {
        MyPriorityQueue mpq = new MyPriorityQueue();
        mpq.tulosta();
    }
}
