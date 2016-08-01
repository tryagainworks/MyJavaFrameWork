/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Win97User
 * @param <E>
 */
public class DefaultListModelDrvd<E, T> extends DefaultListModel<E> {

    ArrayList<T> arlID;

    public DefaultListModelDrvd(boolean blnNeedId) {
        if (blnNeedId) {
            arlID = new ArrayList<>();
        }
    }

    public void addWithID(int Index, E listElement, T idElement) {
        super.add(Index, listElement);
        arlID.add(Index, idElement);
    }

    public void addElementWithID(E element, T idElement) {
        super.addElement(element);
        arlID.add(idElement);
    }

    public ArrayList<Object> setWithID(int Index, E element, T idElement) {
        ArrayList<Object> arlList = new ArrayList<>(2);
        arlList.add(super.set(Index, element));
        arlList.add(arlID.set(Index, idElement));
        return arlList;
    }

    public ArrayList<Object> getWithID(int Index) {
        ArrayList<Object> arlList = new ArrayList<>(2);
        arlList.add(super.get(Index));
        arlList.add(arlID.get(Index));
        return arlList;
    }

    public T getListId(int Index) {
        return arlID.get(Index);
    }
}
