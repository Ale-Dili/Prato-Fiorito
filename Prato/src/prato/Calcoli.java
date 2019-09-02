/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prato;

/**
 *
 * @author Alessandro
 */
public class Calcoli {

    private int numColonne;
    private int numRighe;
    private Bombs bombs;

    public Calcoli(int numColonne, int numRighe, Bombs bombs) {
        this.numColonne = numColonne;
        this.numRighe = numRighe;
        this.bombs = bombs;
    }

    public int calcColonna(int riga, int id) {
        if ((id - (riga - 1) * numColonne) == 0) {
            return ((id - (riga - 1) * numColonne)) - 1;
        } else {
            return ((id - (riga - 1) * numColonne));
        }
        //return ((id-(riga-1)*numColonne))+1;
    }

    public int calcRiga(int id) {
        if (id % numColonne == 0) {
            return (id / numColonne);
        } else {
            return (id / numColonne) + 1;
        }
    }

    public int calcId(int riga, int colonna) {
        return (riga - 1) * numColonne + colonna;
    }
    
    //===================CONTROLLO CASELLE===================
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

        int riga = calcRiga(id);
        int colonna = calcColonna(riga, id);
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

        int riga = calcRiga(id);
        int colonna = calcColonna(riga, id);
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
    
    public int checkAll(int id){
        int cont=0;
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
        return cont;
    }
}
