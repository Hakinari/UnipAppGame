
package br.unip.cc.aps.dao;

public class DaoException extends Exception{

    public DaoException() {
    }

    public DaoException(String string) {
        super(string);
    }

    public DaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DaoException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DaoException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
