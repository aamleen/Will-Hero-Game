package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coins extends Game_Objects{

    Coins(int x , int y){
        object=new ImageView(new Image("Assets/Coin.png"));
        object.setLayoutX(x);
        object.setY(y);
        object.setFitWidth(20);
        object.setFitHeight(20);
    }

    public void onCollision(){

    }

    @Override
    public void onCollision(Hero hero) {

    }

    public void disappear(){

    }
}
