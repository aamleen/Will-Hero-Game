package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Weapon_Chest extends Game_Objects {



    Weapon_Chest(int x ){
        object=new ImageView(new Image("Assets/chest.png"));
        object.setLayoutX(x);
        object.setFitWidth(33);
        object.setFitHeight(40);
    }
    public void open(){}

    public void give_item(){}

    public void onCollision(Hero hero){}

    public void disappear(){}
}
