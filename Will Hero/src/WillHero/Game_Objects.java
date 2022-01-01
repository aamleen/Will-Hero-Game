package WillHero;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Game_Objects {
    private int length;
    private int height;

    protected ImageView object;

    public int if_collides(Hero hero){
        if(hero.getHero().getBoundsInParent().getMinX()>=object.getBoundsInParent().getMaxX())
            return -1;
        if(hero.getHero().getBoundsInParent().getMaxX() >= object.getBoundsInParent().getMinX()){
            System.out.println("Fucked");
            onCollision(hero);
            return 1;
        }
        return 0;
    }

    public ImageView getObject() {
        return object;
    }

    public ImageView display(){
        return object;
    }

    public abstract void onCollision(Hero hero);

    public void disappear(){
        FadeTransition fade = new FadeTransition();
        fade.setNode(object);
        fade.setDuration(Duration.millis(100));
        fade.setFromValue(1);
        fade.setToValue(0.1);
        fade.setCycleCount(1);
    }
    @Override
    public String toString() {
        return this.getClass()+"";
    }
}
