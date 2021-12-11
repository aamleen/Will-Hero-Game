package WillHero;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class inGameMenuController implements Initializable {

    @FXML
    private ImageView gamePause;

    @FXML
    private Button resume,Home;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition pauseImg=new FadeTransition();
        pauseImg.setNode(gamePause);
        pauseImg.setDuration(Duration.millis(500));
        pauseImg.setCycleCount(TranslateTransition.INDEFINITE);
        pauseImg.setFromValue(0.5);
        pauseImg.setToValue(1);
        pauseImg.setAutoReverse(true);
        pauseImg.play();
    }

    public void resume(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void back2Home(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
