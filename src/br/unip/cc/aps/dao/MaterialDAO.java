
package br.unip.cc.aps.dao;

import br.unip.cc.aps.model.Material;
import java.util.List;



public interface MaterialDAO {
    public List<Material> getTodos() throws DaoException;
    public Material[] getArrayMateriais();
}
