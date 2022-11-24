package com.example.game2048;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.game2048.Main.HEIGHT;
import static com.example.game2048.Main.WIDTH;

public class Controller {

        @FXML
        private TextField nameBox;

        @FXML
        private Text nameLabelBox;

        @FXML
        private Text nameLabelBox1;

        @FXML
        private Button playBtn;

        @FXML
        private ToggleButton toggleBtn;
        private Scene gameScene;
        private Group gameRoot;


        @FXML
        void insertName(InputMethodEvent event) {

        }

        @FXML
        void openGameScene(ActionEvent event) {
                playBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {



                        }
                });





        }

        private void setGameScene(Scene gameScene) {
                gameScene = this.gameScene;
        }

        private void setGameRoot(Group gameRoot) {
                gameRoot = this.gameRoot;
        }


        @FXML
        void toggleLightDarkMode(ActionEvent event) {

        }

}
