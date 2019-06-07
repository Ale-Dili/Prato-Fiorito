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
public class Bomb {
    
    private int id;  //indica su quale griglia si trova
    
    private boolean tF;  //indica se e' esplosa o no;

    public Bomb() {
        this.tF = false;
        this.id = -1;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void settF(boolean tF) {
        this.tF = tF;
    }

    public int getId() {
        return id;
    }

    public boolean istF() {
        return tF;
    }
    
    
    
    
    
    
    
    
    
    
    
}
