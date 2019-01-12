/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import model.Facade;
import model.Observer;
import view.View;

/**
 *
 * @author jose
 */
public class ControllerView  implements Observer{

    private View view;
    private Facade model;
    private DecimalFormat df = new DecimalFormat("0.00");
    
    public ControllerView(View view, Facade model) {
        this.view=view;
        this.model=model;
        this.model.attach(this);
        
    }

    public void trataEvento(ActionEvent evt) {
        if (evt.getActionCommand()=="Executar") {
            
            this.model.setBanca(Double.parseDouble(this.view.getTxt_Banca().getText()));
            this.model.setQtdLancamento(Integer.parseInt(this.view.getTxt_Lancamento().getText()));
            this.model.getGerencia().IniciarVerificação();
             
            
             
        }
    }

    @Override
    public void update() {
        
    }
    
}
