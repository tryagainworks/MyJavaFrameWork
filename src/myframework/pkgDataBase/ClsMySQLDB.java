/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UserWin7
 */
public class ClsMySQLDB extends ClsGlobalDB implements IntetfaceGlobalDB {

    private static ClsMySQLDB objSelf = null;

    public static ClsMySQLDB self() {

        if (objSelf == null) {
            objSelf = new ClsMySQLDB();
            return objSelf;
        } else {
            return objSelf;
        }
    }

    @Override
    public boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD) throws ClassNotFoundException, SQLException {
        return fnConnectDB(strUniqueIdentifier, "MYSQL", strIP, intPort, strSID, strDBName, strDBFileName, strUID, strPWD);
    }

    @Override
    public ResultSet fnSelectQuery(String strUniqueIdentifier, String strQuery) throws SQLException {
        return super.fnSelectQuery(strQuery, objMySQLCon);
    }

    @Override
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery) throws SQLException {
        return super.fnInsertQuery(strInsertQuery, objMySQLCon);
    }

    @Override
    public int fnUpdateQuery(String strUniqueIdentifier, String strUpdateQuery) throws SQLException {
        return super.fnUpdateQuery(strUpdateQuery, objMySQLCon);
    }

    @Override
    public int fnDeleteQuery(String strUniqueIdentifier, String strDeleteQuery) throws SQLException {
        return super.fnDeleteQuery(strDeleteQuery, objMySQLCon);
    }

    @Override
    public boolean fnCloseDb(String strUniqueIdentifier) throws SQLException {
        return super.fnCloseDb(objMySQLCon);
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
