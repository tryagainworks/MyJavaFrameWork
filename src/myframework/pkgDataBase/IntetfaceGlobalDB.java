/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

//import static com.app.dbactivities.clsGlobalDB.objMySQLCon;
//import static com.app.dbactivities.clsGlobalDB.objStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UserWin7
 */
public interface IntetfaceGlobalDB {

    /*Basic*/
    public boolean fnCloseDb(String strUniqueIdentifier)  throws SQLException;

    public ResultSet fnSelectQuery(String strUniqueIdentifier, String strQuery)  throws SQLException;

    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery)  throws SQLException;
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery, byte[]...is)  throws SQLException;

    
    public int fnUpdateQuery(String strUniqueIdentifier, String strUpdateQuery)  throws SQLException;
    public int fnUpdateQuery(String strUniqueIdentifier, String strInsertQuery, byte[]...is)  throws SQLException;

    public int fnDeleteQuery(String strUniqueIdentifier, String strDeleteQuery)  throws SQLException ;

    /*Table*/
    /*
    public boolean fnDropTable(String strTableName);

    public boolean fnCreateTable(String strTableName, String strTableScript);

    public boolean fnAlterTable(String strTableName, String strTableScript);

    public boolean fnRenameTable(String strTableName, String strTableScript);
*/
    /*Procedure*/
    /*
    public boolean fnDropProcedure(String strTableName);

    public boolean fnCreateProcedure(String strTableName, String strTableScript);

    public boolean fnAlterProcedure(String strTableName, String strTableScript);

    public boolean fnRenameProcedure(String strTableName, String strTableScript);
*/
    /*Trigger*/
    /*
    public boolean fnDropTrigger(String strTableName);

    public boolean fnCreateTrigger(String strTableName, String strTableScript);

    public boolean fnAlterTrigger(String strTableName, String strTableScript);

    public boolean fnRenameTrigger(String strTableName, String strTableScript);
*/
    /*Function*/
    /*
    public boolean fnDropFunction(String strTableName);

    public boolean fnCreateFunction(String strTableName, String strTableScript);

    public boolean fnAlterFunction(String strTableName, String strTableScript);

    public boolean fnRenameFunction(String strTableName, String strTableScript);
    */

}
