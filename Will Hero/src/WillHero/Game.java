package WillHero;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends Application implements Serializable {

    @FXML
    private Button newGame,loadGame,viewHighScore,exitGame;

    @FXML
    private AnchorPane WelcomePane;

    @FXML
    private Label labelid,labelscore;

    private Stage stage;

    private Scene currentScene;

    private User user;

    private Platformer platformer;
    private ArrayList<ImageView> islands;

    private ArrayList<Game_Objects> game_objects;
    private ArrayList<Orcs> orcs;

    private int highscore;

    public Game(){
            game_objects=new ArrayList<>();
            platformer=new Platformer();
          islands=new ArrayList<>();
          user=new User(this);
          highscore=0;
          orcs=new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Scene scene=new Scene(root,1337,653);
        stage.setScene(scene);
        stage.setTitle("Will Hero");
        stage.setResizable(true);
        Image icon=new Image("Assets/icon.jpg");
        stage.getIcons().add(icon);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            exitGame(stage);});
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    public void Labelscore(){
        labelscore.setText(highscore+"");
    }
    public void LabelID(){
        labelid.setText(labelid.getText());         // This needs to be changed.
    }


//    public static void serialize()throws IOException{
//        ObjectOutputStream out=null;
//        try{
//            User user_save=
//            out=new ObjectOutputStream(
//                    new FileOutputStream("UserSaves.txt")
//            );
//            out.writeObject(user);
//
//        }
//    }

    public void newGame(ActionEvent e) throws IOException {
        createGame();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("newGame.fxml"));
        loader.setController(user);
        Parent root= loader.load();
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void loadGame(ActionEvent e) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void exitScreen(ActionEvent e){
        Stage stage=(Stage)WelcomePane.getScene().getWindow();
        exitGame(stage);
    }

    public final void createGame(){
        platformer.createIslands();
        islands=platformer.getIslands();
        createCoins();
        createChests();
        createTNT();
        createOrcs();
    }

    public final void createChests(){
        createCoinChest();
        createWeaponChest();
    }

    public ArrayList<ImageView> getPlatform(){
        return islands;
    }


    public int platformCollision(ImageView img){
        Bounds b;
        for(ImageView p: platformer.getIslands()){
            if(img.getBoundsInParent().getMaxY()<0)
                return 0;
            if(img.getBoundsInParent().getMinY()>0&&img.getBoundsInParent().intersects(p.getBoundsInParent())) {
                return 1;
                //Soja Vro
            }
        }
        return 0;
    }

    public ImageView getObj(int i){
        try {
            if (i >= game_objects.size()) {
                return null;
            }
            return game_objects.get(i).display();
        }
        catch(IllegalArgumentException e){
            System.out.println("");
            return null;
        }
    }

    public void if_collision(Hero hero){
        Iterator i=game_objects.iterator();
        while(i.hasNext()) {
            int res = ((Game_Objects)i.next()).if_collides(hero);
            if (res == -1 || res == -11)
                i.remove();
        }
    }

    void createCoins(){
        int i=-106;
        for(int x=300;x<3000;x+=700){
            game_objects.add(new Coins(x,i));
            game_objects.add(new Coins(x+24,i));
            game_objects.add(new Coins(x+24*2,i));
            game_objects.add(new Coins(x+24*3,i));

            game_objects.add(new Coins(x,-140));
            game_objects.add(new Coins(x+24,-140));
            game_objects.add(new Coins(x+24*2,-140));
            game_objects.add(new Coins(x+24*3,-140));
        }
    }
    void createCoinChest(){
        for(int i = 450; i < 2500 ; i = i + 583){
            game_objects.add(new Coin_Chest(i));
        }
    }

    void createWeaponChest(){
        for(int i = 425; i < 1800 ; i = i + 565){
            game_objects.add(new Weapon_Chest(i));
        }
    }
    void createTNT(){
        for(int i = 800; i < 2000 ; i = i + 800){
            game_objects.add(new TNT(i));
        }
    }

    private void createOrcs(){

        for(int i=200;i<3000;i+=350){
            if(i%100==50){
                game_objects.add(new Redorc(i));
            }
            else{
                game_objects.add(new GreenOrc(i));
            }
            orcs.add((Orcs)game_objects.get(game_objects.size()-1));
        }
        game_objects.add(new BossOrc());
    }

    public ArrayList<Orcs> getOrcs() {
        return orcs;
    }

    public void exitGame(Stage stage){
        Alert exitAlert=new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit");
        exitAlert.setContentText("You're about to Exit !!");
        exitAlert.setHeaderText("Are you sure you want to Exit?");
        if(exitAlert.showAndWait().get()== ButtonType.OK){
            System.out.println("You successfully exited");
            stage.close();
        }
    }
    public static void main(String[] args) {
        //new Game(args);
        launch(args);
    }
}


