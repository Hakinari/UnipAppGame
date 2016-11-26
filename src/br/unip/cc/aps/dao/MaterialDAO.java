
package br.unip.cc.aps.dao;

import br.unip.cc.aps.model.Material;
import br.unip.cc.aps.model.TipoMaterial;
import java.util.List;



public interface MaterialDAO {
    public List<Material> getTodos() throws DaoException;
    public List<Material> getMaterialPorTipo(TipoMaterial tipo) throws DaoException;
    public void incluir(Material material) throws DaoException;
    public void excluir(Material material) throws DaoException;
    public void atualizar(Material material) throws DaoException;
 
}
