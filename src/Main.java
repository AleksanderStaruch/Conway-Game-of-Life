import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        setSize(900,700);
        setLayout(new BorderLayout());

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(1,3));
        this.add(upPanel,BorderLayout.PAGE_START);
        upPanel.add(new JLabel("Gra o życie"));

        JButton beging =new JButton("Przywróc stan początkowy");upPanel.add(beging);
        JButton clear =new JButton("Wyczyść");upPanel.add(clear);


        int w=50,h=50;
        boolean [][]tab=new boolean[w][h];
        JButton [][]buttons = new JButton[w][h];

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(h,w));
        this.add(centerPanel,BorderLayout.CENTER);
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                Icon icon=new ImageIcon();
                MyButton tmp = new MyButton();
                centerPanel.add(tmp);
                buttons[i][j]=tmp;
                tab[i][j]=false;
            }


        }





        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1,3));
        this.add(downPanel,BorderLayout.PAGE_END);

        JButton button1step = new JButton("Jeden ruch");downPanel.add(button1step);
        JButton button5step = new JButton("5 ruchów");downPanel.add(button5step);
        JButton button10step = new JButton("10 ruchów");downPanel.add(button10step);



        JButton start = new JButton("Start");downPanel.add(start);








        this.setTitle("PSM6");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->new Main());
    }
}