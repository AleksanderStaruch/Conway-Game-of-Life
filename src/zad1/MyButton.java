package zad1;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    boolean b;
    int w,h;

    public MyButton(int w,int h) {
        this.b=false;
        this.w=w;
        this.h=h;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(30,30));
    }

    public void setIcon() {
        b=!b;
        if(!b){
            this.setBackground(Color.WHITE);
        }else{
            this.setBackground(Color.BLACK);
        }

    }
}
