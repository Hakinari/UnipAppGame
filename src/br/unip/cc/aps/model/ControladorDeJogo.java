
package br.unip.cc.aps.model;

import br.unip.cc.aps.app.Aplicativo;
import javax.swing.JOptionPane;


public class ControladorDeJogo {
    
    private static ControladorDeJogo instance;
    
    private Material[] listaDeMateriais; //// Icrementar
    private Material material;
    private int pontos;
    private int[] idHistoricoDeMaterial;
    int erros;
    private TipoMaterial tipoBotao;
    
    

    
    static{
        instance = new ControladorDeJogo(1);
    }
    public ControladorDeJogo(int i) {
        listaDeMateriais = new Material[4];
        listaDeMateriais[0] = new Material(0,"/br/unip/cc/aps/images/lixeira_VIDRO.png",TipoMaterial.VIDRO);
        listaDeMateriais[1] = new Material(1,"/br/unip/cc/aps/images/lixeira_METAL.png",TipoMaterial.METAL);
        listaDeMateriais[2] = new Material(1,"/br/unip/cc/aps/images/lixeira_PLASTICO.png",TipoMaterial.PLASTICO);
        listaDeMateriais[3] = new Material(1,"/br/unip/cc/aps/images/lixeira_PAPEL.png",TipoMaterial.PAPEL);
        
//        listaDeMateriais = new Material[16]; // RECEBER DO BANCO
//        pontos = 0;
//        idHistoricoDeMaterial = new int[3];
//        erros = 0;
//        for(int i=0;i <=2;i++ ){
//            idHistoricoDeMaterial[i] = -1;
//        }
    }
    
    public void  VerificarSeAcertou (){
        
         if(tipoBotao == material.getTipo()){ //SE acertou
             pontos = pontos+10;
             Aplicativo.getInstance().atualizaPontosNaTela();
         }else{
             if(erros == 2){
                 JOptionPane.showMessageDialog(null,"PERDEU");
                 reset();
             }else{
                 addErro();
                 JOptionPane.showMessageDialog(null,"ERROU");
                 
             }
         }
         atualizaMaterial();        
    }  
       
    public void iniciar(){                      // Metodo iniciar pra iniciar a rodar o jogo
       pontos = 0;
       idHistoricoDeMaterial = new int[3];
       erros = 0;
       for(int i=0;i <=2;i++ ){
            idHistoricoDeMaterial[i] = -1;
       }
       material = listaDeMateriais[0];
       //material.setImagem("/br/unip/cc/aps/images/lixeira_VIDRO.png"); ////TIRAR TESTE
       Aplicativo.getInstance().setImagemNaTela(material.getImagem()); // Usa app pra colocar material na tela
          
    }
    
    public void atualizaMaterial(){     // Adiciona no histórico
        addMaterialNoHistorico();
        mudaMaterial();
    }
    int i =0;                                                                    //Tirar teste de gerar material a partir do vetor
    public void mudaMaterial(){     // troca o material principal
        //int random = (int)Math.random()*16;
        //material = listaDeMateriais[random];
        i++;                                                                    //Tirar teste de gerar material a partir do vetor
        material = listaDeMateriais[i];                                         //Tirar teste de gerar material a partir do vetor
        
        if (idHistoricoDeMaterial[0] != -1){    // se tiver algum material no historico
            for(int i = 0; i <=2;i++){
                if(idHistoricoDeMaterial[i] == material.getId()){   //verifica se não tem nenhum 
                                                                                      //material no histórico q ja foi usado
                }
            }
        }
                                             
        Aplicativo.getInstance().setImagemNaTela(material.getImagem());         
    }
    
    public void setTipoBotao(TipoMaterial tipoBotao) {
        this.tipoBotao = tipoBotao;
    }
    
    public String getImagemMaterial(){
        return material.getImagem(); 
    }
       
    public void addMaterialNoHistorico(){
        if(idHistoricoDeMaterial[0] == -1 ){    // SE não tem nenhum histórico
            idHistoricoDeMaterial[0] = material.getId();
        }else{ 
            idHistoricoDeMaterial[2] = idHistoricoDeMaterial[1]; // histórico passa uma a mais na fila
            idHistoricoDeMaterial[1] = idHistoricoDeMaterial[0];
            idHistoricoDeMaterial[0] = material.getId();
        }
    }
    
    public void addErro() {
        this.erros++;
    }
    
    public void reset(){                // zera todas configuraçoes do jogo
        this.pontos = 0;
        this.erros = 0;
        tipoBotao = null ;
        for(int i = 0;i <=2; i++){
            idHistoricoDeMaterial[i] = -1;
        }
        //iniciar();
        Aplicativo.getInstance().setImagemInicialNaTela();
    }    

    public int getPontos() {
        return pontos;
    }
    
    public void perdeu(){
        reset();
        Aplicativo.getInstance().setImagemInicialNaTela();
    }
    
    public static ControladorDeJogo getInstance() {
        return instance;
    }
    
    


}
