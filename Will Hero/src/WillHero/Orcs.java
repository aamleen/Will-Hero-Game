package WillHero;

import javafx.animation.FadeTransition;
import javafx.util.Duration;

public abstract class Orcs extends Game_Objects implements OrcsCollision{
    private int collision_type;
    private int x_vel;
    private int y_vel;
    private int duration;
    private boolean kill;

    @Override
    public void onCollision(Hero hero){
        System.out.println("hii");

        switch (collision_type){
            case 1: x_vel=1;
                duration= 40;
                hero.displaceOrc(this);
                break;
            case 2: hero.killHero();
                break;
            case 3: killOrc();
                break;
            default:
                break;
        }
    }

    public void killOrc(){
        disappear();
        kill=true;
    }

    public int getX_vel() {
        return x_vel;
    }

    public void setX_vel(int x_vel) {
        this.x_vel = x_vel;
    }

    public int getY_vel() {
        return y_vel;
    }

    public void setY_vel(int y_vel) {
        this.y_vel = y_vel;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int if_collides(Hero hero){
        if(hero.getHero().getBoundsInParent().getMinX()>object.getBoundsInParent().getMaxX())
            return -1;
        if(hero.getHero().getBoundsInParent().intersects(object.getBoundsInParent())) {
            if(collisionType(hero, object, 0)==1){
                collision_type=3;
                onCollision(hero);
            }
            switch(collisionType(hero, object, 1)){
                case 1:
                    collision_type=1;
                    onCollision(hero);
                    System.out.println("orc bhaag");
                    break;
                case 2:
                    collision_type=2;
                    onCollision(hero);
                    System.out.println("pichak gya");
                    break;
                default:
                    break;
            }
        }
        if(kill)
            return -11;
        return 0;
    }
}
