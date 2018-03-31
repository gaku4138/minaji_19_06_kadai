import javafx.scene.control.Label;

import java.util.Objects;

//ここでは、一つのラベルが持つ要素、動きを
public class MyLabel extends  Label{
    private static Objects anInt;

    public MyLabel(){
        super();
        this.setText("1");
        this.setPrefSize(50,50);
    }

    public static Objects getInt() {
        return anInt;
    }

    public void Start(){
        //スタートボタンを押したときのアニメーション処理
        this.setText("Start");
    }

    public void Stop(){
        this.setText("Stop");
    }
}
