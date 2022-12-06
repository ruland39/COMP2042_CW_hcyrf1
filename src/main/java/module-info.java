module com.example.demo {
    requires java.base;
    requires java.logging;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.game2048 to javafx.fxml;
    exports com.example.game2048;
    exports com.example.game2048.controller;
    opens com.example.game2048.controller to javafx.fxml;
    exports com.example.game2048.utility;
    opens com.example.game2048.utility to javafx.fxml;
    exports com.example.game2048.model;
    opens com.example.game2048.model to javafx.fxml;
}