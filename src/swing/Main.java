package swing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame{

    private int w=40,h=40;
    private boolean b=false;
    private void step(MyButton[][]buttons){
        int [][]ints=new int[w][h];
        boolean [][]booleans=new boolean[w][h];

        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                int n=0;
                for(int a=-1;a<2;a++){
                    for(int b=-1;b<2;b++){
                            try{
                                if(buttons[i-a][j-b].b){ n++; }
                            }catch (Exception e){
                                //System.out.println(e);
                            }

                    }
                }
                if(buttons[i][j].b){ n--; }
                ints[i][j]=n;
                booleans[i][j]=buttons[i][j].b;
            }
        }

        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                int n=ints[i][j];
                if(booleans[i][j]){
                    //zywa komorka
                    if(!(n==2 || n==3)){
                        buttons[i][j].setIcon();
                    }
                }else{
                    //martwa komorka
                    if(n==3){
                        buttons[i][j].setIcon();
                    }
                }
            }
        }

    }

    private Main(){
        setSize(900,700);
        setLayout(new BorderLayout());

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(1,3));
        this.add(upPanel,BorderLayout.PAGE_START);
        upPanel.add(new JLabel("Gra o życie"));

        JButton random =new JButton("Losowy stan");upPanel.add(random);
        JButton clear =new JButton("Wyczyść");upPanel.add(clear);

        MyButton[][]buttons = new MyButton[w][h];

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(h,w));
        this.add(centerPanel,BorderLayout.CENTER);
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                MyButton tmp = new MyButton(i,j);
                tmp.addActionListener(e -> tmp.setIcon());
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
        JButton start = new JButton("START");downPanel.add(start);

        clear.addActionListener(e -> {
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    buttons[i][j].b=true;
                    buttons[i][j].setIcon();
                }
            }
        });

        random.addActionListener(e->{
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    Random r = new Random();
                    buttons[i][j].b=r.nextBoolean();
                    buttons[i][j].setIcon();
                }
            }
        });

        button1step.addActionListener(e -> step(buttons));

        button5step.addActionListener(e -> {
            for(int i=0;i<5;i++){
                step(buttons);
            }
        });

        button10step.addActionListener(e -> {
            for(int i=0;i<10;i++){
                step(buttons);
            }
        });


        start.addActionListener(e->{
            Thread thread=new Thread(()->{
                while(true){
                    if(b){
                        step(buttons);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }

                }
            });
            thread.start();

            if(start.getText().equals("START")){
                b=true;
                start.setText("STOP");
            }else{
                b=false;
                start.setText("START");
            }
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