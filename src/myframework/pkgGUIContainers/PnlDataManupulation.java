/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIContainers;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author Win97User
 */
public class PnlDataManupulation extends javax.swing.JPanel {

    JInternalFrame objIntFrame;

    public final int NONE_SUB_MODE_1 = 0;
    public final int NONE_SUB_MODE_2 = 0;
    public final int NONE_SAVE_MODE = 0;

    public int ACTIVE_SAVE_MODE;// = NONE_SUB_MODE_1;
    public int[] ACTIVE_SAVE_SUB_MODE = new int[2];// = NONE_SUB_MODE_1;
    public final int ADD_SAVE_MODE = 1;
    public final int EDIT_SAVE_MODE = 2;

    public final int ADD_COMMAND = 1;
    public final int EDIT_COMMAND = 2;
    public final int CANCEL_COMMAND = 3;
    public final int SAVE_COMMAND = 4;
    public final int DELETE_COMMAND = 5;
    public final int CLEAR_COMMAND = 6;
    public final int REFRESH_COMMAND = 7;
    public final int CLOSE_COMMAND = 8;
    public final int HIDE_COMMAND = 9;

    HashMap<Integer, JPopupMenu> hmSubCmdExist = new HashMap<>();
    HashMap<Integer, Integer> hmSelectedSubCmd = new HashMap<>();
    /**
     * Creates new form PnlDataManupulation
     */
    ArrayList<JComponent> alCtrls = null;
    ClsToolbarOperation ToolBarEvent = new ClsToolbarOperation();

    public PnlDataManupulation() {
        ACTIVE_SAVE_MODE = NONE_SAVE_MODE;
        ACTIVE_SAVE_SUB_MODE[0] = NONE_SUB_MODE_1;
        ACTIVE_SAVE_SUB_MODE[1] = NONE_SUB_MODE_2;

        hmSelectedSubCmd.put(ADD_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(EDIT_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(CANCEL_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(SAVE_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(DELETE_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(CLEAR_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(REFRESH_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(CLOSE_COMMAND, NONE_SUB_MODE_1);
        hmSelectedSubCmd.put(HIDE_COMMAND, NONE_SUB_MODE_1);

        initComponents();
    }

    public PnlDataManupulation(JToolBar tlBar, JInternalFrame objIFrm) {
        this();
        objIntFrame = objIFrm;
        tlBar.add(this);
        lblStatus.setText(fnGetStyledText("Just Opened"));
    }

    public PnlDataManupulation(JToolBar tlBar, JInternalFrame objIFrm, ArrayList<JComponent> _alCtrls) {
        this();
        alCtrls = _alCtrls;
        objIntFrame = objIFrm;
        tlBar.add(this);
        lblStatus.setText(fnGetStyledText("Just Opened"));
        fnSetEnblDsblDBFields(false);
    }

    public void fnSetEnblDsblControls(ArrayList<JComponent> _alCtrls) {
        alCtrls = _alCtrls;
    }

    private String fnGetStyledText(String strActivity) {
        //return "<html><font color = red>Last Activity</font> : <font color = green>"+strActivity+"</font></html>";
        return "<html><font color = green>" + strActivity + "</font></html>";
    }

    public void fnAddSubCommand(int intCommand, HashMap<Integer, String> commandMenu) {
        JPopupMenu pm = new JPopupMenu();
        commandMenu.forEach((Integer k, String v) -> {
            JMenuItem mni = new JMenuItem(v);
            pm.add(mni);

            switch (intCommand) {
                case ADD_COMMAND:
                    break;
                case EDIT_COMMAND:
                    mni.addActionListener((ActionEvent e) -> {
                        hmSelectedSubCmd.replace(EDIT_COMMAND, k);
                        fnEdit(null, k, NONE_SUB_MODE_2);
                    });
                    break;
                case CANCEL_COMMAND:
                    break;
                case SAVE_COMMAND:
                    break;
                case DELETE_COMMAND:
                    break;
                case CLEAR_COMMAND:
                    break;
                case REFRESH_COMMAND:
                    break;
                case CLOSE_COMMAND:
                    break;
                case HIDE_COMMAND:
                    break;
                default:
            }
        });
        switch (intCommand) {
            case ADD_COMMAND:
                break;
            case EDIT_COMMAND:
                pm.setInvoker(cmdEdit);
                hmSubCmdExist.put(EDIT_COMMAND, pm);
                break;
            case CANCEL_COMMAND:
                break;
            case SAVE_COMMAND:
                break;
            case DELETE_COMMAND:
                break;
            case CLEAR_COMMAND:
                break;
            case REFRESH_COMMAND:
                break;
            case CLOSE_COMMAND:
                break;
            case HIDE_COMMAND:
                break;
            default:
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cmdAdd = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdClear = new javax.swing.JButton();
        cmdRefresh = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdHide = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.GridBagLayout());

        cmdAdd.setText("Add");
        cmdAdd.setFocusable(false);
        cmdAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        add(cmdAdd, new java.awt.GridBagConstraints());

        cmdEdit.setText("Edit");
        cmdEdit.setFocusable(false);
        cmdEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });
        add(cmdEdit, new java.awt.GridBagConstraints());

        cmdCancel.setText("Cancel");
        cmdCancel.setEnabled(false);
        cmdCancel.setFocusable(false);
        cmdCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        add(cmdCancel, new java.awt.GridBagConstraints());

        cmdSave.setText("Save");
        cmdSave.setEnabled(false);
        cmdSave.setFocusable(false);
        cmdSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        add(cmdSave, new java.awt.GridBagConstraints());

        cmdClear.setText("Clear");
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        add(cmdClear, gridBagConstraints);

        cmdRefresh.setText("Refresh");
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });
        add(cmdRefresh, new java.awt.GridBagConstraints());

        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        add(cmdClose, gridBagConstraints);

        cmdHide.setText("Hide");
        cmdHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHideActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        add(cmdHide, gridBagConstraints);

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        add(cmdDelete, gridBagConstraints);

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        add(lblStatus, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fnAdd(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        ACTIVE_SAVE_MODE = ADD_SAVE_MODE;

        lblStatus.setText(fnGetStyledText("Add Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnAddNewRecordEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), NONE_SUB_MODE_1, NONE_SUB_MODE_2);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Add Operation Called"));
        if (ToolBarEvent.blnCancelInbuildProcess) {
            ACTIVE_SAVE_MODE = NONE_SAVE_MODE;
            return;
        }
        fnSetEnblDsblDBFields(true);
        fnSetEnblDsblDMLFields(false, false, true, true, false, false, false, false);
    }

    private void fnCancel(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        fnSetEnblDsblDBFields(false);
        fnSetEnblDsblDMLFields(true, true, false, false, true, true, true, true);

        lblStatus.setText(fnGetStyledText("Cancel Operation Initiated..."));
        //int intActiveSubCommand = 0;
        try {

            if (ACTIVE_SAVE_MODE == ADD_SAVE_MODE) {
                lblStatus.setText(fnGetStyledText("Add New Cancelled"));
                //              intActiveSubCommand = NONE_SUB_MODE_1;
            } else {
                lblStatus.setText(fnGetStyledText("Edit Cancelled"));
//                intActiveSubCommand = hmSelectedSubCmd.get(EDIT_COMMAND);
            }

            objIntFrame.getClass().getMethod("fnCancelEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), intSubCmd, intFlagReserved);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (ToolBarEvent.blnCancelInbuildProcess) {

        }
        ACTIVE_SAVE_MODE = NONE_SAVE_MODE;
        ACTIVE_SAVE_SUB_MODE[0] = NONE_SUB_MODE_1;
        ACTIVE_SAVE_SUB_MODE[1] = NONE_SUB_MODE_2;
    }

    private void fnSave(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        //int intActiveSubCommand = 0;
        fnSetEnblDsblDBFields(false);
        fnSetEnblDsblDMLFields(true, true, false, false, true, true, true, true);
        lblStatus.setText(fnGetStyledText("Save Operation Initiated..."));

        try {
            if (ACTIVE_SAVE_MODE == ADD_SAVE_MODE) {
                objIntFrame.getClass().getMethod("fnSaveNewRecordEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), intSubCmd, intFlagReserved);
                lblStatus.setText(fnGetStyledText("Save New Operation Called"));
                if (ToolBarEvent.blnCancelInbuildProcess) {

                }
            } else {
                //intActiveSubCommand = hmSelectedSubCmd.get(EDIT_COMMAND);
                objIntFrame.getClass().getMethod("fnSaveExistingRecordEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), intSubCmd, intFlagReserved);
                lblStatus.setText(fnGetStyledText("Update Operation Called"));
                if (ToolBarEvent.blnCancelInbuildProcess) {

                }
            }
            ACTIVE_SAVE_MODE = NONE_SAVE_MODE;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fnDelete(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        lblStatus.setText(fnGetStyledText("Delete Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnDeleteRecordEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), -1, -1);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Delete Operation Called"));
        if (ToolBarEvent.blnCancelInbuildProcess) {

        }
    }

    private void fnClear(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        lblStatus.setText(fnGetStyledText("Clear Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnClearEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), -1, -1);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Clear Operation Called"));
        if (!ToolBarEvent.blnCancelInbuildProcess) {
            if (alCtrls != null) {
                for (int iCount = 0; iCount < alCtrls.size(); iCount++) {
                    switch (alCtrls.get(iCount).getClass().getTypeName()) {
                        case "javax.swing.JTextArea":
                            ((JTextArea) alCtrls.get(iCount)).setText("");
                            break;
                        case "javax.swing.JTextField":
                            ((JTextField) alCtrls.get(iCount)).setText("");
                            break;
                        default:
                    }
                }
            }
        }
    }

    private void fnRefresh(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        lblStatus.setText(fnGetStyledText("Refresh Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnReloadEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), -1, -1);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Refresh Operation Called"));
        if (ToolBarEvent.blnCancelInbuildProcess) {

        }
    }

    private void fnClose(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {
        // TODO add your handling code here:
        lblStatus.setText(fnGetStyledText("Close Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnCloseEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), -1, -1);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Close Operation Called"));
        if (ToolBarEvent.blnCancelInbuildProcess) {
            objIntFrame.doDefaultCloseAction();
        }
    }

    private void fnHide(java.awt.event.ActionEvent evt, int intSubCmd, int intFlagReserved) {

    }
    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        // TODO add your handling code here:
        JPopupMenu pm = hmSubCmdExist.get(ADD_COMMAND);
        if (pm == null) {
            fnAdd(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdAdd);
        }
    }//GEN-LAST:event_cmdAddActionPerformed

    private void fnEdit(java.awt.event.ActionEvent evt, int intSubMode_1, int intSubMode_2) {
        // TODO add your handling code here:
        ACTIVE_SAVE_MODE = EDIT_SAVE_MODE;
        ACTIVE_SAVE_SUB_MODE[0] = intSubMode_1;
        ACTIVE_SAVE_SUB_MODE[1] = intSubMode_2;

        lblStatus.setText(fnGetStyledText("Edit Operation Initiated..."));
        try {
            objIntFrame.getClass().getMethod("fnEditExitingRecordEvent", ClsToolbarOperation.class, int.class, int.class).invoke(objIntFrame, ToolBarEvent.fnReset(), intSubMode_1, intSubMode_2);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PnlDataManupulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblStatus.setText(fnGetStyledText("Edit Operation Called"));
        if (ToolBarEvent.blnCancelInbuildProcess) {
            ACTIVE_SAVE_MODE = NONE_SAVE_MODE;
            ACTIVE_SAVE_SUB_MODE[0] = NONE_SUB_MODE_1;
            ACTIVE_SAVE_SUB_MODE[1] = NONE_SUB_MODE_2;
            return;
        }
        fnSetEnblDsblDBFields(true);
        fnSetEnblDsblDMLFields(false, false, true, true, false, false, false, false);
    }

    private void fnShowPopupMenu(JPopupMenu pm, JButton cmd) {
        pm.show(cmd, cmd.getX(), cmd.getY() + cmd.getHeight());
    }

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        JPopupMenu pm = hmSubCmdExist.get(EDIT_COMMAND);
        if (pm == null) {
            fnEdit(evt, NONE_SUB_MODE_1, NONE_SUB_MODE_2);
        } else {
            fnShowPopupMenu(pm, cmdEdit);
        }
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        JPopupMenu pm = hmSubCmdExist.get(CANCEL_COMMAND);
        if (pm == null) {
            fnCancel(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdCancel);
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        // TODO add your handling code here:
        JPopupMenu pm = hmSubCmdExist.get(SAVE_COMMAND);
        if (pm == null) {
            fnSave(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdSave);
        }
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        JPopupMenu pm = hmSubCmdExist.get(CLOSE_COMMAND);
        if (pm == null) {
            fnClose(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdClose);
        }
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        // TODO add your handling code here:
        JPopupMenu pm = hmSubCmdExist.get(CLEAR_COMMAND);
        if (pm == null) {
            fnClear(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdClear);
        }
    }//GEN-LAST:event_cmdClearActionPerformed

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        // TODO add your handling code here:
        fnRefresh(evt);
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void cmdHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHideActionPerformed
        // TODO add your handling code here:
        objIntFrame.setVisible(false);
    }//GEN-LAST:event_cmdHideActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        // TODO add your handling code here:
        JPopupMenu pm = hmSubCmdExist.get(DELETE_COMMAND);
        if (pm == null) {
            fnDelete(evt, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdDelete);
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    public void fnRefresh(java.awt.event.ActionEvent e) {
        JPopupMenu pm = hmSubCmdExist.get(REFRESH_COMMAND);
        if (pm == null) {
            fnRefresh(e, -1, -1);
        } else {
            fnShowPopupMenu(pm, cmdRefresh);
        }
    }

    private void fnSetEnblDsblDBFields(boolean blnCtrl) {
        if (alCtrls != null) {
            for (int iCount = 0; iCount < alCtrls.size(); iCount++) {
                alCtrls.get(iCount).setEnabled(blnCtrl);
            }
        }
    }

    private void fnSetEnblDsblDMLFields(boolean blnAdd, boolean blnEdit, boolean blnCancel, boolean blnSave, boolean blnDelete, boolean blnClear, boolean blnRefresh, boolean blnClose) {
        cmdAdd.setEnabled(blnAdd);
        cmdEdit.setEnabled(blnEdit);
        cmdCancel.setEnabled(blnCancel);
        cmdSave.setEnabled(blnSave);
        cmdDelete.setEnabled(blnDelete);
        cmdClear.setEnabled(blnClear);
        cmdRefresh.setEnabled(blnRefresh);
        cmdClose.setEnabled(blnClose);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdClear;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdHide;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
