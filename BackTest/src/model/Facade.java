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
    private Gerenciamento gerencia= new Gerenciamento();
}
