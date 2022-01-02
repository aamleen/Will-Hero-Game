package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossOrc extends Orcs{
    BossOrc(){
        object=new ImageView(new Image("Assets/BossOrc.png"));
        object.setLayoutX(2700);
        object.setFitWidth(67);
        object.setFitHeight(57);
    }

    public void killOrc(){};
}
