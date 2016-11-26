package br.unip.cc.aps.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PainelJogo extends JPanel {
    
    private JLabel lblPontos;
    private JTextField txtPontos;
    private JLabel lblImagem;
    
    public PainelJogo() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.add(criaPainelPontos(),BorderLayout.NORTH);
        this.add(criaPainelImagem(),BorderLayout.WEST);
    }
    public JPanel criaPainelPontos(){
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        lblPontos = new JLabel("Pontos:");
        txtPontos = new JTextField(5);
        txtPontos.setEditable(false);
        painel.add(lblPontos);
        painel.add(txtPontos);
 
        
        return painel;
    }
    public JPanel criaPainelImagem(){
       
        JPanel painel = new JPanel();
        lblImagem = new JLabel();
        painel.add(lblImagem);
        setImagemInicial();
       return painel;
    }
    public void setImagem(ImageIcon img){
        lblImagem.setIcon(img); 
    }
    public void setImagemInicial(){
        String url = "/br/unip/cc/aps/images/ImagemInicial.png";
        try {
            URL resource = getClass().getResource(url);
            File file = new File(resource.toURI());
            //setando o icone
            ImageIcon logo = new ImageIcon(file.getPath());

            lblImagem.setIcon(logo);  

        } catch (URISyntaxException ex) {
           ex.printStackTrace();
        }   
    }
    public void setPontosNaTela(int pontos){
        txtPontos.setText( Integer.toString(pontos)); 
        
    }
}    
