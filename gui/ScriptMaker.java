package gui;

import file.FileEditor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by John Elizarraras on 4/3/2016.
 */
public class ScriptMaker extends Application{
    String title;
    String path;
    public ScriptMaker(String path){
        title = "Editing: " + path;
        this.path = path;
        start(new Stage());
    }

    public void start(Stage primStage){
        FileEditor fileEditor = new FileEditor(path);
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20,0,20,20));
        primStage.setTitle(title);
        TextField textField = new TextField("Put Line Here");
        Button exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primStage.hide();
            }
        });
        Button add = new Button("Add Line");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileEditor.add(textField.getText());
            }
        });
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,20,10,20));
        hBox.getChildren().addAll(textField, add, exit);
        borderPane.setCenter(hBox);
        Scene scene = new Scene(borderPane, 800, 600);
        primStage.setScene(scene);
        primStage.show();
    }
}
