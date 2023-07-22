package cs.sun.za.ohviz;

import cs.sun.za.ohviz.layout.AppLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application{
    public static int sceneWidth = 1000;
    public static int sceneHeight = 640;
    @Override
    public void start(Stage stage) throws IOException {
        MenuBar menuBar = new MenuBar();
        VBox vBox = new VBox(menuBar);
        Scene scene = new Scene(vBox, sceneWidth, sceneHeight);
        stage.setTitle("OhViz");

        AppLayout appLayout = new AppLayout(menuBar, stage);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}