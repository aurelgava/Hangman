package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameController extends Kontroler{
    private String trazenaRec;
    @FXML
    private Pane canvas;
    @FXML
    private Label imeIgraca;

    @FXML
    private ImageView kost1;
    @FXML
    private ImageView kost2;
    @FXML
    private ImageView kost3;
    @FXML
    private ImageView kost4;
    @FXML
    private ImageView kost5;
    @FXML
    private ImageView kost6;
    @FXML
    private ImageView kost7;
    @FXML
    private ImageView kost8;
    private ImageView[] kosti;
    private int pokusaj;

    public void populate(){
        pokusaj=0;
        this.kosti = new ImageView[8];
        kosti[0]=kost1;
        kosti[1]=kost2;
        kosti[2]=kost3;
        kosti[3]=kost4;
        kosti[4]=kost5;
        kosti[5]=kost6;
        kosti[6]=kost7;
        kosti[7]=kost8;
        for (ImageView k: kosti) {
            k.setVisible(false);
        }
        this.trazenaRec = BazaProxy.nextRec();
        //System.out.println(this.trazenaRec);
        canvas.getChildren().clear();
        for(int i=0; i<this.trazenaRec.length();i++){
            Rectangle rectangle = new Rectangle(50,5);
            rectangle.setFill(Color.AZURE);
            rectangle.setX(50+i*60);
            rectangle.setY(60);
            canvas.getChildren().add(rectangle);
        }
    }

    public void mmKlik(ActionEvent actionEvent) {
        HangmanApplication.postaviScenu(HangmanApplication.SCENE_MAIN_MENU);
    }

    public void slovoTyped(KeyEvent event) {
        boolean pogodio=false;
        System.out.println(event.getCharacter().toUpperCase());
        for(int i=0; i<this.trazenaRec.length();i++){
            if(trazenaRec.toUpperCase().charAt(i)==event.getCharacter().toUpperCase().charAt(0)){
                System.out.println("IMA!!");
                pogodio=true;
                Text pogodjenoSlovo = new Text();
                pogodjenoSlovo.setText(event.getCharacter().toUpperCase());
                pogodjenoSlovo.setX(65+i*60);
                pogodjenoSlovo.setY(50);
                pogodjenoSlovo.setFont(new Font(40));
                pogodjenoSlovo.setFill(Color.GOLD);
                //pogodjenoSlovo.setStyle("-fx-text-inner-color: green; -fx-font-size: 40px;");
                canvas.getChildren().add(pogodjenoSlovo);
            }

        }
        if(!pogodio && pokusaj< kosti.length) kosti[pokusaj++].setVisible(true);
    }
}
