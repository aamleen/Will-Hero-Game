package WillHero;

import javafx.scene.image.ImageView;

public abstract class Game_Objects {
    private int length;
    private int height;
    private Position posi;

    protected ImageView object;

    public int if_collides(Hero hero){
        if(hero.getHero().getBoundsInParent().getMinX()>object.getBoundsInParent().getMaxX())
            return -1;
        if(hero.getHero().getBoundsInParent().getMaxX() == object.getBoundsInParent().getMinX()){
            return 1;
        }
        return 0;
    }

    public ImageView display(){
        return object;
    }


    public abstract void onCollision(Hero hero);

}
