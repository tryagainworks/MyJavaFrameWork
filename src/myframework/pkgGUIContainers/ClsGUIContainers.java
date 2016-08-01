/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIContainers;

import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author userlinuxmint14
 */
public class ClsGUIContainers {

    private static ClsGUIContainers objSelf = null;
    private JTextArea txaLogs;
    Calendar objClndr;
    public int intScreenWidth;
    public int intScreenHeight;

    public ClsGUIContainers(JTextArea _txaLogs) {
        objClndr = Calendar.getInstance();
        txaLogs = _txaLogs;
        intScreenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        intScreenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static ClsGUIContainers self(JTextArea _txaLogs) {
        //txaLogs = _txaLogs;
        if (objSelf == null) {
            objSelf = new ClsGUIContainers(_txaLogs);
            return objSelf;
        } else {
            return objSelf;
        }
    }

    public int fnShowConfirmDialog(Component parentComponent, Object message) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        return JOptionPane.showConfirmDialog(parentComponent, message);
    }

    public int fnShowConfirmDialog(Component parentComponent, Object message, String title, int optionType) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType);
    }

    public int fnShowConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType);
    }

    public int fnShowConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon);
    }

    public void fnShowMessageDialog(Component parentComponent, Object message) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        JOptionPane.showMessageDialog(parentComponent, message);
    }

    public void fnShowMessageDialog(Component parentComponent, Object message, String title, int messageType) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }

    public void fnShowMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon) {
        txaLogs.append("\n*------------[" + objClndr.getTime().toString() + "]---------*\n" + message.toString());
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
    }

    public int fnDisplayError(String strError, String strTitle, String ErrorType) {
        return fnShowConfirmDialog(null, strError, strTitle, JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
    }

    public void fnResultSetToJTable(JXTable objTbl, ResultSet objRs, boolean blnNeedRowNumber, int[] intEditableCols, int[] intHiddenCols) {
        try {
            objTbl.setModel(fnbuildTableModel(objRs, blnNeedRowNumber, intEditableCols));
            objTbl.packAll();
            objTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            if (intHiddenCols != null) {
                //Remove(hide) column from back side. so the index will be maintained
                for (int cCount = intHiddenCols.length - 1; cCount >= 0; cCount--) {
                    objTbl.removeColumn(objTbl.getColumn(intHiddenCols[cCount]));
                }
            }
            objRs.close();
            objRs = null;
        } catch (Exception ex) {
            fnDisplayError(ex.getMessage(), "", "");
        }
    }

    //http://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset
    private DefaultTableModel fnbuildTableModel(ResultSet rs, boolean blnNeedRowNumber, final int[] intEditableCols)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        if (blnNeedRowNumber) {
            columnNames.add("#");
        }
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnLabel(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            if (blnNeedRowNumber) {
                vector.add(rs.getRow());
            }
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new MyDefaultTableModel(data, columnNames, intEditableCols);
        /*
         return new DefaultTableModel(data, columnNames) {
         @Override
         public Class<?> getColumnClass(int columnIndex) {
         if (this.getRowCount() != 0) {
         if (getValueAt(0, columnIndex).getClass() != null) {
         return getValueAt(0, columnIndex).getClass();
         } else {
         return String.class;
         }
         }
         return String.class;
         }

         @Override
         public boolean isCellEditable(int row, int col) {
         if (this.getRowCount() != 0) {
         if (getValueAt(row, col).getClass() != null) {

         if (intEditableCols != null) {
         for (int iCount = 0; iCount < intEditableCols.length; iCount++) {
         if (col == intEditableCols[iCount]) {
         return true;
         }
         }
         }
         return false;

         } else {
         return false;
         }
         }
         return false;
         }
         };
         */
    }

    public void fnShowInteralForm(JTabbedPane objMain, JPanel objChild, String strTitle) {
        try {
            if (!objChild.isVisible()) {
                objMain.addTab(strTitle, objChild);
                objChild.setVisible(true);
            } else {

            }
        } catch (Exception ex) {
            fnDisplayError(ex.getMessage(), "", "");
        }
    }

    public void fnShowInternalFormMiddle(JFrame objMainFrm, Component objSubFrm, boolean blnAtTop) {
        if (objSubFrm != null && objMainFrm != null) {
            //if (objSubFrm.isShowing()) {
            int intMainFormWidth = objMainFrm.getWidth();
            int intMainFormHeight = objMainFrm.getHeight();
            if (blnAtTop) {
                objSubFrm.setLocation((intMainFormWidth - objSubFrm.getWidth()) / 2, 0);
            } else {
                objSubFrm.setLocation((intMainFormWidth - objSubFrm.getWidth()) / 2, (intMainFormHeight - objSubFrm.getHeight()) / 2);
            }
            //}
        }
    }

    
    public void fnShowInternalFormMiddle(JDesktopPane objMainFrm, Component objSubFrm, boolean blnAtTop) {
        if (objSubFrm != null && objMainFrm != null) {
            //if (objSubFrm.isShowing()) {
            int intMainFormWidth = objMainFrm.getWidth();
            int intMainFormHeight = objMainFrm.getHeight();
            if (blnAtTop) {
                objSubFrm.setLocation((intMainFormWidth - objSubFrm.getWidth()) / 2, 0);
            } else {
                objSubFrm.setLocation((intMainFormWidth - objSubFrm.getWidth()) / 2, (intMainFormHeight - objSubFrm.getHeight()) / 2);
            }
            //}
        }
    }
    

    public void fnPopulateData(JList<String> lstBox, ResultSet rs) {
        try {
            lstBox.removeAll();
            DefaultListModel<String> objDLM = new DefaultListModel<>();

            while (rs.next()) {
                objDLM.addElement(rs.getString(1));
            }

            lstBox.setModel(objDLM);
            rs.close();
            rs = null;
        } catch (SQLException ex) {
            Logger.getLogger(ClsGUIContainers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fnAddSubForm(JInternalFrame objInt, JDesktopPane objDesk) {
        if (objInt.getParent() != objDesk) {
            objDesk.add(objInt);
            objInt.setClosable(true);
        }
    }

    public void fnShowInternalFormCenter(JInternalFrame objInt, JDesktopPane objDesk, boolean blnAtTop) {
        fnAddSubForm(objInt, objDesk);
        objInt.show();
        fnShowInternalFormMiddle(objDesk, objInt, blnAtTop);
    }

    public void fnShowDialogCenter(JDialog objDlg, JFrame objJFrame, boolean blnTopCenter) {
        fnShowInternalFormMiddle(objJFrame, objDlg, blnTopCenter);
        objDlg.setVisible(true);
    }

    public void fnShowInternalFormCenter(JInternalFrame objInt, JDesktopPane objDesk, int intWidth, int intHeight, boolean blnAtTop) {
        fnAddSubForm(objInt, objDesk);
        objInt.setBounds(0, 0, intWidth, intHeight);
        fnShowInternalFormMiddle(objDesk, objInt, blnAtTop);
        objInt.show();
    }

    public void fnShowInternalFormCorner(JInternalFrame objInt, JDesktopPane objDesk) {
        fnAddSubForm(objInt, objDesk);
        objInt.setLocation(0, 0);
        objInt.show();
    }

    public void fnShowInternalFormCorner(JInternalFrame objInt, JDesktopPane objDesk, int intWidth, int intHeight) {
        fnAddSubForm(objInt, objDesk);
        objInt.setBounds(0, 0, intWidth, intHeight);
        objInt.show();
    }

}

class myJXTable extends JXTable {

}
/*
 class MyCellRenderer implements TableCellRenderer {

 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
 boolean hasFocus, int row, int column) {
 JCheckBox chkBox;
 JLabel lbl;
 if (row == 0) {
 chkBox = new JCheckBox("Name");
 return chkBox;
 } else if (row == 1) {
 chkBox = new JCheckBox("Meaning");
 return chkBox;
 } else {
 lbl = new JLabel();
 return lbl;
 }
 }

 }

 class MyHeaderRenderer implements TableCellRenderer {

 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
 boolean hasFocus, int row, int column) {
 JPanel pnl;
 JCheckBox chkBox;
 JComboBox cboBox;
 JLabel lbl;
 if (row == -1) {
 chkBox = new JCheckBox("Name");
 cboBox = new JComboBox(new Object[]{"1", "2", "3"});
 pnl = new JPanel();
 pnl.add(cboBox);
 return pnl;
 } else {
 lbl = new JLabel();
 return lbl;
 }
 }
 }
 */
