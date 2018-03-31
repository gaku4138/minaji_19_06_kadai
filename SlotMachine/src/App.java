
/*
○・stopボタンを押すとあにめーしょんが止まる処理
    無限にループし続けるtimer(timelineの」メソッド）のしょりがストップする
    エラーが起きたらローカル変数をググる→初期化のはなし

・３つのlbに、それぞれアニメーションを設定する
・枠の作成
・モーダルウインドウの設定
・
*/


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Collections.addAll;

public class App extends Application {
    Timeline timer;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        //ラベルの作成（数字を表示する場所）
        //配列とループを使って
        Label[] slot = new Label[3] ;  //要素３の、配列名slotを用意する
        for (int i = 0; i < slot.length;  i++){  //要素３ = slot.length まで以下の処理を繰り返す
            Label lb = new Label("1");      //オブジェクトlbを実体化し、要素ごとに初期値"1"を渡す
            slot[i] = lb;                        //配列名slotに、lbを格納する
        }

//        Label label1 = new Label("1");
//        Label label2 = new Label("1");
//        Label label3 = new Label("1");


        //数字を表示するnumBoxを作成
        HBox numBox = new HBox(20d);
        numBox.setPadding(new Insets(10,10,10,10));
        numBox.setAlignment(Pos.CENTER);
        numBox.getChildren().addAll(slot); //numBoxに配列slotを入れる

//        for(int i = 0; i < slot.length; i++){
//            numBox.getChildren().add(slot[i]);
//        }

        /*
        numBox.getChildren().add(slot1);
        numBox.getChildren().add(slot2);
        numBox.getChildren().add(slot3);
         */


        //ボタンの作成
        Button start_button = new Button("Start");
        Button stop_button = new Button("Stop");

        //startボタンを押すと{処理}が走る【ランダム）
        start_button.setOnAction(event -> {
            Random rand = new Random();
            //Timelineオブジェクトでアニメーションの作成
            Timeline timer  = new Timeline(new KeyFrame(Duration.millis(100), e -> {

                //0~9までの大きさの乱数を生成
                int randomNumber = rand.nextInt(10);
                String s = String.valueOf(randomNumber);        //randomNumber内のIntを、String sに変換
                slot[0].setText(s);                             //スロットに上書き処理

                /*
                for (int i = 0;i < slot.length; i ++){
                    slot[i].setText(s);
                }
                slot[0].setText(s);
                slot[1].setText(s);
                slot[2].setText(s);
                 */
            }));
            this.timer = timer;
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
            //ストップボタンでアニメーションを止める処理
            stop_button.setOnAction(event1 -> {
                timer.stop();
            });
        });


        //ラベルの装飾（ボーダー角丸）


        //ボタンを表示するHBoxの作成
        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(start_button);
        hBox.getChildren().add(stop_button);

        //borderPaneに追加
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(30,10,10,10));
        borderPane.setTop(numBox);
        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane,400,120);
        stage.setScene(scene);
        stage.show();

    }
}
