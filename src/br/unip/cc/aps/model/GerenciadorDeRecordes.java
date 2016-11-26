package br.unip.cc.aps.model;

import javax.swing.JOptionPane;


public class GerenciadorDeRecordes {
    
    private static GerenciadorDeRecordes instance;
    private Recordes[] recordes;
    
    static{
        instance = new GerenciadorDeRecordes();
    }

    public GerenciadorDeRecordes() {
        recordes = new Recordes[3];
    }
    public void adicionaSeForRecorde(Recordes recorde ){
        for(int i=0; i<=2;i++){
            if(recorde.getPontos()>= recordes[i].getPontos()){
                switch(i){
                    case 0:
                        recordes[1] = recordes[0];
                        recordes[2] = recordes[1];
                        recordes[0] = recorde;
                        break;
                    case 1:
                        recordes[2] = recordes[1];
                        recordes[1] = recorde;
                        break;
                    case 2:
                        recordes[2] = recorde;
                        break;
                    default:
                        //Mostrar Recorde
                        i =3;
                        break;
                }   
            }else{
                     JOptionPane.showMessageDialog(null,"Você não bateu os recordes!");   
                    }
        }
    }
}
