/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

//import static com.app.dbactivities.clsGlobalDB.objMySQLCon;

import java.sql.SQLException;


/**
 *
 * @author UserWin7
 */
public class ClsPostgreSQLDB extends ClsGlobalDB {

    private static ClsPostgreSQLDB objSelf = null;

    public static ClsPostgreSQLDB self() {

        if (objSelf == null) {
            objSelf = new ClsPostgreSQLDB();
            return objSelf;
        } else {
            return objSelf;
        }
    }

    @Override
    public boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD) throws ClassNotFoundException, SQLException {
        return fnConnectDB(strUniqueIdentifier,"POSTGRESQL", strIP, intPort, strSID, strDBName, strDBFileName, strUID, strPWD);
    }

    public boolean fnCloseDb(String strUniqueIdentifier) throws SQLException  {
        return super.fnCloseDb(objPostgreSQLCon);
    }

}
