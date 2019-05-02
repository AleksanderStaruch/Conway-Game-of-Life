package zad2;

import javafx.scene.control.Button;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyButtonFx extends Button {

    boolean b;
    int w,h;
    Image yes;
    Image no;


    public MyButtonFx(int w, int h) {
        try{
            no=new Image(new FileInputStream("no.png"));
            yes=new Image(new FileInputStream("yes.png"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        this.b=false;
        this.w=w;
        this.h=h;
        this.setGraphic(new ImageView(no));
        this.setWidth(5);
        this.setWidth(5);
    }

    public void setIcon() {
        b=!b;
        if(!b){
            this.setGraphic(new ImageView(no));
        }else{
            this.setGraphic(new ImageView(yes));
        }

    }
}
