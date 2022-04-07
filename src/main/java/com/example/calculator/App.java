package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /* Fetch xml file for the view */
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("calculator-view.fxml"));
        /* Load the xml file and get the parent node */
        Parent parent = fxmlLoader.load();
        /* Get the loaded view's controller */
        CalculatorController controller = fxmlLoader.getController();
        /* Pass the model to the controller */
        controller.setModel(new CalculatorModel());

        Scene scene = new Scene(parent);
        stage.setTitle("Addition Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}