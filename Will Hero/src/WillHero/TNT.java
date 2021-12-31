package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TNT extends Game_Objects{
    private int cx;

    TNT(int x){
        object=new ImageView(new Image("Assets/TNT.png"));
        object.setLayoutX(x);
        object.setFitWidth(33);
        object.setFitHeight(40);
        cx= (int) object.getLayoutX();
//        object.setY(y);
    }
    @Override
    public void onCollision(Hero hero) {
        object.setImage(new Image("Assets/TNT_Boom"));
        object.setLayoutX(cx);
        object.setFitWidth(38);
        object.setFitHeight(42);
    }

}
