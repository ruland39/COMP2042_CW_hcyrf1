package com.game2048.controller;
/**
 * @author Ruland Muhammad Furqan-modified
 */
import com.game2048.view.*;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static com.game2048.Main.HEIGHT;
import static com.game2048.Main.WIDTH;

public class Controller implements Initializable {

    @FXML
    private Text text2048, nameLabelBox;
    @FXML
    public TextField nameBox;

    @FXML
    private Button playBtn, playBtn2, playBtn3, playBtn4, playBtn5;

    @FXML
    private ToggleButton toggleBtn;
    @FXML
    private AnchorPane backgroundColor;
    private Color gameSceneColor = Color.rgb(189, 177, 92);
    private Color endGameSceneColor = Color.rgb(189, 177, 92);

    private final String[] colorList = {"ALICEBLUE", "ANTIQUEWHITE", "AZURE", "BEIGE", "BISQUE", "BURLYWOOD", "BLANCHEDALMOND", "CADETBLUE", "CORAL", "CORNFLOWERBLUE", "CORNSILK", "DARKCYAN", "DARKKHAKI", "DARKSALMON", "DARKSEAGREEN", "DARKTURQUOISE", "FLORALWHITE", "GAINSBORO", "GHOSTWHITE", "GOLD", "GREENYELLOW", "HONEYDEW", "IVORY", "KHAKI", "LAVENDER", "LAVENDERBLUSH", "LEMONCHIFFON", "LIGHTBLUE", "LIGHTCORAL", "LIGHTCYAN", "LIGHTGOLDENRODYELLOW", "LIGHTGREEN", "LIGHTPINK", "LIGHTSALMON", "LIGHTSEAGREEN", "LIGHTSKYBLUE", "LIGHTSTEELBLUE", "LIGHTYELLOW", "LINEN", "MEDIUMSPRINGGREEN", "MINTCREAM", "MISTYROSE", "MOCCASIN", "NAVAJOWHITE", "OLDLACE", "PALEGREEN", "PALETURQUOISE", "PINK", "PLUM", "POWDERBLUE", "SNOW", "SPRINGGREEN", "THISTLE", "TOMATO", "TURQUOISE", "VIOLET", "WHEAT"};


    private Scene gameScene;
    private Group gameRoot;


    //  Open Normal Game Mode
    /**
     * This is the function to openGameScene that is being used by the button at the mainmenu fxml that will launch the gameScene to start the game.
     * @param actionEvent
     */
    public void openGameScene(ActionEvent actionEvent) {

        playBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            private Group root;


            @Override
            public void handle(MouseEvent mouseEvent) {


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

    /**
     * This is the function to openGameScene2 that is being used by the button at the mainmenu fxml that will launch the gameScene2 to start the game.
     * @param actionEvent
     */
    // open Game Scene 2 (Reversible Arrow) 2x2
    public void openGameScene2(ActionEvent actionEvent) {
        playBtn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene2;
            private Group gameRoot2;

            final Node node2 = (Node) actionEvent.getSource();
            final Stage primaryStage2 = (Stage) node2.getScene().getWindow();
            private Group root2;


            @Override
            public void handle(MouseEvent mouseEvent) {

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

    // open Game Scene 3 (Reversible Arrow) 3x3
    /**
     * This is the function to openGameScene that is being used by the button at the mainmenu fxml that will launch the gameScene3 to start the game.
     * @param actionEvent
     */
    public void openGameScene3(ActionEvent actionEvent) {
        playBtn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene3;
            private Group gameRoot3;

            final Node node3 = (Node) actionEvent.getSource();
            final Stage primaryStage3 = (Stage) node3.getScene().getWindow();
            private Group root3;


            @Override
            public void handle(MouseEvent mouseEvent) {

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
                setGameRoot3(gameRoot);
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, gameSceneColor);
                setGameScene3(gameScene);
                primaryStage3.setScene(gameScene);
                GameScene3 game = new GameScene3();
                game.game(gameScene, gameRoot, primaryStage3, endGameScene, endgameRoot);

                primaryStage3.show();
            }


            private void setGameScene3(Scene gameScene) {
                gameScene3 = this.gameScene3;
            }

            private void setGameRoot3(Group gameRoot) {
                gameRoot3 = this.gameRoot3;
            }

        });
    }

    // open Game Scene 4 (Reversible Arrow) 4x4
    /**
     * This is the function to openGameScene4 that is being used by the button at the mainmenu fxml that will launch the gameScene4 to start the game.
     * @param actionEvent
     */
    public void openGameScene4(ActionEvent actionEvent) {
        playBtn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene4;
            private Group gameRoot4;

            final Node node4 = (Node) actionEvent.getSource();
            final Stage primaryStage4 = (Stage) node4.getScene().getWindow();
            private Group root4;


            @Override
            public void handle(MouseEvent mouseEvent) {

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
                setGameRoot4(gameRoot);
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, gameSceneColor);
                setGameScene4(gameScene);
                primaryStage4.setScene(gameScene);
                GameScene4 game = new GameScene4();
                game.game(gameScene, gameRoot, primaryStage4, endGameScene, endgameRoot);

                primaryStage4.show();
            }


            private void setGameScene4(Scene gameScene) {
                gameScene4 = this.gameScene4;
            }

            private void setGameRoot4(Group gameRoot) {
                gameRoot4 = this.gameRoot4;
            }

        });
    }


    // open Game Scene 5 (Reversible Arrow) 5x5
    /**
     * This is the function to openGameScene5 that is being used by the button at the mainmenu fxml that will launch the gameScene5 to start the game.
     * @param actionEvent
     */
    public void openGameScene5(ActionEvent actionEvent) {
        playBtn5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene5;
            private Group gameRoot5;

            final Node node5 = (Node) actionEvent.getSource();
            final Stage primaryStage5 = (Stage) node5.getScene().getWindow();
            private Group root5;


            @Override
            public void handle(MouseEvent mouseEvent) {

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
                setGameRoot5(gameRoot);
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, gameSceneColor);
                setGameScene5(gameScene);
                primaryStage5.setScene(gameScene);
                GameScene5 game = new GameScene5();
                game.game(gameScene, gameRoot, primaryStage5, endGameScene, endgameRoot);

                primaryStage5.show();
            }


            private void setGameScene5(Scene gameScene) {
                gameScene5 = this.gameScene5;
            }

            private void setGameRoot5(Group gameRoot) {
                gameRoot5 = this.gameRoot5;
            }

        });
    }

    /**
     * This is the function for the toggle button at the main menu that will cycle an array list of pre-selected colors and is being picked by a generated number using random number generator.
     * @param actionEvent
     */
    @FXML
    // Color changing part for all scenes
    public void toggleMode(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();

        // Random Number Generator to decide the order on the array list
        int min = 0;
        int max = colorList.length - 1;
        int a = (int) (Math.random() * (max - min + 1) + min);

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

    /**
     * This is the function of initialize
     * @param url
     * @param resourceBundle
     */
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
