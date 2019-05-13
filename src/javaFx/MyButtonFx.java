package javaFx;

import javafx.scene.control.Button;

public class MyButtonFx extends Button {


    boolean b;


    public MyButtonFx() {
        this.b=false;
        this.setMaxWidth(5);
        this.setMaxWidth(5);
        this.setStyle("-fx-border-color: #fdff00; -fx-border-width: 2px;-fx-background-color: rgba(255,255,255,0.87)");
    }

    public void setIcon() {
        b=!b;
        if(!b){
            this.setStyle("-fx-border-color: #fdff00; -fx-border-width: 2px;-fx-background-color: #fbf0ff");
        }else{
            this.setStyle("-fx-border-color: #fdff00; -fx-border-width: 2px;-fx-background-color: rgba(0,0,0,0.96)");
        }

    }
}

