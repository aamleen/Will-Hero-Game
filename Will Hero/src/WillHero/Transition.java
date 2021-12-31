package WillHero;

import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public interface Transition {
    default void LinearAnimation(TranslateTransition t_trans, ImageView img){
        //t_trans =new TranslateTransition();
        t_trans.setNode(img);
        t_trans.setDuration(Duration.millis(500));
        t_trans.setCycleCount(TranslateTransition.INDEFINITE);
        t_trans.setByY(-40);
        t_trans.setAutoReverse(true);
        t_trans.play();
    }
    default void OrcJumpFunc(ImageView orc,int dur){
        TranslateTransition OrcJump=new TranslateTransition();
        OrcJump.setNode(orc);
        OrcJump.setDuration(Duration.millis(dur));
        OrcJump.setCycleCount(TranslateTransition.INDEFINITE);
        OrcJump.setByY(-65);
        OrcJump.setAutoReverse(true);
        OrcJump.play();
    }
    default void weaponFade(ImageView weapon){
            FadeTransition weaponAn=new FadeTransition();
            weaponAn.setNode(weapon);
            weaponAn.setDuration(Duration.millis(4000));
            weaponAn.setCycleCount(TranslateTransition.INDEFINITE);
            weaponAn.setFromValue(0.2);
            weaponAn.setToValue(0.8);
            weaponAn.setAutoReverse(true);
            weaponAn.play();
    }
}
