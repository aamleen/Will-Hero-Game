package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin_Chest extends Game_Objects {

//    private ImageView Cchest;

    Coin_Chest(int x ){
            object=new ImageView(new Image("Assets/ChestClosed.png"));
            object.setLayoutX(x);
            object.setFitWidth(33);
            object.setFitHeight(40);
//            object.setY(y);
    }
    public void open(){}

    public void give_item(){}

    public void onCollision(Hero hero){}

    public void disappear(){}

}
