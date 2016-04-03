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

    String consoleText;
    Stage stage;
    public Console(String consoleText){
        this.consoleText = consoleText;
        launch(new String[1]);
    }

    public Console(){
        consoleText = "Didn't go through";
        //launch(new String[1]);
    }

    public static void main(String[] args){
        //launch(args);
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        Console con = new Console(text);
    }

    public void start(Stage primStage){
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(20,0,20,20));
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,20,10,20));
        TextField textField = new TextField();
        textField.setText(consoleText);
        textField.setPrefWidth(500);
        textField.setDisable(true);
        hBox.getChildren().add(textField);
        bp.setCenter(hBox);
        Scene scene = new Scene(bp, 800, 600);
        primStage.setScene(scene);
        stage = primStage;
        stage.show();
    }

    public void addText(String str){
        stage.hide();
        consoleText += "\n" + str;
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(20,0,20,20));
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,20,10,20));
        TextField textField = new TextField();
        textField.setText(consoleText);
        textField.setDisable(true);
        hBox.getChildren().add(textField);
        bp.setCenter(hBox);
        Scene scene = new Scene(bp, 800, 600);
        Stage temp = new Stage();
        temp.setScene(scene);
        stage = temp;
        stage.show();
    }
}
