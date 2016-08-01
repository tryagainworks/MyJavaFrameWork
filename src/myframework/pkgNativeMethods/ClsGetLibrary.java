/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgNativeMethods;

/**
 *
 * @author Win97User
 */
public class ClsGetLibrary {

    public static void fnGetLoadLibrary(String strLibNameWithoutExtn) {
        System.out.println("a for apple");
        String strLibraryFullPath;
        if (System.getProperty("os.name").equals("Linux")) {
            strLibraryFullPath = ClsNativeMethods.class.getResource("/CLibs/" + strLibNameWithoutExtn + ".so").getPath();
        } else {
            strLibraryFullPath = ClsNativeMethods.class.getResource("\\CLibs\\" + strLibNameWithoutExtn + ".dll").getPath();
        }
        System.load(strLibraryFullPath);
    }

    
    static {
        //fnGetLoadLibrary("libMyCFrameWork");
    }
    
}
