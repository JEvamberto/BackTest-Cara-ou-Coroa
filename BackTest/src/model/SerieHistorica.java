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
public class SerieHistorica {
    
    private ArrayList serie;
    private CaraOuCoroa caraCoroa;
    
    public SerieHistorica(int qtdLancamento){
        caraCoroa = new CaraOuCoroa();
        serie = new ArrayList();
        this.gerarSerie(qtdLancamento);
    }
    
    
    private void gerarSerie(int qtdLancamento){
        
        for (int i = 0; i < qtdLancamento; i++) {
            serie.add(caraCoroa.lancarMoeda());
        }
    
    }

    public ArrayList getSerie() {
        return serie;
    }

    
    
    
}
