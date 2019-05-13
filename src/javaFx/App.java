package javaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private int w=25,h=25;
    private boolean b=false;
    private void step(MyButtonFx[][]buttons){
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


    public void start(Stage primaryStage) {
        BorderPane scene = new BorderPane();

        GridPane upPanel = new GridPane();
        upPanel.setHgap(2);
        upPanel.setVgap(2);
        upPanel.setPadding(new Insets(0, 10, 0, 10));
        scene.setTop(upPanel);
        upPanel.add(new Label("Gra o życie"),1,0);

        Button random =new Button("Losowy stan");upPanel.add(random,2,0);
        Button clear =new Button("Wyczyść");upPanel.add(clear,3,0);

        MyButtonFx [][]buttons = new MyButtonFx[w][h];

        GridPane centerPanel = new GridPane();

        scene.setCenter(centerPanel);
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                MyButtonFx tmp = new MyButtonFx(i,j);
                tmp.setOnAction(e -> tmp.setIcon());
                centerPanel.add(tmp,j,i);
                buttons[i][j]=tmp;
            }
        }

        Button button1step = new Button("Jeden ruch");upPanel.add(button1step,4,0);
        Button button5step = new Button("5 ruchów");upPanel.add(button5step,5,0);
        Button button10step = new Button("10 ruchów");upPanel.add(button10step,6,0);
        Button start = new Button("START");upPanel.add(start,7,0);

        clear.setOnAction(e -> {
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    buttons[i][j].b=true;
                    buttons[i][j].setIcon();
                }
            }
        });

        random.setOnAction(e->{
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    Random r = new Random();
                    buttons[i][j].b=r.nextBoolean();
                    buttons[i][j].setIcon();
                }
            }
        });

        button1step.setOnAction(e -> step(buttons));

        button5step.setOnAction(e -> {
            for(int i=0;i<5;i++){
                step(buttons);
            }
        });

        button10step.setOnAction(e -> {
            for(int i=0;i<10;i++){
                step(buttons);
            }
        });

        start.setOnAction(e->{
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


        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                buttons[i][j].b=true;
                buttons[i][j].setIcon();
            }
        }

        primaryStage.setTitle("PSM6");
        primaryStage.setScene(new Scene(scene,1000,800));
        primaryStage.show();
    }
}
