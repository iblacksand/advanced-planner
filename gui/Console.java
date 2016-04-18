package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * Created by John Elizarraras on 3/29/2016.
 */
public class Console extends Application{

    TextField text;

    public Console(String consoleText){
        text = new TextField(consoleText);
        text.setEditable(false);
        start(new Stage());
    }

    public void start(Stage primStage){
        primStage.setTitle("Console");
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(20,0,20,20));
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,20,10,20));
        hBox.getChildren().add(text);
        bp.setCenter(hBox);
        Scene scene = new Scene(bp, 800, 600);
        primStage.setScene(scene);
        primStage.show();
    }

}
