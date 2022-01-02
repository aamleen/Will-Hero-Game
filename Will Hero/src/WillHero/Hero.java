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
    private MovingProp m_prop;

    private boolean gameOver;

    private ArrayList<Orcs> collidingOrc;

    private Label onScreen_Score;

    Hero(User user, Game game){
        this.user=user;
        this.game=game;
        helmet=new Helmet("Fox");
        collidingOrc=new ArrayList<>();
        gameOver=false;
        m_prop=new MovingProp(0,2,0);
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

    }

    public void game_loop(){
        System.out.println("HERO: "+hero.getBoundsInParent());
        gameloop=new Timeline(
                new KeyFrame(Duration.millis(10),
                        e -> {
                            orcJump();
                            if(hero.getBoundsInParent().getMinY()>30)
                                System.exit(0);

                            if(m_prop.getDuration() >0){
                                hero.setTranslateX(hero.getTranslateX() + m_prop.getX_vel());
                                movingPlatform.setTranslateX(movingPlatform.getTranslateX() - m_prop.getX_vel());
                                m_prop.setDuration(m_prop.getDuration()-1);
                            }
                            else{
                                jump();
                            }
                            helmet.move_weapon(movingPlatform);

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

    public void jump(){
        if(game.platformCollision(hero)==1){
            m_prop.setY_vel(2);
        }
        else if(hero.getBoundsInParent().getMaxY() < -100) {
            m_prop.setY_vel(-2);
        }
        else{}
        hero.setTranslateY(hero.getTranslateY()-m_prop.getY_vel());
    }

    public void orcJump(){
        int i=0;
        for(Orcs o: game.getOrcs()){
            if(game.platformCollision(o.getObject())==1){
                o.sety_vel(1);
            }
            if(o.getObject().getBoundsInParent().getMaxY()<-100)
                o.sety_vel(-1);

            o.getObject().setTranslateY(o.getObject().getTranslateY()-o.gety_vel());
        }
    }

    public void addWeapon(Weapons weapon){
        helmet.store_Weapon(weapon);
        staticFrame.getChildren().add(weapon.getWeapon());
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
        onScreen_Score.setText(n+10+"");
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
        m_prop.setX_vel(1);
        m_prop.setDuration(30);
        helmet.throw_weapon(this,movingPlatform);
    }
}