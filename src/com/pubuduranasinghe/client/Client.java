package com.pubuduranasinghe.client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Pubudu on 2017-06-18.
 */
public class Client extends Application {
    public static void main(String[] args) {
        System.out.println("Client Running..");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello FX");

        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.CORNFLOWERBLUE);
        Font theFont = Font.font("Circular Std Bold", FontWeight.NORMAL, 48);
        gc.setFont(theFont);
        gc.fillText("Hello FX!", 400, 300);
        primaryStage.show();
    }
}
