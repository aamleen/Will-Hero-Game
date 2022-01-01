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

    private boolean gameOver;
    private int x_vel;
    private int y_vel;
    private int duration;


    private ArrayList<Orcs> collidingOrc;

    private Label onScreen_Score;

    Hero(User user, Game game){
        this.user=user;
        this.game=game;
        helmet=new Helmet("Fox");
        collidingOrc=new ArrayList<>();
        gameOver=false;
    }

    private Timeline gameloop;

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


    }

    public void game_loop(){
        System.out.println("HERO: "+hero.getBoundsInParent());
        gameloop=new Timeline(
                new KeyFrame(Duration.millis(10),
                        e -> {
                            if(duration-- >0){
                            hero.setTranslateX(hero.getTranslateX() + x_vel);
                            movingPlatform.setTranslateX(movingPlatform.getTranslateX() - x_vel);
                            }
                            for(Orcs o: collidingOrc){
                                if(o.getDuration()>0){
                                    o.getObject().setTranslateX(o.getObject().getTranslateX()+o.getX_vel());
                                    o.setDuration(o.getDuration()-1);
                                }
                            }
                            game.if_collision(this);
                        })
        );
        gameloop.setCycleCount(Timeline.INDEFINITE);
        gameloop.play();
    }

    ArrayList<Weapons> getWeapons(){
        return helmet.getWeapon();
    }

    void throwWeapon(){
        if(helmet.hasWeapon()){
            ArrayList<Weapons> weapons=getWeapons();
        }
        else
            return;
    }

    public void addWeapon(Weapons weapon){
        helmet.store_Weapon(weapon);

    }

    public void displaceOrc(Orcs orc){
        collidingOrc.add(orc);
        System.out.println(collidingOrc);
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

    public void killHero(){
        gameOver=true;
    }

    public void move(){
        x_vel=1;
        duration=30;
    }

    /*public void move(double h_move){
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
    }*/

}