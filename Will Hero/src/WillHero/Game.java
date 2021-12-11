package WillHero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Scene scene=new Scene(root,1337,653);
        //scene.getStylesheets().add(getClass().getResource("jiggly_button.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Will Hero");
        stage.setResizable(false);

        Image icon=new Image("Assets/icon.jpg");
        stage.getIcons().add(icon);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            exitGame(stage);});
    }

    public void exitGame(Stage stage){
        Alert exitAlert=new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit");
        exitAlert.setContentText("You're about to Exit !!");
        exitAlert.setHeaderText("Are you sure you want to Exit?");
        if(exitAlert.showAndWait().get()== ButtonType.OK){
            System.out.println("You successfully exited");
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
