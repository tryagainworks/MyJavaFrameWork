/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

//import static com.app.dbactivities.clsGlobalDB.objMySQLCon;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UserWin7
 */
public class ClsOracleDB extends ClsGlobalDB implements IntetfaceGlobalDB {

    private static ClsOracleDB objSelf = null;

    public static ClsOracleDB self() {

        if (objSelf == null) {
            objSelf = new ClsOracleDB();
            return objSelf;
        } else {
            return objSelf;
        }
    }

    @Override
    public boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD) throws ClassNotFoundException, SQLException {
        return fnConnectDB(strUniqueIdentifier,"ORACLE", strIP, intPort, strSID, strDBName, strDBFileName, strUID, strPWD);
    }

    public boolean fnCloseDb(String strUniqueIdentifier) throws SQLException {
        return super.fnCloseDb(objOracleCon);
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
