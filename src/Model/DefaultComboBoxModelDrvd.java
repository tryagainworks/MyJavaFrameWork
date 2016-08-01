/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Win97User
 * @param <E>
 */
public class DefaultComboBoxModelDrvd<E, T> extends DefaultComboBoxModel<E> {

    ArrayList<T> arlID;

    public DefaultComboBoxModelDrvd(boolean blnNeedId) {
        if (blnNeedId) {
            arlID = new ArrayList<>();
        }
    }

    public void addElementWithID(E element, T idElement) {
        super.addElement(element);
        arlID.add(idElement);
    }

    public ArrayList<Object> getElementAtWithID(int index) {
        ArrayList<Object> arlList = new ArrayList<>(2);
        arlList.add(super.getElementAt(index));
        arlList.add(arlID.get(index));
        return arlList;
    }

    public ArrayList<Object> getSelectedItemWithID(int index) {
        ArrayList<Object> arlList = new ArrayList<>(2);
        arlList.add(super.getSelectedItem());
        arlList.add(arlID.get(index));
        return arlList;
    }

    public T getComboId(int Index) {
        return arlID.get(Index);
    }
}
