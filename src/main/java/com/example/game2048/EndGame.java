package com.example.game2048;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
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

import java.io.IOException;
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

        //Name Text
        Text text = new Text("Game Over!");
        text.relocate(240,75);
        text.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM,80));
        text.setFill(Color.BLACK);
        root.getChildren().add(text);

        //Score Text Title
        Text scoretexttitle = new Text("Score");
        scoretexttitle.relocate(365,150);
        scoretexttitle.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT,60));
        scoretexttitle.setFill(Color.BLACK);
        root.getChildren().add(scoretexttitle);


        //Score Text
        Text scoreText = new Text(score+"");
        scoreText.relocate(375,240);
        scoreText.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM,80));
        scoreText.setFill(Color.BLACK);
        root.getChildren().add(scoreText);

        //HighScore Text Title
        Text highscoretexttitle = new Text("High Score");
        highscoretexttitle.relocate(300,320);
        highscoretexttitle.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT,60));
        highscoretexttitle.setFill(Color.BLACK);
        root.getChildren().add(highscoretexttitle);

        // Highscore Text






        // Texfield Input username LABEL
        Text usernameLabel = new Text("Insert Name");
        usernameLabel.relocate(380,460);
        usernameLabel.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 24));
        root.getChildren().add(usernameLabel);



        // TextField Input username
        TextField username = new TextField();
        username.relocate(330,480);
        username.setPromptText("Suq Madeeq");
        username.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");
        username.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 18));
        root.getChildren().add(username);











        //Font for Button
        Font font = Font.font("Comic Sans MS", FontWeight.NORMAL, 20);

        //Retry/Play Again Button
        Button retryButton = new Button("Retry");
        retryButton.setPrefSize(120,50);
        retryButton.setTextFill(Color.BLACK);
        retryButton.setFont(font);
        root.getChildren().add(retryButton);
        retryButton.relocate(400,530);
        retryButton.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");

        retryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                primaryStage.close();


                WriteToFile.writeToFile("test.txt", "test;0");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setController(new Controller());
                Parent root = null;
                try {
                    root = fxmlLoader.load(Main.class.getResource("main-menu.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(root, 700,700);
                Stage stage = new Stage();
                stage.setTitle("2048 Game");
                stage.setScene(scene);
                stage.show();
                
            }

            private void setGameScene(Scene gameScene) {
                this.gameScene = gameScene;
            }

            private void setGameRoot(Group gameRoot) {
                this.gameRoot = gameRoot;
            }
        });


        //Rank Button
        Button rankButton = new Button("Rank");
        rankButton.setPrefSize(120,50);
        rankButton.setTextFill(Color.BLACK);
        rankButton.setFont(font);
        root.getChildren().add(rankButton);
        rankButton.relocate(400,585);
        rankButton.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");


        //Quit Button
        Button quitButton = new Button("Quit");
        quitButton.setPrefSize(120,50);
        quitButton.setTextFill(Color.BLACK);
        quitButton.setFont(font);
        root.getChildren().add(quitButton);
        quitButton.relocate(400,640);
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
