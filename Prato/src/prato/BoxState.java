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
    private boolean box[];

    public BoxState(int numColonne, int numRighe) {
        this.numColonne = numColonne;
        this.numRighe = numRighe;
        box = new boolean [numColonne*numRighe]; 
        for(int i=0; i < numColonne * numRighe; i++){
            box[i]=false;
        }
    }
    
    public void setTrue(int id){
        box[id-1]=true;
    }
    
    public void setFalse(int id){
        box[id-1]=false;
    }
    
    public boolean isBoxId(int id){
        return box[id-1];
    }
    
    
}
