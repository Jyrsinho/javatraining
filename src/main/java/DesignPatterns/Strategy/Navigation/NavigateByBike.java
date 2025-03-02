package DesignPatterns.Strategy.Navigation;

public class NavigateByBike implements NavigationStrategy{


    @Override
    public void navigate(String locationA, String locationB) {
        System.out.println("Fastest route from "+locationA+" to "+locationB +" by bike is through the hills.");
    }
}
