/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIContainers;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win97User
 */
public class MyDefaultTableModel extends DefaultTableModel {
        int[] intEditableCols;
        public MyDefaultTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
            super(data, columnNames);
        }
        public MyDefaultTableModel(Vector<Vector<Object>> data, Vector<String> columnNames, int[] _intEditableCols) {
            super(data, columnNames);
            intEditableCols = _intEditableCols;
        }
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (this.getRowCount() != 0) {
                if (getValueAt(0, columnIndex).getClass() != null) {
                    return getValueAt(0, columnIndex).getClass();
                } else {
                    return String.class;
                }
            }
            return String.class;
        }
        @Override
        public boolean isCellEditable(int row, int col) {
            if (this.getRowCount() != 0) {
                if (getValueAt(row, col).getClass() != null) {

                    if (intEditableCols != null) {
                        for (int iCount = 0; iCount < intEditableCols.length; iCount++) {
                            if (col == intEditableCols[iCount]) {
                                return true;
                            }
                        }
                    }
                    return false;

                } else {
                    return false;
                }
            }
            return false;
        }
    }
