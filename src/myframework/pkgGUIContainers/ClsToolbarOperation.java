/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIContainers;

/**
 *
 * @author Win97User
 */
public class ClsToolbarOperation {

    ClsToolbarOperation obj;

    ClsToolbarOperation() {
        obj = this;
    }

    public void fnCancelEvent(int _intCancelSubCmd_1, int _intCancelSubCmd_2) {
        blnCancelInbuildProcess = true;
        intCancelSubCmd_1 = _intCancelSubCmd_1;
        intCancelSubCmd_2 = _intCancelSubCmd_2;
    }
    public boolean blnCancelInbuildProcess = false;
    public int intCancelSubCmd_1;
    public int intCancelSubCmd_2;

    public ClsToolbarOperation fnReset() {
        blnCancelInbuildProcess = false;
        return this;
    }
}
