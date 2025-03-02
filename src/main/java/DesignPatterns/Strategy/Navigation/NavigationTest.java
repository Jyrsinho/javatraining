package DesignPatterns.Strategy.Navigation;

public class NavigationTest {

    public static void main(String[] args) {
        String from = "Helsinki";
        String to = "Turku";
        NavigateByBike navByBike = new NavigateByBike();

        Navigation navigation = new Navigation(from, to, navByBike);
        navigation.navigate();

        NavigateByCar navByCar = new NavigateByCar();
        navigation.setNavigationStrategy(navByCar);
        navigation.navigate();
    }
}
