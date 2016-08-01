/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author userlinuxmint14
 */
public class ClsSQLiteDataBase extends ClsGlobalDB implements IntetfaceGlobalDB {

    /**
     * @param args the command line arguments
     */
    public Connection objCon = null;
    PreparedStatement objPStmt = null;
    ResultSet objRs = null;

    @Override
    public boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fnCloseDb(String strUniqueIdentifier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet fnSelectQuery(String strUniqueIdentifier, String strQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fnUpdateQuery(String strUniqueIdentifier, String strUpdateQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fnDeleteQuery(String strUniqueIdentifier, String strDeleteQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery, byte[]... is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fnUpdateQuery(String strUniqueIdentifier, String strInsertQuery, byte[]... is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
