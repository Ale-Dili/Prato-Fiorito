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
public class Bombs {
    
    private Bomb[] bombs;
    
    private int nBombs;

    public Bombs() {
        this.nBombs = 6;       
        initBombs();
        
    }
    
    public void initBombs(){
        for(int i=0; i<nBombs; i++){
            
            int id=5; //metodo random che genera posizione
            bombs[i]= new Bomb(id);
        }
    }


    
    
    
}
