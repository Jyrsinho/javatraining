package DesignPatterns.StateMachine;

public class Clock {
    int state;
    int hours;
    int minutes;

    public Clock() {
        int state = 0;
        int hours = 0;
        int minutes = 0;
    }

    public void set() {
        if (state < 2) state++;
        else state = 0;

    }

    public void increment() {
        if (state == 0) hours++;
        if (state == 1) minutes++;
    }

    public String getTimeString() {
        return String.format("Time: %02d:%02d", hours, minutes);

    }

}
class ClockState {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.increment();
        clock.increment();
        clock.set();
        clock.increment();
        clock.increment();
        clock.increment();
        clock.set();

        if ( clock.getTimeString().equals("Time: 02:03")) {
            System.out.println("pass");
            System.out.printf(clock.getTimeString());
        } else {
            System.out.println("fail");
            System.out.printf(clock.getTimeString());
        }
    }
}


