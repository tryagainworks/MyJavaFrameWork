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
public class ClsCreateHeaderFile {

    static {
        System.load("D:\\MyApps\\NetBeansProjects\\MyCFrameWork\\dist\\Debug\\MinGW_32-Windows\\libMyCFrameWork.dll");
    }

    public native String fnCreateGetHeaderFileName 
        (String strJavaFile, String strJavahEXEPath, String strOutputTempFolder, String strOutputTempFile, String strClassPath, String strPackage, String strClass, boolean blnAppendDateTime);

    public native boolean fnIsFileExist 
        (String strFileNameWithFullPath);

    public native boolean fnOverWriteFile 
        (String strSourceFileNameWithFullPath, String strTargetFileNameWithFullPath);

    public native boolean fnCopyFileByRenameExisting 
        (String strSourceFileNameWithFullPath, String strTargetFileNameWithFullPath);

    public native clsProfile[] fnGetAllProfileNames 
        ();

    public native clsProfileData fnGetSelectedProfile 
        (int intProfileId);
    
    public native int fnCreateNewProfile 
        (String strProfile);
    
    public native boolean fnSaveProfileData 
        (int intProfileID,clsProfileData objProfileData);
    
    public native boolean fnDeleteProfile 
        (int intProfileID);

    public native void fnTest 
        ();

    public native boolean fnRenameProfile 
        (int intProfileID,String strNewProfileName);

    public class clsProfile {

        public String strProfileName;
        public int intProfileID;
    } 

    public class clsProfileData {

        public String strJavahExePath;
        public String strOutDirPath;
        public String strClassPath;
        public String strPkgName;
        public String strClassName;
        public String strNameOfFiles;
        public String strJNIHeader;
        public String strJNISource;
        public String strClassHeader;
        public String strClassSoruce;
        public boolean blnOverWrite;
        public boolean blnApndDateTime;
    }
}
