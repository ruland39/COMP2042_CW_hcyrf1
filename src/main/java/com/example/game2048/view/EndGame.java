package com.example.game2048.view;

import com.example.game2048.Main;
import com.example.game2048.controller.Controller;
import com.example.game2048.model.HighScore;
import com.example.game2048.utility.WriteToFile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


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
        scoreText.relocate(375, 230);
        scoreText.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM,80));
        scoreText.setFill(Color.BLACK);
        root.getChildren().add(scoreText);


        // Texfield Input username LABEL
        Text usernameLabel = new Text("Insert Name");
        usernameLabel.relocate(380,500);
        usernameLabel.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 24));
        root.getChildren().add(usernameLabel);

        // TextField Input username
        TextField username = new TextField();
        username.relocate(300,520);
        username.setPromptText("Username");
        username.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");
        username.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 18));
        username.setAlignment(Pos.CENTER);
        root.getChildren().add(username);

        //Font for Button
        Font font = Font.font("Comic Sans MS", FontWeight.NORMAL, 20);

        //Save username Button
        Button saveButton = new Button("Save");
        saveButton.setTextFill(Color.BLACK);
        saveButton.setFont(font);
        saveButton.relocate(555,517);
        saveButton.setMaxWidth(80.0);
        saveButton.setMaxHeight(10.0);
        saveButton.setStyle("-fx-background-radius: 100; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 100;");

        root.getChildren().add(saveButton);

        saveButton.setOnMouseClicked(mouseEvent -> {
            if(username.getText().toString().length() == 0){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Please Enter Your Name!");
                alert.show();
            }
            else{
                String message = username.getText().toString() + ";" + score + "\n";

                WriteToFile.writeToFile("rank.txt", message);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Name and Highscore have been successfully saved!");
                alert.show();
            }
        });

        //Retry/Play Again Button
        Button retryButton = new Button("Retry");
        retryButton.setPrefSize(120,50);
        retryButton.setTextFill(Color.BLACK);
        retryButton.setFont(font);
        root.getChildren().add(retryButton);
        retryButton.relocate(400,585);
        retryButton.setStyle("-fx-background-radius: 20; -fx-border-width: 3; -fx-border-color: gray; -fx-border-radius: 20;");

        retryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private Scene gameScene;
            private Group gameRoot;

            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                primaryStage.close();


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


        TableView tableView = new TableView<>();
        tableView.setMaxWidth(500);
        tableView.setMaxHeight(200);
        tableView.relocate(320,275);
        tableView.setStyle("-fx-background-color: rgba(224, 226, 226, 0.5); -fx-background-radius: 20; -fx-border-width: 10; -fx-border-color: rgba(224, 226, 226, 0.5); -fx-border-radius: 10; -fx-border-insets: 10");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn tableColumn = new TableColumn("Username");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn tableColumn1 = new TableColumn("Highscore");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("highScore"));

        tableView.getColumns().addAll(tableColumn, tableColumn1);

        try {
            List<HighScore> highScoreList = WriteToFile.getAllScore("rank.txt");
            highScoreList.sort(Comparator.comparing(HighScore::getHighScore, Comparator.reverseOrder()));
            tableView.getItems().addAll(highScoreList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        //Quit Button
        Button quitButton = new Button("Quit");
        quitButton.setPrefSize(120,50);
        quitButton.setTextFill(Color.BLACK);
        quitButton.setFont(font);
        root.getChildren().addAll(quitButton, tableView);
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
