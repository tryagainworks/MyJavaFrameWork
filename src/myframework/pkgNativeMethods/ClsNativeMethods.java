/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgNativeMethods;

import java.awt.Point;

/**
 *
 * @author linuxmintuser02
 */
public class ClsNativeMethods {

    private static ClsNativeMethods obj;

    public ClsNativeMethods() {

    }
/*
    static {

        String strCLibPath = "";
        if (System.getProperty("os.name").equals("Linux")) {
            
            strCLibPath = ClsNativeMethods.class.getResource("/CLibs/libliblinuxOS.so").getPath();
            
        } else {
            strCLibPath = ClsNativeMethods.class.getResource("\\Libs\\libliblinuxOS.dll").getPath();
        }
        System.load(strCLibPath);
    }*/

    public static ClsNativeMethods self() {
        if (obj == null) {
            obj = new ClsNativeMethods();

            return obj;
        } else {
            return obj;
        }

    }

    public native void fnGetMousePointerXYLocations(Point obj, int intTest);

    public native int fnGetMousePointerXLocations();

    public native int fnGetMousePointerYLocations();
}
