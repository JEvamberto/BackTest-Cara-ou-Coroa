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

        this.serie = new SerieHistorica(1000000);

    }

    public void verificacao() {
        boolean  existe=false;
        int padrao = 111;
        //versão básica
        int count=0;
        int countVitorias=0;
        int countPerdas=0;
        for (int i = 0; i < this.serie.getSerie().size(); i++) {
           
            if (count<3) {
                
                 System.out.print(this.serie.getSerie().get(i));
                    
                if ((int) this.serie.getSerie().get(i) == 1) {
                    existe=true;
                    
                }
            
                
                count++;
            }
          
            
            if (count==2) {
                if (existe) {
                     this.banca = banca +1;
                       System.out.println("");
                    System.out.println("Banca :" + banca+" ganhou 1");
                    existe=false;
                    countVitorias++;
                }
                else {

                    this.banca = banca - 7;
                     System.out.println("");
                    System.out.println("Banca :" + banca+" perdeu 7");
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
        
        System.out.println("Quantidade de vitórias:"+countVitorias+"\nQuantida de perdas:"+countPerdas);
        System.out.println("Banca atual:"+banca);

    }
}
