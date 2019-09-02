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
public class BoxState {
    private int numColonne; 
    private int numRighe;
    private int box[];
    
    /* --------------------------------------
        0= casella non premuta
        1= casella rossa
        2= casella premuta
        3= casella esplosa
    ------------------------------------------*/

    public BoxState(int numColonne, int numRighe) {
        this.numColonne = numColonne;
        this.numRighe = numRighe;
        box = new int [numColonne*numRighe]; 
        for(int i=0; i < numColonne * numRighe; i++){
            box[i]=0;
        }
    }
    
    public void setBox(int id, int n){
        box[id-1]=n;
    }
        
    public int getBoxState(int id){
        return box[id-1];
    }
    
    
}
