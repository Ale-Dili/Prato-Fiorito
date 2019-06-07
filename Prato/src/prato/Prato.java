/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prato;

import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.*;
/**
 *
 * @author Alessandro
 */
public class Prato extends PApplet{

    /**
     * @param args the command line arguments
     */
    private static int numColonne;
    private static int numRighe;
    
    private static Bombs bombs;

    
    public static void main(String[] args) {
        numColonne=7;
        numRighe=5;
        
        bombs= new Bombs();
        
        PApplet.main(new String[]{"prato.Prato"});
    }
    
    public void settings() {
        size(350, 250);                                       
    }

    public void setup() {
        noStroke();
        frameRate(60);
        for (int i = 0; i < (int) numRighe; i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < (int) numColonne; ii++) {  // ii --> sono colonne (coordinata X)
               
                drawGrid(ii * 50, i * 50);
            }
        }
        
        
    }


     
    public void draw() {
        background(211,211,211);
        
        for (int i = 0; i < (int) (250 / 50); i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < (int) (350 / 50); ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (numColonne * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                //drawBoxPixel(id, ii * 50, i * 50);
            }
        }

    }

   
    public void drawBoxPixel(int id, int colonnaPosX, int rigaPosY) {
        stroke(0, 0, 0);

        rect(colonnaPosX, rigaPosY, 50, 50);
        
        for(int i=0; i< bombs.getnBombs(); i++){
            int idT = bombs.getIdBomb(i);
            
        }

        /*if (ptrDati.getInclinazioneY() >= 0) {
            colonnaPosX = colonnaPosX + array[id].getLungB() - 2;
            for (int i = 0; i < array[id].valueSandPixel(); i++) {
                noStroke();
                fill(color(202, 188, 145));
                rect(colonnaPosX, rigaPosY, 1, array[id].getAltB());
                colonnaPosX--;

            }
        }
        if (ptrDati.getInclinazioneY() < 0) {
            for (int i = 0; i < array[id].valueSandPixel(); i++) {
                noStroke();
                fill(color(202, 188, 145));
                rect(colonnaPosX, rigaPosY, 1, array[id].getAltB());
                colonnaPosX++;
            }

        }*/
        stroke(0, 0, 0);
        noFill();
    }
    
    public void drawGrid(int colonnaPosX, int rigaPosY){
        stroke(0, 0, 0);

        rect(colonnaPosX, rigaPosY, 50, 50);
        
    }

/*
    public void drawBall(int id) {
        fill(color(255, 0, 0));
        stroke(0, 0, 0);
        ellipse(array[id].getBall().getPosX(), array[id].getBall().getPosY(), array[id].getBall().getRaggio(), array[id].getBall().getRaggio());
        noFill();
    }
    */
}
