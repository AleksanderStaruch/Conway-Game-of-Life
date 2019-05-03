package zad2;

import javafx.scene.control.Button;

public class MyButtonFx extends Button {


    boolean b;
    int w,h;


    public MyButtonFx(int w, int h) {
        this.b=false;
        this.w=w;
        this.h=h;
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

