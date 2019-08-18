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

    public Calcoli(int numColonne, int numRighe) {
        this.numColonne = numColonne;
        this.numRighe = numRighe;
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
}
