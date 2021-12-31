package WillHero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Hero implements Initializable,Transition {

    @FXML
    private AnchorPane staticFrame ,  movingPlatform;

    private ImageView hero;

    private ArrayList<ImageView> orcs;

    private TranslateTransition heroJump,OrcJump;

    private User user;
    private Game game;
    private Helmet helmet;


    private Label onScreen_Score;

    Hero(User user, Game game){
        this.user=user;
        this.game=game;
        helmet=new Helmet("Fox");
    }

    private Timeline gameloop;

//    private String S
//    public void setS(int o){
//        this.S = (String) o;
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user.addIsland(movingPlatform);
        user.addObjects(movingPlatform);

        onScreen_Score=new Label();
        onScreen_Score.setAlignment(Pos.BOTTOM_RIGHT);
        onScreen_Score.setText("00");
        onScreen_Score.setFont(new Font("Times New Roman",30));
        staticFrame.getChildren().add(onScreen_Score);

        hero=new ImageView("Assets/Hero.png");
        hero.setX(0);
        hero.setY(0);
        hero.setFitWidth(40);
        hero.setFitHeight(40);
        movingPlatform.getChildren().add(hero);



        heroJump=new TranslateTransition();
        //LinearAnimation(heroJump,hero);

        gameloop=new Timeline(
                new KeyFrame(Duration.millis(10),
                        e -> {
                            if(game.if_collision(this)){
                                game.onCollision(this);
                            }
                        })
        );
        gameloop.setCycleCount(Timeline.INDEFINITE);
        gameloop.play();
    }

    /*    Image island1=new Image("Assets/island1.png");
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
//        for(int i=200;i<3000;i+=350){
//            if(i%100==50){
//                orcs.add(new ImageView(redOrc));
//            }
//            else{
//                orcs.add(new ImageView(greenOrc));
//            }
//            orcs.get(k).setLayoutX(i);
//            orcs.get(k).setFitWidth(33);
//            orcs.get(k).setFitHeight(40);
//            movingPlatform.getChildren().add(orcs.get(k++));
//        }
        

        hero=new ImageView("Assets/Hero.png");
        hero.setX(0);
        hero.setY(0);
        hero.setFitWidth(40);
        hero.setFitHeight(40);
        movingPlatform.getChildren().add(hero);

        heroJump=new TranslateTransition();
        heroJump.setNode(hero);
        heroJump.setDuration(Duration.millis(1500));
        heroJump.setCycleCount(TranslateTransition.INDEFINITE);
        heroJump.setByY(-70);
        heroJump.setAutoReverse(true);
        heroJump.play();

        k-=1;
//        while(k>=0){
//            if(k%2==0)
//                OrcJumpFunc(orcs.get(k--),1000);
//            else
//                OrcJumpFunc(orcs.get(k--),750);
//        }
        k=0;
        orcs.add(new ImageView(greenOrc));
        orcs.get(k).setLayoutX(200);
        orcs.get(k).setFitWidth(33);
        orcs.get(k).setFitHeight(40);
        movingPlatform.getChildren().add(orcs.get(k++));

        OrcJump=new TranslateTransition();
        OrcJump.setNode(orcs.get(0));
        OrcJump.setDuration(Duration.millis(1000));
        OrcJump.setCycleCount(TranslateTransition.INDEFINITE);
        OrcJump.setByY(-80);
        OrcJump.setAutoReverse(true);
        OrcJump.play();

//        hero=new Rectangle();
//        orcs.get(0)=new Rectangle();
//
//        hero.setWidth(40);
//        hero.setHeight(40);
//        hero.setLayoutX(0);
//        hero.setLayoutY(300);
//        hero.setFill(Color.valueOf("blue"));
//        staticFrame.getChildren().add(hero);
//
//        orcs.get(0).setLayoutX(200);
//        orcs.get(0).setLayoutY(300);
//        orcs.get(0).setWidth(40);
//        orcs.get(0).setHeight(40);
//        staticFrame.getChildren().add(orcs.get(0));

    }*/


    public void addWeapon(Weapons weapon){
        helmet.store_Weapon(weapon);

    }

    public int getScore(){
        return Integer.parseInt(onScreen_Score.getText());
    }

    public void setScore(int n){
        user.setScore(n);
        onScreen_Score.setText(n+"");
    }

    TranslateTransition getHeroAnimation(){
        return heroJump;
    }

    public ImageView getHero(){
        return hero;
    }

    public void move(double h_move){
        hero.setTranslateX(hero.getTranslateX()+h_move);

        if(hero.getBoundsInParent().getMaxX()>300)
            movingPlatform.setTranslateX(movingPlatform.getTranslateX()-h_move);
        System.out.println("After:");
        System.out.println("Hero: "+hero.getBoundsInParent());
        System.out.println("Orcs: "+orcs.get(0).getBoundsInParent()+"\n");
    }

    public boolean checkCollision(){
        if(hero.getBoundsInParent().getMaxX()==orcs.get(0).getBoundsInParent().getMinX()){
            if(hero.getBoundsInParent().getMinY()>orcs.get(0).getBoundsInParent().getMaxY()){
                OrcJump.pause();
                System.out.println("Pichak gya saala");
                move(100);
                return true;
            }
            //orcs.get(0).setTranslateX(orcs.get(0).getTranslateX()-(orcs.get(0).getTranslateX()-(hero.getTranslateX()-100)));
            double dist=orcs.get(0).getBoundsInParent().getMinX()-hero.getBoundsInParent().getMaxX();
            move(dist);
//            hero.setTranslateX(hero.getTranslateX()-);
            return true;
        }
        return false;
    }

}