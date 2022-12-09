module com.game2048 {
    requires java.base;
    requires java.logging;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;

    opens com.game2048 to javafx.fxml;
    exports com.game2048;
    exports com.game2048.controller;
    opens com.game2048.controller to javafx.fxml;
    exports com.game2048.utility;
    opens com.game2048.utility to javafx.fxml;
    exports com.game2048.model;
    opens com.game2048.model to javafx.fxml;
    exports com.game2048.view;
    opens com.game2048.view to javafx.fxml;
}