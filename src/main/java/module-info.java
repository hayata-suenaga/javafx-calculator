module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
}