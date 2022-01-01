package WillHero;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Coins extends Game_Objects{

    Coins(int x , int y){
        object=new ImageView(new Image("Assets/Coin.png"));
        object.setLayoutX(x);
        object.setY(y);
        object.setFitWidth(20);
        object.setFitHeight(20);
    }

    @Override
    public void onCollision(Hero hero) {
        disappear(object);
        hero.setScore(hero.getScore()+1);
    }

    public void disappear(ImageView img){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(0.1));
        fade.setFromValue(1);
        fade.setToValue(0.1);
        fade.setCycleCount(1);
        fade.setAutoReverse(true);
    }
}
