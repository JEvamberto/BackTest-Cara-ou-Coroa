package model;

/**
 *
 * @author jose
 */
public class Gerenciamento implements Runnable {
    
    private double bancaTotal;
    private double banca1;
    private double banca2;
   
    private String tipoGerenciamento;
    private SerieHistorica serie;
    private String padraoEscolhido;
    private int bancaMaxima;
    private int bancaMinima;
    private Facade facade;
    private int countVitorias = 0;
    private int countPerdas = 0;
    private Thread t;

    Gerenciamento(Facade facade) {
        this.facade = facade;

    }

    public void IniciarVerificação() {
        t = new Thread(this);
        this.t.start();
    }

    public void verificacao() {
        boolean existe = false;
        int padrao = 111;
        int valor = 0;
        boolean sabe = false;
        //versão básica
        int count = 0;

        for (int i = 0; i < this.serie.getSerie().size(); i++) {
            sabe = false;
            if (count < 3) {
                //System.out.println("count:"+count);
                //System.out.print(this.serie.getSerie().get(i));
                if (count == 0) {

                    if ((int) this.serie.getSerie().get(i) == 1 /*|| (int) this.serie.getSerie().get(i) == 0*/) {

                        this.bancaTotal = bancaTotal + 1;
                        this.setBanca(bancaTotal);
                        //this.bancaTotal = bancaTotal - 1;
                       // this.setBanca(bancaTotal);
                    

                        if ((int) this.serie.getSerie().get(i) == 1) {
                            valor = 0;
                        } else {
                            valor = 1;
                        }

                    }else{
                        this.bancaTotal=bancaTotal-1;
                        this.setBanca(bancaTotal);
                           existe=true;
                    }

                }
                /*if ((int) this.serie.getSerie().get(i) == 1) {
                    existe = true;
                    
                }*/

                if (count == 1&& existe == true) {

                    if ((int) this.serie.getSerie().get(i) == 1) {

                        this.bancaTotal = bancaTotal + 2;
                        this.setBanca(bancaTotal);
                        sabe = true;
                        countVitorias++;

                    } else {
                        this.bancaTotal = bancaTotal - 2;
                        this.setBanca(bancaTotal);
                        sabe = false;

                    }

                }

                if (count == 2 && (sabe == false)) {

                    if ((int) this.serie.getSerie().get(i) == 1) {

                        this.bancaTotal = bancaTotal + 4;
                        this.setBanca(bancaTotal);
                        countVitorias++;

                    } else {
                        this.bancaTotal = bancaTotal - 4;
                        this.setBanca(bancaTotal);
                        countPerdas++;

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
                System.out.println("Banca Quebrada");
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

    public double getBanca() {
        return bancaTotal;
    }

    public void setBanca(double banca) {
        this.bancaTotal = banca;
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
