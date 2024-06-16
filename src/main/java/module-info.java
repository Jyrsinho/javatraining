module org.example.javaharjoituksia {
    exports PokerGame;
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens org.example.javaharjoituksia to javafx.fxml;
}