
package br.unip.cc.aps.view;

import br.unip.cc.aps.app.Aplicativo;
import br.unip.cc.aps.model.ControladorDeJogo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Tela  extends JFrame{
    
    private PainelJogo jogo;
    private PainelBotoesLixeira botoes;
    
    public Tela (){
        
        this.setTitle("Jogo Ambiental");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(criaBarraDeMenu());
        this.setSize(600, 500);
        
        jogo = Aplicativo.getInstance().getPainelJogo();
        this.add(jogo,BorderLayout.WEST);
        botoes = Aplicativo.getInstance().getPainelBotoesLixeira();
        this.add(botoes,BorderLayout.EAST);
        this.setVisible(true);
    }
    
    public JMenuBar criaBarraDeMenu(){
        JMenuBar barra = new JMenuBar();
        JMenu menuMenu = new JMenu("Menu");
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenu menuSobre = new JMenu("Sobre");
        
        barra.add(menuMenu);
        barra.add(menuAjuda);
        barra.add(menuSobre);
        
        ////////////////BOTOES MENU///////////////
        JMenuItem itemJogar = new JMenuItem("Jogar");
        itemJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorDeJogo.getInstance().iniciar();
            }
        });
        
        JMenuItem itemReiniciar = new JMenuItem("Reiniciar");
        itemReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               ControladorDeJogo.getInstance().iniciar();
                
            }
        });
        
        JMenuItem itemRecordes = new JMenuItem("Recordes");
        itemJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                                          ///////////// IMPLEMENTAR ///////////////////
            }
        });
        
        menuMenu.add(itemJogar);
        menuMenu.add(itemReiniciar);
        menuMenu.add(itemRecordes);
        
        ///////////AJUDA MENU///////////////
        menuAjuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,                                                    
                        "",          /////////// IMPLEMENTAR MENSSAGEM DE AJUDA /////////////
                        "Ajuda",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ///////////SOBRE MENU///////////////
        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,                                                    
                        "Desenvolvido por:\n"
                                + "- Duduzin\n"
                                + "- Robertinho\n"
                                + "- Deninho",          
                        "Sobre",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return barra;
    }
    
    public static void main(String[] args) {
        System.out.println("SouTela");
        try {
            Tela tela = new Tela();
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
}

