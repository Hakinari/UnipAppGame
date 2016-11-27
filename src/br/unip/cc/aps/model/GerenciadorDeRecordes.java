package br.unip.cc.aps.model;

import br.unip.cc.aps.dao.DaoException;
import br.unip.cc.aps.dao.RecordeDAO;
import br.unip.cc.aps.dao.RecordeJpa;
import javax.swing.JOptionPane;


public class GerenciadorDeRecordes {
    
    private static GerenciadorDeRecordes instance;
    private RecordeDAO dao = RecordeJpa.getInstance();
    private Recorde[] recordes = null;
    
    static{
        instance = new GerenciadorDeRecordes();
    }

    public static GerenciadorDeRecordes getInstance() {
        return instance;
    }
    

    public GerenciadorDeRecordes() {
        recordes = dao.getArrayMateriais();
    }
    
    public void adicionaSeForRecorde(String nome,int pontos) throws DaoException{
        Recorde recorde = new Recorde(nome,pontos);
        if(recordes.length != 0){
            for(int i=0; i<=2;i++){
                if(recorde.getPontos() >= recordes[i].getPontos()){
                    switch(i){
                        case 0:
                            recordes[1] = recordes[0];
                            recordes[2] = recordes[1];
                            recordes[0] = recorde;
                            dao.excluir(recordes[2]);
                            recorde.setPosicao(1);
                            dao.incluir(recorde);
                            break;
                        case 1:
                            if(!recorde.equals(recordes[0])){
                                recordes[2] = recordes[1];
                                recordes[1] = recorde;
                                dao.excluir(recordes[2]);
                                recorde.setPosicao(2);
                                dao.incluir(recorde);
                            }
                            break;
                        case 2:
                            if(!recorde.equals(recordes[0])&& !recorde.equals(recordes[1])){
                            recordes[2] = recorde;
                                dao.excluir(recordes[2]);
                                recorde.setPosicao(3);
                                dao.incluir(recorde);
                            }
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
        }else{
            JOptionPane.showMessageDialog(null, "BD recordes vazio");
        }
    }
}
