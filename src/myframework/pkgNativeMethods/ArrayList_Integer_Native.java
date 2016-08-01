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
public class ArrayList_Integer_Native {

    private native void Init();

    private native void Init(int intInitiallSize);

    public native void Add(int intValue);

    public native int Get(int intIndex);

    public native void Replace(int intIndex, int intNewValue);

    public native void InsertAbove(int intIndexAbove, int intValue);

    public native void InsertBelow(int intIndexBelow, int intValue);

    public native void Delete(int intIndex);

    public native void DeleteAll();

    public native void Dispose();

    public ArrayList_Integer_Native() {
        Init();
    }

    public ArrayList_Integer_Native(int intCapasity) {
        Init(intCapasity);
    }
}
