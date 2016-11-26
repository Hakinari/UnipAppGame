package br.unip.cc.aps.app;

import br.unip.cc.aps.model.ControladorDeJogo;
import br.unip.cc.aps.view.PainelBotoesLixeira;
import br.unip.cc.aps.view.PainelJogo;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;



public class Aplicativo {
    
   private static Aplicativo instance;
   private PainelJogo painelJogo;
   private PainelBotoesLixeira painelBotoesLixeira;
   
   static{
       instance = new Aplicativo();
   }
   
   public static Aplicativo getInstance(){
       return instance;
   }
   
   private Aplicativo(){
        painelJogo = new PainelJogo();
        painelBotoesLixeira = new PainelBotoesLixeira();
       
   }
   
   public PainelJogo getPainelJogo() {
        return painelJogo;
    }

   public PainelBotoesLixeira getPainelBotoesLixeira() {
        return painelBotoesLixeira;
    }
   
   public void setImagemNaTela(String link){
       try {

            URL resource = getClass().getResource(link);
            File file = new File(resource.toURI());
            //setando o icone
            ImageIcon logo = new ImageIcon(file.getPath());
            painelJogo.setImagem(logo);
            
        } catch (URISyntaxException ex) {
           ex.printStackTrace();
        }   
   }
   
   public void atualizaPontosNaTela(){
       
       painelJogo.setPontosNaTela(ControladorDeJogo.getInstance().getPontos());
   }
   public void setImagemInicialNaTela(){
       painelJogo.setImagemInicial();
   }

}
