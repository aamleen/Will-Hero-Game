package WillHero;

import javafx.scene.image.ImageView;

public abstract class Weapons {
    private int power;
    private int ID;
    private String name;
    protected ImageView weapon;

    Weapons(String name){
        this.name =name;
    }

    public boolean if_hits(){
        return true;
    }
    public int get_ID(){
        return 0;
    }
    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power=power;
    }



    @Override
    public String toString() {
        return name;
    }
}
