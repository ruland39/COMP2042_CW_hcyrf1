package com.game2048.model;
/**
 * @author Ruland Muhammad Furqan-modified
 */

import com.game2048.utility.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cell {
    private final Rectangle rectangle;
    private final Group root;
    private Text textClass;
    private boolean modify = false;

    /**
     * This is the setter for the modify
     * @param modify
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * This is the getter for the modify
     * @return
     */
    public boolean getModify() {
        return !modify;
    }

    /**
     * This is the function for making the cell into the gameScene. It is making the cell using a rectangle.
     * @param x
     * @param y
     * @param scale
     * @param root
     */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        rectangle.setArcHeight(12);
        rectangle.setArcWidth(12);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.2));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * This is the setter for the TextClass
     * @param textClass
     */
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * This is the function for changing the cell and its number.
     * @param cell
     */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * This is the function for adding the cells with same value.
     * @param cell
     */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }
    //refactor using enhance switch statement

    /**
     * This is the function to change the colour of the cell by setting the fill of the rectangle with a different colour that corresponds to the number/value inside the cell.
     * @param number
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0 -> rectangle.setFill(Color.rgb(224, 226, 226, 0.3));
            case 2 -> rectangle.setFill(Color.rgb(232, 255, 100, 0.3));
            case 4 -> rectangle.setFill(Color.rgb(232, 220, 50, 0.3));
            case 8 -> rectangle.setFill(Color.rgb(232, 200, 44, 0.6));
            case 16 -> rectangle.setFill(Color.rgb(232, 170, 44, 0.6));
            case 32 -> rectangle.setFill(Color.rgb(180, 120, 44, 0.5));
            case 64 -> rectangle.setFill(Color.rgb(180, 100, 44, 0.5));
            case 128 -> rectangle.setFill(Color.rgb(180, 80, 44, 0.5));
            case 256 -> rectangle.setFill(Color.rgb(180, 60, 44, 0.6));
            case 512 -> rectangle.setFill(Color.rgb(180, 30, 44, 0.6));
            case 1024 -> rectangle.setFill(Color.rgb(250, 0, 44, 0.6));
            case 2048 -> rectangle.setFill(Color.rgb(250, 0, 0, 0.8));
        }

    }

    /**
     * This is the getter for X.
     * @return
     */
    public double getX() {
        return rectangle.getX();
    }

    /**
     * This is the getter for Y.
     * @return
     */
    public double getY() {
        return rectangle.getY();
    }

    /**
     * This is the getter for the number.
     * @return
     */
    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     * This is the getter for the TextClass.
     * @return
     */
    private Text getTextClass() {
        return textClass;
    }

}
