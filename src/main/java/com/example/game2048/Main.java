package com.example.game2048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class Main extends Application {
    //Additions
    // Slide speed animation
    public static final int SLIDE_SPEED = 20;

    static final int WIDTH = 900;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static final Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Group menuRoot = new Group();
//        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
//        Group accountRoot = new Group();
//        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
//        Group getAccountRoot = new Group();
//        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
//        Group endgameRoot = new Group();
//        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
//        Group rankRoot = new Group();
//        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
//        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
//        Background background = new Background(background_fill);
//
//
//        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
//        backgroundOfMenu.setX(WIDTH / 2 - 120);
//        backgroundOfMenu.setY(180);
//        menuRoot.getChildren().add(backgroundOfMenu);
//
//        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
//        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
//        backgroundOfMenuForPlay.setY(180);
//        accountRoot.getChildren().add(backgroundOfMenuForPlay);
//
//        Group gameRoot = new Group();
//        setGameRoot(gameRoot);
//        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
//        setGameScene(gameScene);
//        primaryStage.setScene(gameScene);
//        GameScene game = new GameScene();
//        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
//
//        primaryStage.show();
//    }

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
    public void music(){
        Media h = new Media(new File("src/main/resources/com/example/game2048/bgmusic.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
//                System.out.println("TestRepeat");
                mediaPlayer.seek(Duration.ZERO);
            }
        });

        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
