package WillHero;

public abstract class Orcs extends Game_Objects implements OrcsCollision{
    int power;

    public void collisionType(Hero hero, Weapons weapon){}

    public int getPower(){
        return 0;
    }
    public void setPower(int power){}

    public void displaceOrc(){}

    public abstract void onCollision(Hero hero);

    public abstract void killOrc();

    @Override
    public int if_collides(Hero hero){
        if(hero.getHero().getBoundsInParent().getMinX()>object.getBoundsInParent().getMaxX())
            return -1;
        if(hero.getHero().getBoundsInParent().getMaxX() == object.getBoundsInParent().getMinX()){
            return 1;
        }
        return 0;
    }

    public void disappear() {};
}
