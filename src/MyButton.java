import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    boolean b;
    int w,h;
    Icon no=new ImageIcon("no.png");
    Icon yes=new ImageIcon("yes.png");

    public MyButton(int w,int h) {
        this.b=false;

        this.setIcon(no);
        this.setPreferredSize(new Dimension(30,30));
    }

    public void setIcon() {
        if(!b){
            this.setIcon(no);
            b=true;
        }else{
            this.setIcon(yes);
            b=false;
        }
    }
}
