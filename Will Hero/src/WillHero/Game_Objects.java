package WillHero;

import javafx.scene.image.ImageView;

public abstract class Game_Objects {
    private int length;
    private int height;
    private Position posi;

    protected ImageView object;

    public boolean if_collides(Hero hero){
        return true;
    }
    public ImageView display(){
        return object;
    }


    public abstract void onCollision(Hero hero);

}
