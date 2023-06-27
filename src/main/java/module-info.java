module app.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;


    opens app.studentmanagement to javafx.fxml;
    opens app.studentmanagement.model to javafx.base;
    exports app.studentmanagement;
    exports app.studentmanagement.controller;
    opens app.studentmanagement.controller to javafx.fxml;
}