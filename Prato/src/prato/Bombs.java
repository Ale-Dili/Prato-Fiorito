/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prato;

import java.util.*;

/**
 *
 * @author Alessandro
 */
public class Bombs {

    private Bomb[] bombs;

    private int nBombs;
    
    //numero colonne della griglia
    private int numColonne;
    
    //numero righe della griglia
    private int numRighe;

    public Bombs(int numColonne, int numRighe) {
        this.nBombs = 7;
        this.numColonne=numColonne;
        this.numRighe=numRighe;
        
        
        bombs = new Bomb[nBombs];
        
        for (int i = 0; i < nBombs; i++) {
            bombs[i]= new Bomb();
        }
        setBombs();
    }

    public void setBombs() {

        int id;

        for (int i = 0; i < nBombs; i++) {

            id = (int) ((Math.random() *(numRighe*numColonne) ) + 1);  //numero righe*colonne

            for (int j = 0; j < nBombs; j++) {
                if (id != bombs[j].getId()) {
                } else {
                    id = (int) ((Math.random() * nBombs) + 1);
                    j = 0;
                }
            }
            System.out.println(id);
            bombs[i].setId(id);
        }
    }

    public Bomb[] getBombs() {
        return bombs;
    }

    public int getnBombs() {
        return nBombs;
    }

    public void setBombs(Bomb[] bombs) {
        this.bombs = bombs;
    }

    public void setnBombs(int nBombs) {
        this.nBombs = nBombs;
    }
    
    public int  getIdBomb(int i){
        return bombs[i].getId();
    }
    
    

}
