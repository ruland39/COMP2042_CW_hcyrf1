module com.example.demo {
    requires java.base;
    requires java.logging;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com.example.game2048 to javafx.fxml;
    exports com.example.game2048;
}