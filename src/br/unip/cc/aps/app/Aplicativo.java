package br.unip.cc.aps.app;

import br.unip.cc.aps.model.ControladorDeJogo;
import br.unip.cc.aps.model.GerenciadorDeRecordes;
import br.unip.cc.aps.model.GerenciadorMaterial;
import br.unip.cc.aps.model.Recorde;
import br.unip.cc.aps.view.PainelBotoesLixeira;
import br.unip.cc.aps.view.PainelJogo;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



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
        GerenciadorMaterial.getInstance();
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
   
    public Recorde[] getArrayRecorde(){
    return GerenciadorDeRecordes.getInstance().getRecordes();     
    }
    
    public void telaDeRecorde(){
        
        String recordesNome = "NOME E PONTOS\n";
              Recorde[] arrayRecorde = Aplicativo.getInstance().getArrayRecorde(); 
              
              for(int i=0; i<=2;i++ ){
                recordesNome = recordesNome +arrayRecorde[i].getNome()                        
                        +": "+arrayRecorde[i].getPontos()
                        +" \n" ;
                  
              }
              JOptionPane.showMessageDialog(null,                                                    
                        ""+recordesNome,          
                        "Recordes",JOptionPane.INFORMATION_MESSAGE);
        
    
    }


}
