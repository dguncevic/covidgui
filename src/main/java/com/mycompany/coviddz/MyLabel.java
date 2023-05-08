package com.mycompany.coviddz;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyLabel extends Label {

    public MyLabel(String str, int x, int y) {

        this.setText(str);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setFont(Font.font(16));
        this.setTextFill(Color.WHITESMOKE);
    }
    
    

}
