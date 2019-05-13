package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyButton extends JButton {

    boolean b;

    public MyButton() {
        this.b=false;
        Border bored = BorderFactory.createLineBorder(Color.RED);
        this.setBorder(bored);
        this.setBackground(Color.WHITE);
    }

    public void setIcon() {
        b=!b;
        if(b){
            this.setBackground(Color.BLACK);
        }else{
            this.setBackground(Color.WHITE);
        }
    }

}
