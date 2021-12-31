package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TNT extends Game_Objects{

    TNT(int x){
        object=new ImageView(new Image("Assets/TNT.png"));
        object.setLayoutX(x);
        object.setFitWidth(33);
        object.setFitHeight(40);
//        object.setY(y);
    }
    @Override
    public void onCollision(Hero hero) {

    }

}
