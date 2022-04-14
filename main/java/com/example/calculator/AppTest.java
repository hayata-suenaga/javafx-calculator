package com.example.calculator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class AppTest {

    @Start
    private void start(Stage stage) throws IOException {
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


    @Test
    public void testButton(FxRobot robot) {
        enterValue("firstNum", "10", robot);
        enterValue("secondNum", "20", robot);
        robot.clickOn("#addButton");
        Assertions.assertThat(robot.lookup("#sum")
                .queryAs(Label.class)).hasText("30");
    }



    private void enterValue(String fieldId, String text, FxRobot robot) {
        robot.clickOn("#" + fieldId);
        robot.write(text);
    }
}