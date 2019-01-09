package model;

/**
 *
 * @author jose
 */
public class Gerenciamento implements Runnable {

    private int banca;
    private String tipoGerenciamento;
    private SerieHistorica serie;
    private String padraoEscolhido;
    private int bancaMaxima;
    private int bancaMinima;
    private Facade facade;
    private int countVitorias=0;
    private int countPerdas=0;
    private Thread t ;
  
    Gerenciamento(Facade facade) {
       this.facade=facade;
      
    }

    
   public void IniciarVerificação(){
        t= new Thread(this);
       this.t.start();
   }
    
    public void verificacao() {
        boolean  existe=false;
        int padrao = 111;
        //versão básica
        int count=0;
       
        for (int i = 0; i < this.serie.getSerie().size(); i++) {
           
            if (count<3) {
                
                 //System.out.print(this.serie.getSerie().get(i));
                    
                if ((int) this.serie.getSerie().get(i) == 1) {
                    existe=true;
                    
                }
            
                
                count++;
            }
          
            
            if (count==2) {
                if (existe) {
                     this.banca = banca +1;
                     this.setBanca(banca);
                      // System.out.println("");
                    //System.out.println("Banca :" + banca+" ganhou 1");
                    existe=false;
                    countVitorias++;
                }
                else {

                    this.banca = banca - 7;
                    this.setBanca(banca);
                     //System.out.println("");
                    //System.out.println("Banca :" + banca+" perdeu 7");
                    countPerdas++;
                }

            }
            
           
                
                
                
            
            
            if (count ==3) {
                count=0;
            }
            if (banca <= 0) {
                System.out.println("Banca Quebrada");
                break;
            }
        }
        
       // System.out.println("Quantidade de vitórias:"+countVitorias+"\nQuantida de perdas:"+countPerdas);
        //System.out.println("Banca atual:"+banca);

    }

    public int getCountVitorias() {
        return countVitorias;
    }

    public void setCountVitorias(int countVitorias) {
        this.countVitorias = countVitorias;
        this.facade.notifyall();
    }

    public int getCountPerdas() {
        return countPerdas;
    }

    public void setCountPerdas(int countPerdas) {
        this.countPerdas = countPerdas;
        this.facade.notifyall();
    }
    
    

    public int getBanca() {
        return banca;
    }

    public void setBanca(int banca) {
        this.banca = banca;
        this.facade.notifyall();
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
    
    
    
    
    
}



