/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Facade;
import view.View;

/**
 *
 * @author jose
 */
public class ControllerView {

    private View view;
    private Facade model;
    
    public ControllerView(View view, Facade model) {
        this.view=view;
        this.model=model;
        
    }
    
}
