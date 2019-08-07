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
public class Prato extends PApplet {

    /**
     * @param args the command line arguments
     */
    private static int numColonne;
    private static int numRighe;

    private static Bombs bombs;

    public static void main(String[] args) {
        numColonne = 7;
        numRighe = 5;

        bombs = new Bombs(numColonne, numRighe);

        PApplet.main(new String[]{"prato.Prato"});
    }

    public void settings() {
        size(numColonne*50, numRighe*50);
    }

    public void setup() {
        background(211, 211, 211);
        noStroke();
        frameRate(60);
        for (int i = 0; i < numRighe; i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < numColonne; ii++) {  // ii --> sono colonne (coordinata X)

                drawGrid(ii * 50, i * 50);
            }
        }

    }

    public void draw() {
        //background(211, 211, 211);

        /*  for (int i = 0; i < numRighe; i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < numColonne; ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (numColonne * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                //drawBoxPixel(id, ii * 50, i * 50);
            }
        }*/
    }

    public void drawBoxPixel(int id, int colonnaPosX, int rigaPosY) {
        stroke(0, 0, 0);

        rect(colonnaPosX, rigaPosY, 50, 50);

        for (int i = 0; i < bombs.getnBombs(); i++) {
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
        //stroke(0, 0, 0);
        noFill();
    }

    public void drawGrid(int colonnaPosX, int rigaPosY) {
        noFill();
        stroke(0, 0, 0);
        rect(colonnaPosX, rigaPosY, 50, 50);

    }

    public void mouseClicked() {
        int colonna = mouseX;
        int riga = mouseY;

        colonna = colonna / 50 + 1;
        riga = riga / 50 + 1;

        int id = (riga - 1) * numColonne + colonna;

        System.out.println(mouseX + ", " + mouseY);
        System.out.println("strokes: " + id);

        stroke(colonna, riga);

        checkBomb(id);
        
        clean(id);
    }

    public void stroke(int colonna, int riga) {
        fill(158, 89, 3);
        stroke(0, 0, 0);
        rect((colonna - 1) * 50, (riga - 1) * 50, 50, 50);
    }

    public void checkBomb(int id) {
        for (int i = 0; i < bombs.getnBombs(); i++) {
            if (id == bombs.getIdBomb(i)) {
                stop();
                textSize(35);
                fill(0, 102, 153);

                text("HAI PERSO SFIGATO!", 5, 125);
                fill(0, 102, 153);
            }

        }
    }
    
    public void clean(int id){
        for (int i = 0; i < bombs.getnBombs(); i++) {
            if(((id-1)!=bombs.getIdBomb(i))&&((id+1)!=bombs.getIdBomb(i))){   //controlla che a destra e a sinistra non ci siano bombe
               if(((id-numColonne)!=bombs.getIdBomb(i))&&((id-numColonne-1)!=bombs.getIdBomb(i))&&((id-numColonne+1)!=bombs.getIdBomb(i))){ //controlla che i 3 quadrati sopra sono privi di bombe
                   if(((id+numColonne)!=bombs.getIdBomb(i))&&((id+numColonne-1)!=bombs.getIdBomb(i))&&((id+numColonne+1)!=bombs.getIdBomb(i))){
                       
                   }
               } 
            }
        }
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
