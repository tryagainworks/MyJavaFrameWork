/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIControls;

import myframework.pkgGUIContainers.ClsToolbarOperation;

/**
 *
 * @author Win97User
 */
public interface ToolbarInterface {

    public void fnAddNewRecordEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnEditExitingRecordEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnSaveNewRecordEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnReloadEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnSaveExistingRecordEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnClearEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnCancelEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnCloseEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);

    public void fnDeleteRecordEvent(ClsToolbarOperation obj, int intSubCmd_1, int intSubCmd_2);
}
