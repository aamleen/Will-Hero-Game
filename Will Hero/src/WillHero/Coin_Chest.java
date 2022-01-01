package WillHero;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Coin_Chest extends Game_Objects {

    int zx ;

    Coin_Chest(int x ){
            object=new ImageView(new Image("Assets/ChestClosed.png"));
            object.setLayoutX(x);
            object.setFitWidth(55);
            object.setFitHeight(40);
            zx = (int) object.getLayoutX();

    }
    public void open(){}

    public void give_item(){}

    @Override
    public void onCollision(Hero hero){
        object.setImage(new Image("Assets/ChestOpen.png"));
        object.setLayoutX(zx);
        object.setFitWidth(55);
        object.setFitHeight(40);
//        disappear(object);
    }

    public void disappear(ImageView img){

    }

}
