package AlgorithmsTwo.DataStructures.Heap;


/**
 * Tämä on minHeap. Pienin arvo nousee aina pinon huipulle
 *
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

        int[] priorityQueue;
        int size;

    public MyPriorityQueue(int capacity) {
        this.priorityQueue = new int[capacity];
        this.size = 0;

    }

    public void push(int value) {
        //lisataan heapin loppuun
        priorityQueue[size] = value;
        size++;
        bubbleToTop();

        if (size == capacity()) {
            growArray();
        }

    }


    /**
     *
     */
    private void bubbleToTop () {
        int parent = (size -1)  / 2;
        int lapsi = size -1;

        if (priorityQueue[lapsi] < priorityQueue[parent]) {
            swap(priorityQueue[lapsi], priorityQueue[parent]);
        }
    }

    private void swap(int i, int j) {
        int temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    public int pop() {

        size--;
        return priorityQueue[0];
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

    private boolean onParillinenIndeksi(int indeksi) {
        return indeksi % 2 == 0;
    }

   public int top() {
        return priorityQueue[0];
    }

   public int capacity() {
        return priorityQueue.length;
    }

   public int size() {
        return size;
    }

   public void tulosta(){
        for (int i = 0; i < priorityQueue.length; i++) {
            System.out.println(priorityQueue[i]);
        }
    }

    private void growArray() {
        int newCapacity =  this.capacity() * 2;
        MyPriorityQueue newPQ = new MyPriorityQueue(newCapacity);
        System.arraycopy(this.priorityQueue, 0, newPQ.priorityQueue, 0, priorityQueue.length);
        this.priorityQueue = newPQ.priorityQueue;
    }


   public static void main(String[] args) {
        MyPriorityQueue mpq = new MyPriorityQueue(5);
        mpq.tulosta();
    }
}
