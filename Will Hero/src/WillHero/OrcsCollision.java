package WillHero;

import javafx.scene.image.ImageView;

public interface OrcsCollision {
    default int collisionType(Hero hero, ImageView object, int check){
        if(check==1) {
            if (hero.getHero().getBoundsInParent().getMaxX() == object.getBoundsInParent().getMinX()) {
                System.out.println("Hola..baahr se bhola");
                return 1;
            }
            if (hero.getHero().getBoundsInParent().getMaxY() < object.getBoundsInParent().getMinY()) {
                System.out.println("hero:"+hero.getHero().getBoundsInParent());
                System.out.println(object.getBoundsInParent());
                return 2;
            }
        }
        else {
            for (Weapons weapon : hero.getWeapons()) {
                if (weapon.getWeapon().getBoundsInParent().intersects(object.getBoundsInParent()))
                    return 1;
            }
        }
        return 0;
    }
}
