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

    private static Calcoli calcoli;

    private static BoxState boxState;

    public static void main(String[] args) {
        numColonne = 9;
        numRighe = 6;

        bombs = new Bombs(numColonne, numRighe);
        calcoli = new Calcoli(numColonne, numRighe);
        boxState = new BoxState(numColonne, numRighe);

        PApplet.main(new String[]{"prato.Prato"});
    }

    public void settings() {
        size(numColonne * 50, numRighe * 50);
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

    //evento mouse click
    public void mousePressed() {
        int colonna = mouseX;
        int riga = mouseY;

        colonna = colonna / 50 + 1;
        riga = riga / 50 + 1;

        int id = (riga - 1) * numColonne + colonna;

        System.out.println(mouseX + ", " + mouseY);
        System.out.println("strokes: " + id);

        if (mouseButton == LEFT) {
            stroke(colonna, riga);
            check(id);
        }

        if (mouseButton == RIGHT) {

            mark(colonna, riga, id);
        }

        //  clean();
    }

    //metodo che scava nella cella selezionata
    public void stroke(int colonna, int riga) {
        fill(158, 89, 3);
        stroke(0, 0, 0);
        rect((colonna - 1) * 50, (riga - 1) * 50, 50, 50);
    }

    public void mark(int colonna, int riga, int id) {
        //se e' true vuol dire che e' rossa
        if (boxState.isBoxId(id)) {
            
            fill(211, 211, 211);
            stroke(0, 0, 0);
            rect((colonna - 1) * 50, (riga - 1) * 50, 50, 50);
            boxState.setFalse(id);
            
        } else {
            
            fill(255, 0, 0);
            stroke(0, 0, 0);
            rect((colonna - 1) * 50, (riga - 1) * 50, 50, 50);
            boxState.setTrue(id);
            
        }
    }

    //controlla se nella cella premuta ce una bomba
    public void checkBomb(int id) {
        for (int i = 0; i < bombs.getnBombs(); i++) {
            if (id == bombs.getIdBomb(i)) {
                //stop();
                textSize(35);
                fill(0, 102, 153);

                text("HAI PERSO SFIGATO!", 5, 130);

            }

        }
    }

    //controlla la cella e attorno a lei
    public void check(int id) {
        checkBomb(id);

        int cont = 0;

        for (int i = 0; i < bombs.getnBombs(); i++) {
            if (checkSx(id, i)) {
                cont++;
            }
            if (checkDx(id, i)) {
                cont++;
            }

            cont += checkUp(id, i);

            cont += checkDown(id, i);
        }
        textSize(30);
        fill(0, 102, 153);
        text(Integer.toString(cont), calcoli.calcColonna(calcoli.calcRiga(id), id) * 50 - 33, calcoli.calcRiga(id) * 50 - 12);
    }

    //--------------------------------------CONTROLLO BOMBE------------------------
    public boolean checkSx(int id, int i) {

        if ((id - 1) % numColonne != 0) {
            if ((id - 1) == bombs.getIdBomb(i)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean checkDx(int id, int i) {
        if ((id) % numColonne != 0) {
            if ((id + 1) == bombs.getIdBomb(i)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public int checkUp(int id, int i) {

        int riga = calcoli.calcRiga(id);
        int colonna = calcoli.calcColonna(riga, id);
        int bombCounter = 0;

        if (riga == 1) {
            return 0;
        } else if (colonna == 1) {

            if (id - numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id - numColonne + 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        } else if (colonna == numColonne) {

            if (id - numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id - numColonne - 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        } else {

            if (id - numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id - numColonne - 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id - numColonne + 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        }

        return bombCounter;
    }

    public int checkDown(int id, int i) {

        int riga = calcoli.calcRiga(id);
        int colonna = calcoli.calcColonna(riga, id);
        int bombCounter = 0;

        if (riga == numRighe) {
            return 0;
        } else if (colonna == 1) {

            if (id + numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id + numColonne + 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        } else if (colonna == numColonne) {

            if (id + numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id + numColonne - 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        } else {

            if (id + numColonne == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id + numColonne - 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

            if (id + numColonne + 1 == bombs.getIdBomb(i)) {
                bombCounter++;
            }

        }

        return bombCounter;
    }
    //-------------------------------------------------------------------------------

}
