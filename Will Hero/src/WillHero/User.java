package WillHero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class User {

    @FXML
    private Label greeting;

    @FXML
    private TextField name;

    @FXML
    private Button inputName,startGame,backButton;

    @FXML
    private AnchorPane newGamePane;

    private Label onScreen_score;


    private int score;
    private Game game;

    public User(Game game){
        this.game=game;
    }

    public boolean if_highscore(){
        return true;
    }
    public void resume(){

    }
    public void pause(){

    }
    public void save(){
        //Serializable
    }
    public void load(){
        //Serializable
    }
    public void getScore(){

    }
    public void setScore(int score){
        if(score>game.getHighscore())
            game.setHighscore(score);
        this.score=score;
    }
    public void end_game(){

    }
    public void resurrect(){

    }

    public void addIsland(AnchorPane movingPane){
        ArrayList<ImageView> islands=game.getPlatform();
        for(ImageView isl:islands) {
            System.out.println(isl.getBoundsInParent());
            movingPane.getChildren().add(isl);
        }
    }
    public void addObjects(AnchorPane movingPane){

        try {
            int i = 0;
            while (game.getObj(i) != null) {
                movingPane.getChildren().add(game.getObj(i++));
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Error");
        }
    }

    public void back(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void inputName(ActionEvent e)throws IOException{
        greeting.setText("Hii "+name.getText()+"!! Now press Start to start the game");
    }

    public void startGame(ActionEvent e)throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScene.fxml"));
        Hero controller =new Hero(this,game);
        loader.setController(controller);
        Parent root=loader.load();
        Scene scene=new Scene(root);

        game.setCurrentScene(scene);
        tap(loader,e);
    }

    public void tap(FXMLLoader loader,ActionEvent e){
        Scene scene=game.getCurrentScene();
        Hero controller=loader.getController();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.D)
                {
                    controller.getHeroAnimation().pause();
                    if(controller.checkCollision()==false)
                        controller.move(100);
                    controller.getHeroAnimation().play();
                }

            }
        });
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);

    }

}
