/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgValidations;

/**
 *
 * @author userlinuxmint14
 */
public class ClsValidation {
    private static ClsValidation objCls=null;
    public ClsValidation(){
        
    }
    
    public static ClsValidation Self(){
        if(objCls==null){
            objCls = new ClsValidation();
        }
        return objCls;
    }
    public String fnEmptyStringIfNull(String str){
        return (str==null? "" : str);
    }
    
}
