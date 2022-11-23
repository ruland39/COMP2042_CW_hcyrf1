package com.example.game2048;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

import static com.example.game2048.Main.HEIGHT;
import static com.example.game2048.Main.WIDTH;


public class EndGame {
    private static EndGame singleInstance = null;
    private EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score){

        //Game Over Text
        Text text = new Text("GAME OVER");
        text.relocate(220,150);
        text.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM,80));
        text.setFill(Color.BLACK);
        root.getChildren().add(text);

        //Score Text Title
        Text scoretexttitle = new Text("Score");
        scoretexttitle.relocate(365,250);
        scoretexttitle.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT,60));
        scoretexttitle.setFill(Color.BLACK);
        root.getChildren().add(scoretexttitle);


        //Score Text
        Text scoreText = new Text(score+"");
        scoreText.relocate(375,340);
        scoreText.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM,80));
        scoreText.setFill(Color.BLACK);
        root.getChildren().add(scoreText);

        //HighScore Text Title
        Text highscoretexttitle = new Text("High Score");
        highscoretexttitle.relocate(300,450);
        highscoretexttitle.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT,60));
        highscoretexttitle.setFill(Color.BLACK);
        root.getChildren().add(highscoretexttitle);



        //Font for Button
        Font font = Font.font("Comic Sans MS", FontWeight.NORMAL, 20);

        //Retry/Play Again Button
        Button retryButton = new Button("Retry");
        retryButton.setPrefSize(120,50);
        retryButton.setTextFill(Color.BLACK);
        retryButton.setFont(font);
        root.getChildren().add(retryButton);
        retryButton.relocate(400,700);
        retryButton.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");

        retryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();

                Group menuRoot = new Group();
                Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
                Group accountRoot = new Group();
                Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
                Group getAccountRoot = new Group();
                Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
                Group endgameRoot = new Group();
                Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
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
                Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
                setGameScene(gameScene);
                primaryStage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

                primaryStage.show();
                
                
            }

            private void setGameScene(Scene gameScene) {
                this.gameScene = gameScene;
            }

            private void setGameRoot(Group gameRoot) {
                this.gameRoot = gameRoot;
            }
        });





        //Quit Button
        Button quitButton = new Button("Quit");
        quitButton.setPrefSize(120,50);
        quitButton.setTextFill(Color.BLACK);
        quitButton.setFont(font);
        root.getChildren().add(quitButton);
        quitButton.relocate(400,755);
        quitButton.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    primaryStage.close();
                }
            }
        });



    }
}
