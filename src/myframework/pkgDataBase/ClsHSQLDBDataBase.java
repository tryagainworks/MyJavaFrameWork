/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;

/**
 *
 * @author UserWin7
 */
public class ClsHSQLDBDataBase extends ClsGlobalDB implements IntetfaceGlobalDB {

    private static ClsHSQLDBDataBase objSelf = null;

    public static ClsHSQLDBDataBase self(JTextArea _txtLogs) {

        txtLogs = _txtLogs;
        if (objSelf == null) {
            objSelf = new ClsHSQLDBDataBase();
            return objSelf;
        } else {
            return objSelf;
        }
    }

    @Override
    public boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD)  throws ClassNotFoundException, SQLException{
        return fnConnectDB(strUniqueIdentifier, "HSQLDB", strIP, intPort, strSID, strDBName, strDBFileName, strUID, strPWD);
    }

    @Override
    public ResultSet fnSelectQuery(String strUniqueIdentifier, String strQuery)  throws SQLException{
        return super.fnSelectQuery(strQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

    @Override
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery)  throws SQLException{
        return super.fnInsertQuery(strInsertQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

    @Override
    public int fnInsertQuery(String strUniqueIdentifier, String strInsertQuery, byte[]... is)  throws SQLException{
        return super.fnInsertQuery(strInsertQuery, fnGetConnectionObject(strUniqueIdentifier), is);
    }

    @Override
    public int fnUpdateQuery(String strUniqueIdentifier, String strUpdateQuery) throws SQLException {
            return super.fnUpdateQuery(strUpdateQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

    @Override
    public int fnUpdateQuery(String strUniqueIdentifier, String strUpdateQuery, byte[]... is)  throws SQLException{
        return super.fnUpdateQuery(strUpdateQuery, fnGetConnectionObject(strUniqueIdentifier),is);
    }

    @Override
    public int fnDeleteQuery(String strUniqueIdentifier, String strDeleteQuery)  throws SQLException{
        return super.fnDeleteQuery(strDeleteQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

    @Override
    public boolean fnCloseDb(String strUniqueIdentifier) throws SQLException {
        return super.fnCloseDb(fnGetConnectionObject(strUniqueIdentifier));
    }

    public ResultSet fnGetAllTables(String strUniqueIdentifier) throws SQLException {
        String strQuery = "";
        switch ("HSQLDB") {
            case "MYSQL":
                break;
            case "ORACLE":
                break;
            case "POSTGRESQL":
                break;
            case "SQLITE":
                break;
            case "HSQLDB":
                strQuery = "select TABLE_NAME as \"Table Name\", 'tbl_'||ROWNUM() as \"Alias Name\", (1=2) as Common, (1=2) as Save, (1=2) as Edit, (1=2) as View from information_schema.tables where table_schema = 'PUBLIC' and table_type = 'BASE TABLE'";
                break;
            case "SQLSERVER":
                break;
        }
        return super.fnSelectQuery(strQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

    public ResultSet fnGetAllTableColumns(String strUniqueIdentifier, String strTableName) throws SQLException {
        String strQuery = "";
        switch ("HSQLDB") {
            case "MYSQL":
                break;
            case "ORACLE":
                break;
            case "POSTGRESQL":
                break;
            case "SQLITE":
                break;
            case "HSQLDB":
                strQuery = " select column_name as Column,column_name as \"Alias Name\", (1=2) as Common, (1=2) as Save, (1=2) as Edit, (1=2) as View, data_type as Type,is_nullable as NullAllowed, isnull(character_maximum_length,-1) as Max_Lenght  from information_schema.COLUMNS ";
                strQuery += " where TABLE_SCHEMA='PUBLIC' ";
                strQuery += " and TABLE_NAME = '" + strTableName + "' ";
                break;
            case "SQLSERVER":
                break;
        }
        return super.fnSelectQuery(strQuery, fnGetConnectionObject(strUniqueIdentifier));
    }

}
