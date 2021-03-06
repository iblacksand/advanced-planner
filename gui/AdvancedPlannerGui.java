package gui;

import compile.Compiler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.AdvancedPlanner;

import java.io.FileReader;
import java.util.Optional;

/**
 * Created by John Elizarraras on 3/15/2016.
 */
public class AdvancedPlannerGui extends Application {
    private Stage mainStage;
    private String termRun;
    /**
     * Credit goes to jewelsea from stackoverflow(http://stackoverflow.com/users/1155209/jewelsea)
     */
    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(mainStage);
        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };

    public static void main(String[] args) {
        launch(args);
    }

    public void start() {
        main(new String[0]);
    }

    public void stage() {
        main(new String[0]);
    }

    public void start(Stage primStage) {
        this.mainStage = primStage;
        primStage.setOnCloseRequest(confirmCloseEventHandler);
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));
        primStage.setTitle("Advanced Planner");
        TextField textField = new TextField("Put File Name Here");
        Button button = new Button("Run");
        button.setVisible(false);
        Text notFile = new Text("This is not a file!");
        notFile.setVisible(false);
        Text compileError = new Text("Compile Error!");
        compileError.setVisible(false);
        Button compile = new Button("Compile");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Linux(Bash)",
                        "Windows(CMD Prompt)"
                );
        ComboBox box = new ComboBox(options);
        box.setValue("Windows(CMD Prompt)");
        // box.getValue() = gets the selected text
        compile.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Compiler ef = new Compiler(textField.getText());
                int e = ef.errors();
                if (isFile(textField.getText()) && e < 1) {
                    button.setVisible(true);
                    notFile.setVisible(false);
                    compileError.setVisible(false);
                }
                if (!isFile(textField.getText())) {
                    notFile.setVisible(true);
                    button.setVisible(false);
                }
                if (isFile(textField.getText())) notFile.setVisible(false);
                if (e > 0) {
                    compileError.setVisible(true);
                    button.setVisible(false);

                }
                if (e < 1) compileError.setVisible(false);
            }
        });
        Button edit = new Button("Edit File");
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String file = textField.getText();
                if (isFile(file)) {
                    notFile.setVisible(false);
                    try {
                        button.setVisible(false);
                        if (((String) box.getValue()).equals("Linux(Bash)"))
                            Runtime.getRuntime().exec("bash" + " -c " + "vim " + file);
                        else Runtime.getRuntime().exec("cmd" + " /c " + "notepad.exe " + file);
                    } catch (Exception e) {

                    }
                } else {
                    notFile.setVisible(true);
                }
            }
        });
        button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (!((String) box.getValue()).equals("Linux(Bash)")) termRun = "cmd /c";
                else termRun = "bash -c";
                AdvancedPlanner ap = new AdvancedPlanner(textField.getText(), termRun);
            }
        });
        Button exit = new Button("Exit");
        exit.setVisible(true);
        exit.setOnAction(event -> primStage.fireEvent(new WindowEvent(primStage, WindowEvent.WINDOW_CLOSE_REQUEST)));
        HBox vbButtons = new HBox();
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0, 20, 10, 20));
        vbButtons.getChildren().addAll(textField, box, edit, compile, button, exit, notFile, compileError);
        border.setTop(vbButtons);
        Scene scene = new Scene(border, 800, 600);
        primStage.setScene(scene);
        primStage.setMaximized(true);
        primStage.show();
    }

    private boolean isFile(String name) {
        boolean res = true;
        try {
            FileReader f = new FileReader(name);
        } catch (Exception e) {
            res = false;
        }
        return res;
    }
}

//    public void addText(String text){
//        Stage newStage = mainStage;
//        BorderPane borderPane = new BorderPane();
//        HBox hBox = new HBox();
//        hBox.setSpacing(10);
//        hBox.setPadding(new Insets(0,20,10,20));
//        Scene sc = newStage.getScene();
//        sc.get
//
//