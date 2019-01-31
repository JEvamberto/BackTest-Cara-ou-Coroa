package model;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Gerenciamento implements Runnable {

    private double bancaTotal;
      private ArrayList <Observer> observer = new ArrayList<>();
    private String tipoGerenciamento;
    private SerieHistorica serie;
    private String padraoEscolhido;
    private int bancaMaxima;
    private int bancaMinima;
    
    private int countVitorias=0 ;
    private int countPerdas=0 ;
    private Thread t;
    private boolean resultado=true;
    
    public void setResultado(boolean resultado){
        this.resultado=resultado;
        
        this.notifyall();
    }
    public boolean getResultado(){
        return this.resultado;
    }

    
     public void attach(Observer observer){
        
        this.observer.add(observer);
    }
    
    public void dettach(Observer observer){
        
        this.observer.remove(observer);
    }
    
    

    public void IniciarVerificação() {
        t = new Thread(this);
        this.t.start();
    }
    
    public void notifyall(){
        
        for (Observer observer1 : this.observer) {
            observer1.update();
        }
    
    }
    
    public void verificacao() {
        /*Banca 1 padrão 111 e Banca 2 padrão 000*/
        boolean existe = false;
        int padrao = 111;
        int valor = 0;
        boolean sabe = false;
        boolean isBanca = false;
        boolean isPerda = false;
        // false é a banca com padrao 000 e true é a banca com padrão 111
        //versão básica
        int count = 0;

        for (int i = 0; i < this.serie.getSerie().size(); i++) {

            if (count < 3) {
                //System.out.println("count:"+count);
                //System.out.print(this.serie.getSerie().get(i));
                if (count == 0) {

                    if ((int) this.serie.getSerie().get(i) == 1) {

                        this.bancaTotal = this.bancaTotal + 1;
                       

                        this.setBanca(bancaTotal);
                       
                        this.setCountVitorias();
                    } else {

                        this.bancaTotal = this.bancaTotal - 1;
                        this.setBanca(bancaTotal);
                        
                        this.setCountPerdas();
                        isPerda = true;

                    }

                }
                /*if ((int) this.serie.getSerie().get(i) == 1) {
                    existe = true;
                    
                }*/

                if (count == 1 && (isPerda == true)) {
                    isPerda = false;
                    if ((int) this.serie.getSerie().get(i) == 1) {

                        this.bancaTotal = this.bancaTotal + 2;
                        this.setBanca(bancaTotal);
                        
                        this.setCountVitorias();

                    } else {

                        this.bancaTotal = this.bancaTotal - 2;
                        this.setBanca(bancaTotal);
                        
                       
                        this.setCountPerdas();
                        sabe = true;

                    }

                    ///AQui
                }

                if (count == 2 && (sabe == true)) {
                    sabe = false;

                    if ((int) this.serie.getSerie().get(i) == 1) {

                        this.bancaTotal = this.bancaTotal + 4;
                       
                        this.setCountVitorias();
                        this.setBanca(bancaTotal);

                    } else {

                        this.bancaTotal = this.bancaTotal - 4;
                        this.setBanca(bancaTotal);
                      
                        this.setCountPerdas();
                      

                    }

                }

                count++;
            }

            /* if (count == 2) {
                if (existe) {
                    this.bancaTotal = bancaTotal + 2;
                    this.setBanca(bancaTotal);
                    // System.out.println("");
                    //System.out.println("Banca :" + bancaTotal+" ganhou 1");
                    existe = false;
                    countVitorias++;
                } else {
                    
                    this.bancaTotal = bancaTotal - 6;
                    this.setBanca(bancaTotal);
                    //System.out.println("");
                    //System.out.println("Banca :" + bancaTotal+" perdeu 7");
                    countPerdas++;
                }
                
            
            }*/
            if (count == 3) {

                count = 0;
            }
            if (bancaTotal <= 0) {
                
                this.setResultado(false);
                
                break;
                
            }
        }
        this.countPerdas = 0;
        this.countVitorias = 0;
        // System.out.println("Quantidade de vitórias:"+countVitorias+"\nQuantida de perdas:"+countPerdas);
        //System.out.println("Banca atual:"+bancaTotal);

    }

    public int getCountVitorias() {
        return countVitorias;
    }

    public void setCountVitorias() {
        this.countVitorias++;
        this.notifyall();
    }

    public int getCountPerdas() {
        return countPerdas;
    }

    public void setCountPerdas() {
        this.countPerdas++;
        this.notifyall();
    }

    public double getBanca() {
        return bancaTotal;
    }

    public void setBanca(double banca) {
        this.bancaTotal = banca;
        this.notifyall();
    }

    public String getTipoGerenciamento() {
        return tipoGerenciamento;
    }

    public void setTipoGerenciamento(String tipoGerenciamento) {
        this.tipoGerenciamento = tipoGerenciamento;
    }

    public SerieHistorica getSerie() {
        return serie;
    }

    public void setSerie(SerieHistorica serie) {
        this.serie = serie;
    }

    public String getPadraoEscolhido() {
        return padraoEscolhido;
    }

    public void setPadraoEscolhido(String padraoEscolhido) {
        this.padraoEscolhido = padraoEscolhido;
    }

    public int getBancaMaxima() {
        return bancaMaxima;
    }

    public void setBancaMaxima(int bancaMaxima) {
        this.bancaMaxima = bancaMaxima;
    }

    public int getBancaMinima() {
        return bancaMinima;
    }

    public void setBancaMinima(int bancaMinima) {
        this.bancaMinima = bancaMinima;
    }

    @Override
    public void run() {
        this.verificacao();
    }
    
    
   
   public void setQtdLancamento(int qtdLancamento){
       this.setSerie(new SerieHistorica(qtdLancamento));
   }
   
    public Gerenciamento getGerencia() {
        return this;
    }

}
