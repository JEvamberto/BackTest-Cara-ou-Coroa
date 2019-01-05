package model;

/**
 *
 * @author jose
 */
public class Gerenciamento {

    private int banca;
    private String tipoGerenciamento;
    private SerieHistorica serie;
    private String padraoEscolhido;

    public Gerenciamento(int valorBanca) {

        this.banca = valorBanca;

        this.serie = new SerieHistorica(1000);

    }

    public void verificacao() {
        boolean  existe=false;
        int padrao = 111;
        //versão básica
        for (int i = 0; i < this.serie.getSerie().size(); i++) {
            for (int j = 0; j < 3; j++) {
                    
                if ((int) this.serie.getSerie().get(i) == 1) {
                    existe=true;
                    
                } 
                
                if (existe) {
                     this.banca = banca +1;
                    System.out.println("Banca :" + banca);
                    existe=false;
                }
                else {

                    this.banca = banca - 7;
                    System.out.println("Banca :" + banca);
                }

            }
            if (banca <= 0) {
                System.out.println("Banca Quebrada");
                break;
            }
        }

    }
}
