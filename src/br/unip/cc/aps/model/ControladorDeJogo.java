
package br.unip.cc.aps.model;

import br.unip.cc.aps.app.Aplicativo;
import br.unip.cc.aps.dao.DaoException;
import javax.swing.JOptionPane;


public class ControladorDeJogo {
    
    private static ControladorDeJogo instance;
    
    private Material material;
    private TipoMaterial tipoBotao;
    private Partida partida;
    
    

    
    static{
        instance = new ControladorDeJogo();
    }
    public ControladorDeJogo() {        
    }
    
    public void iniciar(){                      // Metodo iniciar pra iniciar a rodar o jogo
       if(partida!= null){              //para poder usar de novo no botão reiniciar
           partida = null;
       }
       partida = new Partida();
       material = GerenciadorMaterial.getInstance().pegaMaterialAleatorio();
       Aplicativo.getInstance().setImagemNaTela(material.getImagem()); // Usa app pra colocar material na tela
    }
    public void  VerificarSeAcertou () throws DaoException{        
        if(tipoBotao != null){ 
        if(tipoBotao == material.getTipo()){ //SE acertou
            partida.addPontos();
            Aplicativo.getInstance().atualizaPontosNaTela();
            ganhou();
         }else{
             if(partida.getErros() == 2){
                 JOptionPane.showMessageDialog(null,"VOCE PERDEU");
                 System.out.println("PERDEU");
                 Aplicativo.getInstance().atualizaPontosNaTela();
                 acabou();
             }else{
                 partida.addErro();
                 JOptionPane.showMessageDialog(null,"ERROU");
             }
         }
        tipoBotao = null;
        atualizaMaterial();        
        }else{
            JOptionPane.showMessageDialog(null,"Escolha uma Lixeira");
        }
    }  
       
    public void atualizaMaterial(){     // Adiciona no histórico
        partida.addMaterialNoHistorico(material.getId());
        mudaMaterial();
    }
    public void mudaMaterial(){     // troca o material principal

        material = GerenciadorMaterial.getInstance().pegaMaterialAleatorio();
        if(partida.estaNoHistorico(material.getId())){
            mudaMaterial();
        }

        Aplicativo.getInstance().setImagemNaTela(material.getImagem());         
    }
    public void setTipoBotao(TipoMaterial tipoBotao) {
        this.tipoBotao = tipoBotao;
    }
    public String getImagemMaterial(){
        return material.getImagem(); 
    }  
    public void ganhou() throws DaoException{
        if(getPontos()==100){
            JOptionPane.showMessageDialog(null, "PARABÉNS VOCÊ GANHOU");
            acabou();
        }
    }
    public void acabou() throws DaoException{
        
        Aplicativo.getInstance().setImagemNaTela("/br/unip/cc/aps/images/ImagemInicial.png");
        
        if(GerenciadorDeRecordes.getInstance().eRecord(partida.getPontos())){
            String nome = JOptionPane.showInputDialog(null, "Digite seu nome","Você é um recordista",JOptionPane.OK_OPTION);
            GerenciadorDeRecordes.getInstance().adicionaSeForRecorde(nome,partida.getPontos());
            Aplicativo.getInstance().telaDeRecorde();            
        }
        tipoBotao = null ;
        partida.setPontos(0);
        Aplicativo.getInstance().atualizaPontosNaTela();
        partida = null;
        
    }
    public int getPontos(){
        return partida.getPontos();
    }
    public static ControladorDeJogo getInstance() {
        return instance;
    }
    
    


}
