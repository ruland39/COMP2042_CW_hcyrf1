package com.example.game2048.utility;

import com.example.game2048.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    public Text madeText(String input, double xCell, double yCell, Group root) {

        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;

        Font font = Font.font("Comic Sans MS", FontWeight.NORMAL, fontSize);

        Text text = new Text(input);
        text.setFont(font);
        text.relocate((xCell + (1.2)* length / 10.0), (yCell + 2 * length / 5.0));
        text.setFill(Color.WHITE);

        return text;
    }

    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
