/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jose
 */
public class CaraOuCoroa {
    
    private final int CARA =0;
    private final int COROA =1;
    
    public int lançarMoeda(){
        
        if (Math.random()>0.5) {
            return COROA;
        }else if (Math.random()<=0.5){
        
            return CARA;
        }
        
        
        return -1;
        
        
    }
    
}
