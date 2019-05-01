import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame{

    private int w=10,h=10;

    private void step(MyButton [][]buttons){
        MyButton [][]tmpButtons=buttons;
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                int n=0;
                for(int a=-1;a<2;a++){
                    for(int b=-1;b<2;b++){
                        if(a!=0 && b!=0){
                            try{
                                if(buttons[i-a][j-b].b){ n++; }
                            }catch (Exception e){
                                //System.out.println(e);
                            }
                        }
                    }
                }
                System.out.print(n+" ");
                if(tmpButtons[i][j].b){
                    //zywa komorka
                    if(n==2 || n==3){
                        tmpButtons[i][j].b=true;
                    }else {
                        tmpButtons[i][j].b=false;
                    }
                }else{
                    //martwa komorka
                    if(n==3){
                        tmpButtons[i][j].b=true;
                    }else{
                        tmpButtons[i][j].b=false;
                    }
                }
            }
            System.out.println();
        }
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                buttons[i][j]=tmpButtons[i][j];
                buttons[i][j].setIcon();
            }
        }
    }



    public Main(){
        setSize(900,700);
        setLayout(new BorderLayout());

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(1,3));
        this.add(upPanel,BorderLayout.PAGE_START);
        upPanel.add(new JLabel("Gra o życie"));

        JButton random =new JButton("Losowy stan");upPanel.add(random);
        JButton clear =new JButton("Wyczyść");upPanel.add(clear);

        MyButton [][]buttons = new MyButton[w][h];

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(h,w));
        this.add(centerPanel,BorderLayout.CENTER);
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                MyButton tmp = new MyButton(i,j);
                tmp.addActionListener(e -> {
                    tmp.setIcon();
                    buttons[tmp.w][tmp.h].b= tmp.b;
                });
                centerPanel.add(tmp);
                buttons[i][j]=tmp;
            }
        }

        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1,3));
        this.add(downPanel,BorderLayout.PAGE_END);

        JButton button1step = new JButton("Jeden ruch");downPanel.add(button1step);
        JButton button5step = new JButton("5 ruchów");downPanel.add(button5step);
        JButton button10step = new JButton("10 ruchów");downPanel.add(button10step);
        JButton start = new JButton("Start");downPanel.add(start);

        clear.addActionListener(e -> {
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    buttons[i][j].b=false;
                    buttons[i][j].setIcon();
                }
            }
        });

        random.addActionListener(e->{
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    Random r = new Random();
                    boolean tmp=r.nextBoolean();
                    buttons[i][j].b=tmp;
                    buttons[i][j].setIcon();
                }
            }
        });

        button1step.addActionListener(e -> {
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    System.out.print(buttons[i][j].b+" ");
                }
                System.out.println();
            }

//            step(buttons);

//            for(int i=0;i<w;i++){
//                for(int j=0;j<h;j++){
//                    System.out.print(buttons[i][j].b+" ");
//                }
//                System.out.println();
//            }
        });

        button5step.addActionListener(e -> {

        });

        button10step.addActionListener(e -> {

        });

        this.setTitle("PSM6");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->new Main());
    }
}