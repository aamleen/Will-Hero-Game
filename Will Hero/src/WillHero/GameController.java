package WillHero;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane staticFrame ,  movingPlatform;


    private ImageView hero;

    private ArrayList<ImageView> orcs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image island1=new Image("Assets/island1.png");
        Image island2=new Image("Assets/island2.png");
        int k=0;
        ArrayList<ImageView> islands=new ArrayList<>();
        for(int i=0;i<3000;i+=400){
            islands.add(new ImageView(island1));
            islands.get(k).setLayoutX(i);
            islands.get(k).setY(-40);
            movingPlatform.getChildren().add(islands.get(k++));
            islands.add(new ImageView(island2));
            islands.get(k).setLayoutX(i+200);
            islands.get(k).setY(-40);
            movingPlatform.getChildren().add(islands.get(k++));
        }
        k=0;
        Image redOrc =new Image("Assets/redOrc.jpeg");
        Image greenOrc =new Image("Assets/greenOrc.jpeg");
        orcs=new ArrayList<>();
        for(int i=200;i<3000;i+=350){
            if(i%100==50){
                orcs.add(new ImageView(redOrc));
            }
            else{
                orcs.add(new ImageView(greenOrc));
            }
            orcs.get(k).setLayoutX(i);
            orcs.get(k).setFitWidth(33);
            orcs.get(k).setFitHeight(40);
            movingPlatform.getChildren().add(orcs.get(k++));
        }


        hero=new ImageView("Assets/Hero.png");
        hero.setX(0);
        hero.setY(0);
        hero.setFitWidth(40);
        hero.setFitHeight(40);
        movingPlatform.getChildren().add(hero);

        TranslateTransition heroJump=new TranslateTransition();
        heroJump.setNode(hero);
        heroJump.setDuration(Duration.millis(500));
        heroJump.setCycleCount(TranslateTransition.INDEFINITE);
        heroJump.setByY(-40);
        heroJump.setAutoReverse(true);
        heroJump.play();

        k-=1;
        while(k>=0){
            if(k%2==0)
                OrcJumpFunc(orcs.get(k--),1000);
            else
                OrcJumpFunc(orcs.get(k--),750);
        }


    }

    void OrcJumpFunc(ImageView orc,int dur){
        TranslateTransition OrcJump=new TranslateTransition();
        OrcJump.setNode(orc);
        OrcJump.setDuration(Duration.millis(dur));
        OrcJump.setCycleCount(TranslateTransition.INDEFINITE);
        OrcJump.setByY(-80);
        OrcJump.setAutoReverse(true);
        OrcJump.play();
    }

    public void move(){
        hero.setTranslateX(hero.getTranslateX()+100);
        movingPlatform.setTranslateX(movingPlatform.getTranslateX()-100);
    }

    public void checkCollision(){
        ImageView orcc=orcs.get(0);
        if(hero.getTranslateX()>=orcc.getTranslateX()){
            orcc.setTranslateX(orcc.getTranslateX()-(orcc.getTranslateX()-(hero.getTranslateX()-100)));
            System.out.println("Collision");
            if(hero.getTranslateY()>=orcc.getTranslateY())
                System.out.println("Pichak gya saala");
            orcc.setTranslateX(orcc.getTranslateX()+80);
        }

    }
}