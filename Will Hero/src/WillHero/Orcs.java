package WillHero;

public abstract class Orcs extends Game_Objects {
    int power;

    public void collisionType(Hero hero, Weapons weapon){}

    public int getPower(){
        return 0;
    }
    public void setPower(int power){}

    public void displaceOrc(){}

    public abstract void onCollision(Hero hero);

    public abstract void killOrc();

    public void disappear() {};
}
