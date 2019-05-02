import javafx.scene.control.Button;
import javafx.scene.image.*;
public class MyButtonFx extends Button {

    boolean b;
    int w,h;
    Image no=new Image("no.png");
    Image yes=new Image("yes.png");

    public MyButtonFx(int w, int h) {
        this.b=false;
        this.w=w;
        this.h=h;
        this.setWidth(30);
        this.setWidth(30);
    }

    public void setIcon() {
        b=!b;
        if(!b){
            this.getChildren().add(new ImageView(no));
        }else{
            this.getChildren().add(new ImageView(yes));
        }

    }
}
