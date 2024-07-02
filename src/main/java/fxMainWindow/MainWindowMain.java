package fxMainWindow;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author jyrihuhtala
 * @version 1.7.2024
 */
public class MainWindowMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("MainWindowGUIView.fxml"));
            final Pane root = ldr.load();
            //final MainWindowGUIController mainwindowCtrl = (MainWindowGUIController)ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("mainwindow.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("MainWindow");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}