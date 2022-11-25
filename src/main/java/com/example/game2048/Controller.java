package com.example.game2048;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
    private Button playBtn;

    @FXML
    private Text text2048;

    @FXML
    private ToggleButton toggleBtn;
    @FXML
    private AnchorPane backgroundColor;
    private Color gameSceneColor = Color.rgb(189, 177, 92);
    private Color endGameSceneColor = Color.rgb(189, 177, 92);

    private String[] colorList = {"ALICEBLUE", "ANTIQUEWHITE", "AZURE", "BEIGE", "BISQUE", "BURLYWOOD","BLANCHEDALMOND", "CADETBLUE", "CORAL", "CORNFLOWERBLUE", "CORNSILK", "DARKCYAN", "DARKKHAKI", "DARKSALMON", "DARKSEAGREEN", "DARKTURQUOISE", "FLORALWHITE", "GAINSBORO", "GHOSTWHITE", "GOLD", "GOLDENROD", "GREENYELLOW", "HONEYDEW", "INDIANRED", "IVORY", "KHAKI", "LAVENDER", "LAVENDERBLUSH", "LEMONCHIFFON", "LIGHTBLUE", "LIGHTCORAL", "LIGHTCYAN", "LIGHTGOLDENRODYELLOW", "LIGHTGREEN", "LIGHTPINK", "LIGHTSALMON", "LIGHTSEAGREEN", "LIGHTSKYBLUE", "LIGHTSTEELBLUE", "LIGHTYELLOW", "LINEN", "MEDIUMSPRINGGREEN", "MINTCREAM", "MISTYROSE", "MOCCASIN", "NAVAJOWHITE", "OLDLACE", "PALEGREEN", "PALETURQUOISE", "PINK", "PLUM", "POWDERBLUE", "SNOW", "SPRINGGREEN", "THISTLE", "TOMATO", "TURQUOISE", "VIOLET", "WHEAT"};
//    @FXML
//    private Node root;


    private Scene gameScene;
    private Group gameRoot;


    @FXML
    void insertName(InputMethodEvent event) {

    }


    public void openGameScene(ActionEvent actionEvent) {
        playBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            Node node = (Node) actionEvent.getSource();
            // Step 3
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

    @FXML
    public void toggleMode(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();

        // Step 3
        Stage primaryStage = (Stage) node.getScene().getWindow();

        int min = 0;
        int max = colorList.length-1;
        int a = (int) (Math.random()*(max-min+1)+min);

        System.out.println(colorList[a]);

        Scene scene = primaryStage.getScene();
        if (toggleBtn.isSelected()) {
            toggleBtn.setStyle("-fx-border-color: gray; -fx-border-width: 4; -fx-background-radius: 100; -fx-border-radius: 100; -fx-background-color: " + colorList[a]);
            backgroundColor.setStyle("-fx-background-color: " + colorList[a]);
            gameSceneColor = Color.valueOf(colorList[a]);
            endGameSceneColor = Color.valueOf(colorList[a]);
        } else {
            toggleBtn.setStyle("-fx-border-color: gray; -fx-border-width: 4; -fx-background-radius: 100; -fx-border-radius: 100; -fx-background-color: " + colorList[a]);
            backgroundColor.setStyle("-fx-background-color: " + colorList[a]);
            gameSceneColor = Color.valueOf(colorList[a]);
            endGameSceneColor = Color.valueOf(colorList[a]);
        }

    }
}
