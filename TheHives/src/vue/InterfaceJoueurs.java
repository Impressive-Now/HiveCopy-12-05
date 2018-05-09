/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import thehives.TheHives;

/**
 *
 * @author Adeline
 */
public class InterfaceJoueurs extends Parent{
    
    public InterfaceJoueurs(int height, int width, Stage primaryStage, TheHives i) {
        
        DropShadow shadow = new DropShadow();
        int tailleDeCase = width/8;
        
        
        InterfaceUtiles u = new InterfaceUtiles(height, width, primaryStage, i);
        this.getChildren().add(u);
        
        
        Group J1 =new Group();
        Label joueur1 = new Label("Joueur 1");
        joueur1.setFont(new Font("Arial", tailleDeCase/8));
        joueur1.setAlignment(Pos.CENTER);
        joueur1.setMinSize(width/10, 30);
        joueur1.setLayoutX(width/2-width/20);
        joueur1.setLayoutY(height/6);
        this.getChildren().add(joueur1);
        final ToggleGroup j1 = new ToggleGroup();
        ToggleButton humain1 = new RadioButton("Humain");
        humain1.setFont(new Font("Arial", tailleDeCase/9));
        humain1.setLayoutX(width/2-width/4);
        humain1.setLayoutY(height/4);
        humain1.setToggleGroup(j1);
        ToggleButton IA1 = new RadioButton("IA");
        IA1.setFont(new Font("Arial", tailleDeCase/9));
        IA1.setLayoutX(width/2+width/4);
        IA1.setLayoutY(height/4);
        IA1.setToggleGroup(j1);
        
        TextField Name1 = new TextField("Votre prénom");
        final ToggleGroup ia1 = new ToggleGroup();
        String versionIA1 = new String();
        j1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
                if (j1.getSelectedToggle() != null) {
                    if(humain1.isSelected()){
                        Name1.setLayoutX(width/2-width/20);
                        Name1.setLayoutY(height/3); 
                        Name1.setMinSize(width/10, 30);
                        Name1.setAlignment(Pos.CENTER);
                        J1.getChildren().add(Name1); 
                    }
                    else if(IA1.isSelected()){
                        ToggleButton facile = new RadioButton("Facile");
                        facile.setFont(new Font("Arial", tailleDeCase/9));
                        facile.setLayoutX(width/2-width/4);
                        facile.setLayoutY(height/3);
                        facile.setToggleGroup(ia1);
                        ToggleButton moyenne = new RadioButton("Moyenne");
                        moyenne.setFont(new Font("Arial", tailleDeCase/9));
                        moyenne.setLayoutX(width/2);
                        moyenne.setLayoutY(height/3);
                        moyenne.setToggleGroup(ia1);
                        ToggleButton difficile = new RadioButton("Difficile");
                        difficile.setFont(new Font("Arial", tailleDeCase/9));
                        difficile.setLayoutX(width/2+width/4);
                        difficile.setLayoutY(height/3);
                        difficile.setToggleGroup(ia1);
                        ia1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                                public void changed(ObservableValue<? extends Toggle> ov,
                                    Toggle old_toggle, Toggle new_toggle) {
                                    if (ia1.getSelectedToggle() != null) {
                                        String versionIA1 = ia1.getSelectedToggle().getUserData().toString();
                                        System.out.println("IA1 : " + versionIA1);
                                    }
                                }
                            });
                        J1.getChildren().add(facile); 
                        J1.getChildren().add(moyenne); 
                        J1.getChildren().add(difficile); 
                    }
                }
            }
        });
        
        J1.getChildren().add(humain1);
        J1.getChildren().add(IA1);
        this.getChildren().add(J1);
        
        Group J2 =new Group();
        Label joueur2 = new Label("Joueur 2");
        joueur2.setFont(new Font("Arial", tailleDeCase/8));
        joueur2.setAlignment(Pos.CENTER);
        joueur2.setMinSize(width/10, 30);
        joueur2.setLayoutX(width/2-width/20);
        joueur2.setLayoutY(height/2);
        this.getChildren().add(joueur2);
        final ToggleGroup j2 = new ToggleGroup();
        RadioButton humain2 = new RadioButton("Humain");
        humain2.setUserData("Humain");
        humain2.setFont(new Font("Arial", tailleDeCase/9));
        humain2.setLayoutX(width/2-width/4);
        humain2.setLayoutY(height/1.5);
        humain2.setToggleGroup(j2);
        RadioButton IA2 = new RadioButton("IA");
        humain2.setUserData("IA2");
        IA2.setFont(new Font("Arial", tailleDeCase/9));
        IA2.setLayoutX(width/2+width/4);
        IA2.setLayoutY(height/1.5);
        IA2.setToggleGroup(j2);
        TextField Name2 = new TextField("Votre prénom");
        final ToggleGroup ia2 = new ToggleGroup();
        String versionIA2 = new String();
        j2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
                if (j2.getSelectedToggle() != null) {
                    if(humain2.isSelected()){
                        
                        Name2.setLayoutX(width/2-width/20);
                        Name2.setLayoutY(height/1.2); 
                        Name2.setMinSize(width/10, 30);
                        Name2.setAlignment(Pos.CENTER);
                        J2.getChildren().add(Name2); 
                    }
                    else if(IA2.isSelected()){
                        RadioButton facile = new RadioButton("Facile");
                        facile.setUserData("facile");
                        facile.setFont(new Font("Arial", tailleDeCase/9));
                        facile.setLayoutX(width/2-width/4);
                        facile.setLayoutY(height/1.2);
                        facile.setToggleGroup(ia2);
                        RadioButton moyenne = new RadioButton("Moyenne");
                        moyenne.setUserData("moyenne");
                        moyenne.setFont(new Font("Arial", tailleDeCase/9));
                        moyenne.setLayoutX(width/2);
                        moyenne.setLayoutY(height/1.2);
                        moyenne.setToggleGroup(ia2);
                        RadioButton difficile = new RadioButton("Difficile");
                        difficile.setUserData("difficile");
                        difficile.setFont(new Font("Arial", tailleDeCase/9));
                        difficile.setLayoutX(width/2+width/4);
                        difficile.setLayoutY(height/1.2);
                        difficile.setToggleGroup(ia2);
                        ia2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                                public void changed(ObservableValue<? extends Toggle> ov,
                                    Toggle old_toggle, Toggle new_toggle) {
                                    if (ia2.getSelectedToggle() != null) {
                                        String versionIA2 = ia2.getSelectedToggle().getUserData().toString();
                                        System.out.println("IA2 : " + versionIA2);
                                    }
                                }
                            });
                        J2.getChildren().add(facile); 
                        J2.getChildren().add(moyenne); 
                        J2.getChildren().add(difficile); 
                    }
                }
            }
        });
        
        J2.getChildren().add(humain2);
        J2.getChildren().add(IA2);
        this.getChildren().add(J2);
        
        
        
        //DropShadow shadow = new DropShadow();
        Button valider = new Button("Valider");
        valider.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            valider.setEffect(shadow);
        });
        valider.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            valider.setEffect(null);
        });
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
           
            System.out.println("Enregistrer ! ");
            System.out.println("Name1 : " + Name1.getCharacters());
            System.out.println("IA : " + versionIA1);
            System.out.println("Name2 : " + Name2.getCharacters());
            System.out.println("IA : " + versionIA2);                        
            
            
            //i.taille_plateau(Name1.getCharacters(), Name2.getCharacters());
            i.goToPlateau(Name1.getCharacters().toString(), Name2.getCharacters().toString());
        });
        valider.setLayoutX(width/2-width/20);
        valider.setLayoutY(height/2+90);
        valider.setMinSize(width/10, 30);
        this.getChildren().add(valider);
        
    }

}
