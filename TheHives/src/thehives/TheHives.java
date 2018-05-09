/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehives;
import vue.InterfacePlateau;
import vue.InterfaceMenu;
import vue.InterfaceJoueurs;
import java.awt.Dimension;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 *
 * @author Adeline
 */
public class TheHives extends Application {

    public int HEIGHT = 600;
    public int WIDTH = 800;
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    //int HEIGHT = (int) dimension.getHeight();
    //int WIDTH  = (int)dimension.getWidth();
    Group root;
    Scene scene;
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        //scene = new Scene(root, WIDTH, HEIGHT, Color.LIGHTBLUE);
        this.primaryStage = primaryStage;
        //goToPlateau("Joueur1", "Joueur2");
        goToMenu();
        
        
        //PLEIN ECRAN
        //primaryStage.setFullScreen(true); //passer en affichage plein écran
        //primaryStage.setFullScreenExitHint("Sortie de plein écran - esc"); //changer le message qui s'affiche après le passage en mode plein écran
        //root.setCursor(Cursor.CROSSHAIR); //changer l'apparence du curseur de souris

        primaryStage.setTitle("The Hive");
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(TheHives.class, args);
    }

    public void goToMenu() {
        this.scene = new Scene(new InterfaceMenu(HEIGHT, WIDTH, primaryStage, this), WIDTH, HEIGHT, Color.LIGHTBLUE);
        changeScene();

    }

    public void goToChoixJoueur() {

        this.scene = new Scene(new InterfaceJoueurs(HEIGHT, WIDTH, primaryStage, this), WIDTH, HEIGHT, Color.LIGHTBLUE);
        changeScene();
    }
    
    public void goToPlateau(String nomJoueur1, String nomJoueur2){
        this.scene = new Scene(new InterfacePlateau(this, primaryStage, nomJoueur1, nomJoueur2), 800, 600, Color.LIGHTBLUE);
        changeScene();

    }

    public void changeScene() {
//        Image souris = new Image(getClass().getResourceAsStream("vue/images/souris.png"));
//        ImageCursor sourisIm = new ImageCursor(souris, souris.getWidth() / 2, souris.getHeight() / 2);
//        this.scene.setCursor(sourisIm);
        primaryStage.setScene(scene);
    }
}