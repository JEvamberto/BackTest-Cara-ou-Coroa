/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Facade {
    
    private ArrayList <Observer> observer = new ArrayList<>();
    private Gerenciamento gerencia;
    
    
    public Facade(){
    
    this.gerencia= new Gerenciamento(this);
    }
    public void attach(Observer observer){
        
        this.observer.add(observer);
    }
    
    public void dettach(Observer observer){
        
        this.observer.remove(observer);
    }
    
    public void notifyall(){
        
        for (Observer observer1 : this.observer) {
            observer1.update();
        }
    
    }

    public Gerenciamento getGerencia() {
        return gerencia;
    }

   public void setBanca(double banca){
       
       this.gerencia.setBanca(banca);
       this.notifyall();
   }
   
   public void setQtdLancamento(int qtdLancamento){
       this.gerencia.setSerie(new SerieHistorica(qtdLancamento));
   }
   
   
    
        
    
}
