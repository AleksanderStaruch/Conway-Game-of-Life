package zad1;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    boolean b;
    int w,h;
    Icon no=new ImageIcon("no.png");
    Icon yes=new ImageIcon("yes.png");

    public MyButton(int w,int h) {
        this.b=false;
        this.w=w;
        this.h=h;
        this.setIcon(no);
        this.setPreferredSize(new Dimension(30,30));
    }

    public void setIcon() {
        b=!b;
        if(!b){
            this.setIcon(no);
        }else{
            this.setIcon(yes);
        }

    }
}
