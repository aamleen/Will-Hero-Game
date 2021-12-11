package WillHero;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private ImageView hero,bossOrc,redOrc1,redOrc2,greenOrc1,greenOrc2,TNT;

    @FXML
    private ImageView coin,sword,shuriken,progressbar,score,weapC1,weapC2;

    @FXML
    private Button pauseButton;

    @FXML
    private AnchorPane coin11,coin22;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition heroJump=new TranslateTransition();
        heroJump.setNode(hero);
        heroJump.setDuration(Duration.millis(500));
        heroJump.setCycleCount(TranslateTransition.INDEFINITE);
        heroJump.setByY(-40);
        heroJump.setAutoReverse(true);
        heroJump.play();

        OrcJumpFunc(bossOrc,1000);
        OrcJumpFunc(redOrc1,750);
        OrcJumpFunc(redOrc2,700);
        OrcJumpFunc(greenOrc1,720);
        OrcJumpFunc(greenOrc2,650);

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(TNT);
        scale.setDuration(Duration.millis(700));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setByX(0.2);
        scale.setByY(0.2);
        scale.setAutoReverse(true);
        scale.play();

        weaponFade(sword);
        weaponFade(shuriken);
        weaponFade(weapC1);
        weaponFade(weapC2);

        coinMove(coin11);
        coinMove(coin22);
    }

    void coinMove(AnchorPane coi){
        TranslateTransition coinTrans=new TranslateTransition();
        coinTrans.setNode(coi);
        coinTrans.setByX(20);
        coinTrans.setAutoReverse(true);
        coinTrans.setDuration(Duration.millis(2000));
        coinTrans.setCycleCount(TranslateTransition.INDEFINITE);
        coinTrans.play();
    }

    void OrcJumpFunc(ImageView orc,int dur){
        TranslateTransition OrcJump=new TranslateTransition();
        OrcJump.setNode(orc);
        OrcJump.setDuration(Duration.millis(dur));
        OrcJump.setCycleCount(TranslateTransition.INDEFINITE);
        OrcJump.setByY(-65);
        OrcJump.setAutoReverse(true);
        OrcJump.play();
    }

    void weaponFade(ImageView weapon){
        FadeTransition weaponAn=new FadeTransition();
        weaponAn.setNode(weapon);
        weaponAn.setDuration(Duration.millis(4000));
        weaponAn.setCycleCount(TranslateTransition.INDEFINITE);
        weaponAn.setFromValue(0.2);
        weaponAn.setToValue(0.8);
        weaponAn.setAutoReverse(true);
        weaponAn.play();
    }
    public void pause(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("In-Game Menu.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }


}
