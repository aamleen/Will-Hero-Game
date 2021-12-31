package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Weapon_Chest extends Game_Objects {



    Weapon_Chest(int x ){
        object=new ImageView(new Image("Assets/chest.png"));
        object.setLayoutX(x);
        object.setFitWidth(55);
        object.setFitHeight(40);
    }
    public void open(){}

    public void give_item(Hero hero){
        int ID=new Random().nextInt(2);
        if(ID==1){
            hero.addWeapon(new Shurikens());
        }
        else
            hero.addWeapon(new Swords());
    }

    public void onCollision(Hero hero){}

    public void disappear(){}
}
