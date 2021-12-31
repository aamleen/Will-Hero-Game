package WillHero;

public abstract class Weapons {
    int level;
    int power;
    int ID;

    public boolean if_hits(){
        return true;
    }
    public int get_ID(){
        return 0;
    }
    public int getPower(){
        return 0;
    }
    public void setPower(int power){

    }
    public void setLevel(int level){

    }
    abstract void trajectory_motion();

}
