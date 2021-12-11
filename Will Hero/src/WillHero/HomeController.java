package WillHero;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button newGame,loadGame,viewHighScore,inputName,exitGame,startGame,backButton;

    @FXML
    private Label greeting;

    @FXML
    private TextField name;

    @FXML
    private AnchorPane WelcomePane;

    @FXML
    private AnchorPane newGamePane;

    public void newGame(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("newGame.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void loadGame(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void startGame(ActionEvent e)throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void back(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void inputName(ActionEvent e)throws IOException{
        greeting.setText("Hii "+name.getText()+"!! Now press Start to start the game");
    }

    public void exitGame(ActionEvent e){
        Alert exitAlert=new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit");
        exitAlert.setContentText("You're about to Exit !!");
        exitAlert.setHeaderText("Are you sure you want to Exit?");
        if(exitAlert.showAndWait().get()== ButtonType.OK){
            Stage stage=(Stage)WelcomePane.getScene().getWindow();
            System.out.println("You successfully exited");
            stage.close();
        }
    }
}
