package WillHero;

import java.util.ArrayList;

public class Helmet {
    ArrayList<Weapons> weapons;
    String hel_name;

    Helmet(String name){
        weapons=new ArrayList<>();
        hel_name=name;
    }
    public void store_Weapon(Weapons weapon){
        for(Weapons weap: weapons)
        {
            if(weap.getClass()==weapon.getClass()) {
                upgrade_weapon(weapons.indexOf(weap));
                return;
            }
        }
        weapons.add(weapon);
    }
    public void throw_weapon(int ID){

    }
    public void upgrade_weapon(int ID ){
        weapons.get(ID).setPower(weapons.get(ID).getPower()+1);
    }
}

