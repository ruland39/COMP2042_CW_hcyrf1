package com.example.game2048;

/**
 * @author Ruland Muhammad Furqan-modified
 */

import com.example.game2048.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main extends Application {
    //Additions
    // Slide speed animation
    public static final int SLIDE_SPEED = 20;

    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static final Scanner input= new Scanner(System.in);

    /**
     * Setter for GameScene
     * @param gameScene
     */
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     * Setter for GameRoot
     * @param gameRoot
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    /**
     * This is the function to start the game. This will call the music method to play the background music as well as setting the stage that contains the scene of gamescene.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(new Controller());
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("main-menu.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        music();
        Scene scene = new Scene(root, 700,700);
        stage.setTitle("2048 Game");
        stage.setScene(scene);
        stage.show();

    }
    // Music Function
    MediaPlayer mediaPlayer;

    /**
     * This function is to play background music throughout when the program is run.
     */
    public void music(){
        Media h = new Media(new File("src/main/resources/com/example/game2048/bgmusic.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });

        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
