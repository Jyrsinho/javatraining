package DesignPatterns.Strategy.Navigation;

public class Navigation {
    String from;
    String to;
    NavigationStrategy navigationStrategy;

    public Navigation(String from, String to, NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
        this.from = from;
        this.to = to;
    }

    public void navigate() {
        navigationStrategy.navigate(from, to);
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

}
