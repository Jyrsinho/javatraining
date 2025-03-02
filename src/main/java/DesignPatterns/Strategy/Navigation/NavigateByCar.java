package DesignPatterns.Strategy.Navigation;

public class NavigateByCar implements NavigationStrategy {
    @Override

    public void navigate(String locationA, String locationB) {
        System.out.println("Fastest route from " + locationA + " to " + locationB + " by car is through the mountains.");

    }
}
