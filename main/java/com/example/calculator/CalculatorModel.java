package com.example.calculator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CalculatorModel {
    IntegerProperty sum = new SimpleIntegerProperty();
    public void addTwoNums(int num1, int num2) { sum.setValue(num1 + num2); }
}
