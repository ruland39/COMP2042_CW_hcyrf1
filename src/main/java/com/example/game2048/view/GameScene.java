package com.example.game2048.view;
/**
 * @author Ruland Muhammad Furqan-modified
 */

import com.example.game2048.model.Cell;
import com.example.game2048.utility.TextMaker;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class GameScene {
    private static int HEIGHT = 700;
    private static int n = 4;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[n][n];
    private Group root;
    private long score = 0;

    /**
     * This is the function of setting the value of N.
     * @param number
     */
    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    /**
     * This is the getter for the length.
     * @return
     */
    public static double getLENGTH() {
        return LENGTH;
    }

    /**
     * This is the function of spawning cells randomly with corresponding random numbers into it.
     * @param turn
     */
    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }



        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    /**
     * This is the function of checking whether it has an empty cell or not.
     * @return
     */
    private int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

    /**
     * This is the function where the cell will have its movement logic and move the cells around the containing cells.
     * @param i
     * @param j
     * @param direct
     * @return
     */
    private int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * This is the function of moving the cells to the left hand side.
     */
    private void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This is the function of moving the cells to the right hand side.
     */
    private void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This is the function of moving the cells up.
     */
    private void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This is the function of moving the cells down.
     */
    private void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This is the function to check if the destination path/movement of the cells is correct or wrong in the horizontal axis.
     * @param i
     * @param j
     * @param des
     * @param sign
     * @return
     */
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is the function to move the cells horizontally.
     * @param i
     * @param j
     * @param des
     * @param sign
     */
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);

            score += cells[i][des + sign].getNumber();

            cells[i][des + sign].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     * This is the function to check if the destination path/movement of the cells is correct or wrong in the vertical axis.
     * @param i
     * @param j
     * @param des
     * @param sign
     * @return
     */
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    /**
     * This is the function to move the cells vertically.
     * @param i
     * @param j
     * @param des
     * @param sign
     */
    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);

            score += cells[des + sign][j].getNumber();

            cells[des + sign][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

    /**
     * This is the function to check if the cells nearby have the same number or not.
     * @param i
     * @param j
     * @return
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     * This is the function to check if the cells can move or not.
     * @return
     */
    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This is the function to sum the cell number to the score text.
     */
    private void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }

    /**
     * This is the function to set up the GameScene to be able for the game to be played. The Stage and Scene will also be initialized here. This also includes the cells' container/grid for the cells to be placed, the score text as well as the numbers inside the cell and the corresponding color of it.
     * @param gameScene
     * @param root
     * @param primaryStage
     * @param endGameScene
     * @param endGameRoot
     */
    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        //Font for Text
        Font font = Font.font("Comic Sans MS", FontWeight.NORMAL, 40);


        // Rectangle Container for Score
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(150);
        rectangle.prefWidth(150);
        rectangle.setHeight(120);
        rectangle.prefHeight(120);
        rectangle.setArcWidth(24);
        rectangle.setArcHeight(24);
        rectangle.setFill(Color.rgb(224, 226, 226, 0.7));
        rectangle.relocate(720, 100);
        root.getChildren().add(rectangle);


        // Score Text Title
        Text scoreTextTitle = new Text();
        root.getChildren().add(scoreTextTitle);
        scoreTextTitle.setText("Score");
        scoreTextTitle.setFont(font);
        scoreTextTitle.setFill(Color.WHITE);
//        scoreTextTitle.setStrokeWidth(1);
//        scoreTextTitle.setStroke(Color.BLACK);
        scoreTextTitle.relocate(730, 100);

        // Score Text
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(760, 180);
        scoreText.setFont(font);
        scoreText.setFill(Color.WHITE);
        scoreText.setText("0");


        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    int haveEmptyCell;
                    //key inputs
                    boolean b = false;
                    if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.RIGHT
                     || key.getCode() == KeyCode.S || key.getCode() == KeyCode.W || key.getCode() == KeyCode.A || key.getCode() == KeyCode.D
                    )
                    {
                        b = true;
                    }
                    else {
                        b = false;
                    }


                    if(b == true) {

                        if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.S) {
                            GameScene.this.moveDown();
                        } else if (key.getCode() == KeyCode.UP || key.getCode() == KeyCode.W) {
                            GameScene.this.moveUp();
                        } else if (key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.A) {
                            GameScene.this.moveLeft();
                        } else if (key.getCode() == KeyCode.RIGHT || key.getCode() == KeyCode.D) {
                            GameScene.this.moveRight();
                        }
                    }

                    scoreText.setText(score + "");
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    } else if(haveEmptyCell == 1 && b)
                        GameScene.this.randomFillNumber(2);
                });
            });

    }
}
