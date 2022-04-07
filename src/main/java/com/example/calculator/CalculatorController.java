package com.example.calculator;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class CalculatorController {

    @FXML
    public TextField firstNumber;
    @FXML
    public TextField secondNumber;
    @FXML
    public Label sum;

    CalculatorModel model;

    public void setModel(CalculatorModel model) {
        this.model = model;
        StringConverter<Number> c = new NumberStringConverter();
        Bindings.bindBidirectional(sum.textProperty(), model.sum, c);
    }

    @FXML
    void onAddButtonClick(ActionEvent event) {
        int firstNum = Integer.parseInt(firstNumber.getText());
        int secondNum = Integer.parseInt(secondNumber.getText());
        model.addTwoNums(firstNum, secondNum);
    }
}