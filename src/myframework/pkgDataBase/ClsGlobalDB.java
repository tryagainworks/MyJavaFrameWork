/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JTextArea;
import myframework.pkgGUIContainers.ClsGUIContainers;

/**
 *
 * @author UserWin7
 */
public abstract class ClsGlobalDB {

    //private static Connection[] objDBCon;
    protected static Connection objMySQLCon;
    protected static Connection objHSSQLCon;
    protected static Connection objOracleCon;
    protected static Connection objPostgreSQLCon;
    protected static HashMap<String, Connection> objHMDBCon;
    protected static Statement objStatement;
    protected static PreparedStatement objPreStatement;
    protected static JTextArea txtLogs;
    private int intNumberOfConnections = 0;

    public ClsGlobalDB() {
        //objDBCon = new Connection[intNumberOfConnections];
        objHMDBCon = new HashMap<>();
        objMySQLCon = null;
        objHSSQLCon = null;
        objOracleCon = null;
        objPostgreSQLCon = null;
    }

    public abstract boolean fnConnectDB(String strUniqueIdentifier, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD)  throws ClassNotFoundException, SQLException;

    protected Connection fnGetConnectionObject(String strUniqueIdentifier) {
        Connection objCon = null;
        if (objHMDBCon.containsKey(strUniqueIdentifier)) {
            return objHMDBCon.get(strUniqueIdentifier);
        } else {
            return null;
        }
    }

    protected boolean fnConnectDB(String strUniqueIdentifier, String strConType, String strIP, int intPort, String strSID, String strDBName, String strDBFileName, String strUID, String strPWD) throws ClassNotFoundException, SQLException {
        Connection objCon = null;

        if (objHMDBCon.containsKey(strUniqueIdentifier)) {
            objCon = objHMDBCon.get(strUniqueIdentifier);
        } else {
            //try {
                //try {
                    switch (strConType) {
                        case "MYSQL":
                            Class.forName("com.mysql.jdbc.Driver");
                            objCon = DriverManager.getConnection("jdbc:mysql://" + strIP + ":" + intPort + "/" + strDBName, strUID, strPWD);
                            break;
                        case "ORACLE":
                            break;
                        case "POSTGRESQL":
                            Class.forName("org.postgresql.Driver");
                            objCon = DriverManager.getConnection("jdbc:postgresql://hostname:port/dbname", "username", "password");
                            break;
                        case "SQLITE":
                            break;
                        case "HSQLDB":
                            //Class.forName("org.hsqldb.jdbcDriver");
                            objCon = DriverManager.getConnection("jdbc:hsqldb:file:" + strDBFileName, strUID, strPWD);
                            //objHSSQLCon = DriverManager.getConnection("jdbc:hsqldb:file:D:\\MyApps\\NetBeansProjects\\babyNameCalculator\\src\\resource\\babynames", strUID, strPWD);
                            break;
                        case "SQLSERVER":
                            break;
                    }
                    //return true;
                //} catch (ClassNotFoundException ex) {
                    //Logger.getLogger(ClsHSQLDBDataBase.class.getName()).log(Level.SEVERE, null, ex);
                   // ClsGUIContainers.self(txtLogs).fnDisplayError("Database Open Error : " + ex.getMessage(), "", "");
                //}
                //return true;
            //} catch (SQLException ex) {
                //ClsGUIContainers.self(txtLogs).fnDisplayError("SQLException :" + ex.getMessage(), "", "");
                //Logger.getLogger(ClsHSQLDBDataBase.class.getName()).log(Level.SEVERE, null, ex);
            //}
            objHMDBCon.put(strUniqueIdentifier, objCon);
            intNumberOfConnections += 1;
            return true;
        }
        return false;
    }

    protected boolean fnCloseDb(Connection objCon) throws SQLException {
        if (objCon != null) {
            //try {
                objCon.close();
                objCon = null;
            //} catch (SQLException ex) {
                //Logger.getLogger(ClsGlobalDB.class.getName()).log(Level.SEVERE, null, ex);
               // ClsGUIContainers.self(txtLogs).fnDisplayError("DB Connection Close Error : " + ex.getMessage(), "", "");
            //}
        } else {
            ClsGUIContainers.self(txtLogs).fnDisplayError("Database already in closed state", "", "");
        }
        return true;
    }

    protected ResultSet fnSelectQuery(String strQuery, Connection objCon) throws SQLException {
        //try {
            objStatement = objCon.createStatement();
            ResultSet res = objStatement.executeQuery(strQuery);
            return res;
        //} catch (SQLException ex) {
            //Logger.getLogger(ClsGlobalDB.class.getName()).log(Level.SEVERE, null, ex);
            //ClsGUIContainers.self(txtLogs).fnDisplayError("Select Query Error : " + ex.getMessage(), "", "");
        //}
        //return null;
    }

    protected int fnInsertQuery(String strInsertQuery, Connection objCon) throws SQLException {
        return fnExecuteDML(strInsertQuery, objCon, "Insert");
    }
    
    protected int fnInsertQuery(String strInsertQuery, Connection objCon, byte[]...is) throws SQLException {
        return fnExecuteDML(strInsertQuery, objCon, "Insert",is);
    }

    protected int fnUpdateQuery(String strUpdateQuery, Connection objCon) throws SQLException {
        return fnExecuteDML(strUpdateQuery, objCon, "Update");
    }

    protected int fnUpdateQuery(String strUpdateQuery, Connection objCon, byte[]...is) throws SQLException {
        return fnExecuteDML(strUpdateQuery, objCon, "Update",is);
    }    
    protected int fnDeleteQuery(String strDeleteQuery, Connection objCon) throws SQLException {
        return fnExecuteDML(strDeleteQuery, objCon, "Delete");
    }

    protected int fnExecuteDML(String strQuery, Connection objCon, String strQureyType) throws SQLException {
        //try {
            objStatement = objCon.createStatement();
            int result = objStatement.executeUpdate(strQuery);
            return result;
        //} catch (SQLException ex) {
            //Logger.getLogger(ClsGlobalDB.class.getName()).log(Level.SEVERE, null, ex);
            //ClsGUIContainers.self(txtLogs).fnDisplayError(strQureyType + " Query Error : " + ex.getMessage(), "", "");
        //}
        //return -1;
    }
    
    protected int fnExecuteDML(String strQuery, Connection objCon, String strQureyType, byte[]...is) throws SQLException {
       // try {
            objPreStatement = objCon.prepareStatement(strQuery);
            for(int iCount=1;iCount<=is.length;iCount++){
                objPreStatement.setBytes(iCount, is[iCount-1]);
            }
            
            /*int result = (int)*/objPreStatement.execute();// .executeUpdate();
            return 1;
       // } catch (SQLException ex) {
            //Logger.getLogger(ClsGlobalDB.class.getName()).log(Level.SEVERE, null, ex);
           // ClsGUIContainers.self(txtLogs).fnDisplayError(strQureyType + " Query Error : " + ex.getMessage(), "", "");
       // }
        //return -1;
    }

    /*Table*/
    protected boolean fnDropTable(String strTableName, Connection objCon) {
        return false;
    }

    protected boolean fnCreateTable(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnAlterTable(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnRenameTable(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    /*Procedure*/
    protected boolean fnDropProcedure(String strTableName, Connection objCon) {
        return false;
    }

    protected boolean fnCreateProcedure(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnAlterProcedure(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnRenameProcedure(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    /*Trigger*/
    protected boolean fnDropTrigger(String strTableName, Connection objCon) {
        return false;
    }

    protected boolean fnCreateTrigger(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnAlterTrigger(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnRenameTrigger(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    /*Function*/
    protected boolean fnDropFunction(String strTableName, Connection objCon) {
        return false;
    }

    protected boolean fnCreateFunction(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnAlterFunction(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

    protected boolean fnRenameFunction(String strTableName, String strTableScript, Connection objCon) {
        return false;
    }

}
