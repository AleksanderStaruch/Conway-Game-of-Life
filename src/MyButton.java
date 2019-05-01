import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(Icon icon) {
        super(icon);
        this.setPreferredSize(new Dimension(30,30));
    }


    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
    }
}
