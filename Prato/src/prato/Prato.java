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
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void settings() {
        size(140, 100 );                                       
    }

    public void setup() {
        noStroke();
        frameRate(60);
    }


     */
    public void draw() {
        background(119, 136, 153);
        for (int i = 0; i < (int) (ptrDati.getAltS() / 150); i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < (int) (ptrDati.getLungS() / 150); ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (ptrDati.getNumColonne() * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                drawBoxPixel(id, ii * 150, i * 150);
                
 
                if((ptrDati.getInclinazioneY()>10) || (ptrDati.getInclinazioneY()<-10)) {                    
                    ptrDati.signalPallina();
                }
                
                
                
                if (array[id].isBallTF()) {
                    drawBall(id);
                }
            }
        }

    }


    public void drawBoxPixel(int id, int colonnaPosX, int rigaPosY) {
        stroke(0, 0, 0);

        rect(colonnaPosX, rigaPosY, array[id].getLungB(), array[id].getAltB());

        if (ptrDati.getInclinazioneY() >= 0) {
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

        }
        stroke(0, 0, 0);
        noFill();
    }


    public void drawBall(int id) {
        fill(color(255, 0, 0));
        stroke(0, 0, 0);
        ellipse(array[id].getBall().getPosX(), array[id].getBall().getPosY(), array[id].getBall().getRaggio(), array[id].getBall().getRaggio());
        noFill();
    }
    
}
