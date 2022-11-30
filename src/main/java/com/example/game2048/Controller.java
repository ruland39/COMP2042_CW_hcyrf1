package com.example.game2048;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.game2048.Main.HEIGHT;
import static com.example.game2048.Main.WIDTH;

public class Controller implements Initializable {

    @FXML
    private Text text2048 , nameLabelBox;
    @FXML
    private TextField nameBox;

    @FXML
    private Button playBtn, playBtn2;

    @FXML
    private ToggleButton toggleBtn;
    @FXML
    private AnchorPane backgroundColor;
    private Color gameSceneColor = Color.rgb(189, 177, 92);
    private Color endGameSceneColor = Color.rgb(189, 177, 92);

    private final String[] colorList = {"ALICEBLUE", "ANTIQUEWHITE", "AZURE", "BEIGE", "BISQUE", "BURLYWOOD","BLANCHEDALMOND", "CADETBLUE", "CORAL", "CORNFLOWERBLUE", "CORNSILK", "DARKCYAN", "DARKKHAKI", "DARKSALMON", "DARKSEAGREEN", "DARKTURQUOISE", "FLORALWHITE", "GAINSBORO", "GHOSTWHITE", "GOLD", "GOLDENROD", "GREENYELLOW", "HONEYDEW", "INDIANRED", "IVORY", "KHAKI", "LAVENDER", "LAVENDERBLUSH", "LEMONCHIFFON", "LIGHTBLUE", "LIGHTCORAL", "LIGHTCYAN", "LIGHTGOLDENRODYELLOW", "LIGHTGREEN", "LIGHTPINK", "LIGHTSALMON", "LIGHTSEAGREEN", "LIGHTSKYBLUE", "LIGHTSTEELBLUE", "LIGHTYELLOW", "LINEN", "MEDIUMSPRINGGREEN", "MINTCREAM", "MISTYROSE", "MOCCASIN", "NAVAJOWHITE", "OLDLACE", "PALEGREEN", "PALETURQUOISE", "PINK", "PLUM", "POWDERBLUE", "SNOW", "SPRINGGREEN", "THISTLE", "TOMATO", "TURQUOISE", "VIOLET", "WHEAT"};

    private Scene gameScene;
    private Group gameRoot;


    @FXML
    void insertName(InputMethodEvent event) {

    }


    //  Open Normal Game Mode
    public void openGameScene(ActionEvent actionEvent) {
        playBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            private Group root;


            @Override
            public void handle(MouseEvent mouseEvent) {

                nameBox.getText();
                System.out.println(nameBox.getText());

                Group menuRoot = new Group();
                Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
                Group accountRoot = new Group();
                Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
                Group getAccountRoot = new Group();
                Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
                Group endgameRoot = new Group();
                Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, endGameSceneColor);
                Group rankRoot = new Group();
                Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
                BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);


                Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
                backgroundOfMenu.setX(WIDTH / 2 - 120);
                backgroundOfMenu.setY(180);
                menuRoot.getChildren().add(backgroundOfMenu);

                Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
                backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
                backgroundOfMenuForPlay.setY(180);
                accountRoot.getChildren().add(backgroundOfMenuForPlay);



                Group gameRoot = new Group();
                setGameRoot(gameRoot);
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, gameSceneColor);
                setGameScene(gameScene);
                primaryStage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

                primaryStage.show();
            }

            private void setGameScene(Scene gameScene) {
                gameScene = this.gameScene;
            }

            private void setGameRoot(Group gameRoot) {
                gameRoot = this.gameRoot;
            }

        });
    }

    // open Game Scene 2 (Interesting Level) 5x5
    public void openGameScene2(ActionEvent actionEvent) {
        playBtn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene2;
            private Group gameRoot2;

            final Node node2 = (Node) actionEvent.getSource();
            final Stage primaryStage2 = (Stage) node2.getScene().getWindow();
            private Group root2;


            @Override
            public void handle(MouseEvent mouseEvent) {

                nameBox.getText();
                System.out.println(nameBox.getText());

                Group menuRoot = new Group();
                Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
                Group accountRoot = new Group();
                Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
                Group getAccountRoot = new Group();
                Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
                Group endgameRoot = new Group();
                Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, endGameSceneColor);
                Group rankRoot = new Group();
                Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
                BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);


                Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
                backgroundOfMenu.setX(WIDTH / 2 - 120);
                backgroundOfMenu.setY(180);
                menuRoot.getChildren().add(backgroundOfMenu);

                Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
                backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
                backgroundOfMenuForPlay.setY(180);
                accountRoot.getChildren().add(backgroundOfMenuForPlay);



                Group gameRoot = new Group();
                setGameRoot2(gameRoot);
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, gameSceneColor);
                setGameScene2(gameScene);
                primaryStage2.setScene(gameScene);
                GameScene2 game = new GameScene2();
                game.game(gameScene, gameRoot, primaryStage2, endGameScene, endgameRoot);

                primaryStage2.show();
            }




            private void setGameScene2(Scene gameScene) {
                gameScene2 = this.gameScene2;
            }

            private void setGameRoot2(Group gameRoot) {
                gameRoot2 = this.gameRoot2;
            }

        });
    }

    @FXML
        // Color changing part
    public void toggleMode(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();

        // Random Number Generator to decide the order on the array list
        int min = 0;
        int max = colorList.length-1;
        int a = (int) (Math.random()*(max-min+1)+min);

        System.out.println(colorList[a]);

        Scene scene = primaryStage.getScene();
        //  Default Colors
        if (toggleBtn.isSelected()) {
            toggleBtn.setStyle("-fx-border-color: gray; -fx-border-width: 4; -fx-background-radius: 100; -fx-border-radius: 100; -fx-background-color: " + colorList[a]);
            backgroundColor.setStyle("-fx-background-color: " + colorList[a]);
            gameSceneColor = Color.valueOf(colorList[a]);
            endGameSceneColor = Color.valueOf(colorList[a]);
        }
        // Set Colors for background in main menu, game scene, and end game
        else {
            toggleBtn.setStyle("-fx-border-color: gray; -fx-border-width: 4; -fx-background-radius: 100; -fx-border-radius: 100; -fx-background-color: " + colorList[a]);
            backgroundColor.setStyle("-fx-background-color: " + colorList[a]);
            gameSceneColor = Color.valueOf(colorList[a]);
            endGameSceneColor = Color.valueOf(colorList[a]);
        }

    }

    // Animation for 2048 Text
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(text2048);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(1.0);
        scale.setByY(1.0);
        scale.setAutoReverse(true);
        scale.play();

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(text2048);
        rotate.setDuration(Duration.millis(1500));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setFromAngle(-5.0);
        rotate.setToAngle(5.0);
        rotate.setInterpolator(Interpolator.EASE_BOTH);
        rotate.setAutoReverse(true);
        rotate.play();

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(text2048);
        translate.setDuration(Duration.millis(2000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setInterpolator(Interpolator.EASE_BOTH);
        translate.setAutoReverse(true);
        translate.setFromX(-250);
        translate.setToX(250);
        translate.play();

    }
}
