package br.unip.cc.aps.dao;

import br.unip.cc.aps.model.Recorde;
import java.util.List;

public interface RecordeDAO {
    public List<Recorde> getTodos()throws DaoException;
    public Recorde[] getArrayMateriais();
    public void incluir(Recorde recorde) throws DaoException;
    public void excluir(Recorde recorde) throws DaoException;
}
