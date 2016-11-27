
package br.unip.cc.aps.model;


public class Partida {
        private int pontos;
        private int[] idHistoricoDeMaterial;
        int erros;

    public Partida() {
        this.pontos = 0;
        this.erros = 0;
        idHistoricoDeMaterial = new int[3];
        for(int i=0;i <=2;i++ ){
          idHistoricoDeMaterial[i] = 0;
        }
    
    }

    public int getPontos() {
        return pontos;
    }
    public void addMaterialNoHistorico(int id){
        if(idHistoricoDeMaterial[0] == 0 ){    // SE não tem nenhum histórico
            idHistoricoDeMaterial[0] = id;
        }else{ 
            idHistoricoDeMaterial[2] = idHistoricoDeMaterial[1]; // histórico passa uma a mais na fila
            idHistoricoDeMaterial[1] = idHistoricoDeMaterial[0];
            idHistoricoDeMaterial[0] = id;
        }
    }
    public void addErro() {
        this.erros++;
    }
    public void reset(){
                this.pontos = 0;
        this.erros = 0;
        if(idHistoricoDeMaterial != null){
            for(int i = 0;i <=2; i++){
                idHistoricoDeMaterial[i] = 0;
            }
        }else{
            idHistoricoDeMaterial = new int[3];
            for(int i = 0;i <=2; i++){
                idHistoricoDeMaterial[i] = 0;
            }
        }
    }
    public void addPontos(){
        pontos =pontos+10;
    }
    public boolean estaNoHistorico(int id){
        if (idHistoricoDeMaterial[0] != 0){    // se tiver algum material no historico
            for(int i = 0; i <=2;i++){
                if(idHistoricoDeMaterial[i] == id){   //verifica se não tem nenhum material no histórico q ja foi usado
                    return true;
                }
            }
        }
        return false;
    }
    public int getErros() {
        return erros;
    }

    void setPontos(int i) {
        this.pontos = i;
    }
    
}    
