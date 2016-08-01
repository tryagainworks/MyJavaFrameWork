/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.drawing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Windows2K
 */
public class ClsDrawRectangle {

    int intFixedXPosition = -1;
    int intFixedYPosition = -1;
    int intPreviousXPosition = -1;
    int intPreviousYPosition = -1;

    public int intCurrentDrawWidth = 0;
    public int intCurrentDrawHeight = 0;
    int intPreviousDrawWidth = 0;
    int intPreviousDrawHeight = 0;

    public int intX = 0;
    public int intY = 0;

    Graphics objGraphics;

    public ClsDrawRectangle() {
        intFixedXPosition = -1;
        intFixedYPosition = -1;
        intPreviousXPosition = -1;
        intPreviousYPosition = -1;

        intCurrentDrawWidth = 0;
        intCurrentDrawHeight = 0;
        intPreviousDrawWidth = 0;
        intPreviousDrawHeight = 0;

        intX = 0;
        intY = 0;

        objGraphics = null;
    }

    public void FnStartDrawingRect(JComponent objCtrl, java.awt.event.MouseEvent evt, Color PenColor) {
        objGraphics = objCtrl.getGraphics();
        objGraphics.setColor(PenColor);
        

        //blnMousePressed = true;
        intFixedXPosition = evt.getX();
        intFixedYPosition = evt.getY();
    }

    public void FnDrawRectangle(JComponent objCtrlToDrawInto, JLabel objCtrlToDispCoordinates, java.awt.event.MouseEvent evt) {
        FnDrawRectangle(objCtrlToDrawInto, evt);
        objCtrlToDispCoordinates.setText("X = " + intX + ", Y = " + intY + ", Width = " + intCurrentDrawWidth + ", Height = " + intCurrentDrawHeight);
    }

    public void FnDrawRectangle(JComponent objCtrlToDrawInto, java.awt.event.MouseEvent evt) {
        //repainting the 4 lines of a rectangle (Performance :-))
        objCtrlToDrawInto.paintImmediately(intPreviousXPosition, intPreviousYPosition, intPreviousDrawWidth + 1, 1);
        objCtrlToDrawInto.paintImmediately(intPreviousXPosition, intPreviousYPosition, 1, intPreviousDrawHeight + 1);
        objCtrlToDrawInto.paintImmediately(intPreviousXPosition + intPreviousDrawWidth, intPreviousYPosition, 1, intPreviousDrawHeight + 1);
        objCtrlToDrawInto.paintImmediately(intPreviousXPosition, intPreviousDrawHeight + intPreviousYPosition, intPreviousDrawWidth + 1, 1);
        //Full rect
        //lblScreenPreview.paintImmediately(intPreviousXPosition, intPreviousYPosition, intPreviousDrawWidth + 1, intPreviousDrawHeight + 1);

        if (evt.getX() >= intFixedXPosition) {
            intCurrentDrawWidth = evt.getX() - intFixedXPosition;
            intX = intFixedXPosition;
            intPreviousXPosition = intX;
        } else {
            intX = evt.getX();
            intPreviousXPosition = intX;
            intCurrentDrawWidth = intFixedXPosition - intX;

        }

        if (evt.getY() >= intFixedYPosition) {
            intCurrentDrawHeight = evt.getY() - intFixedYPosition;
            intY = intFixedYPosition;
            intPreviousYPosition = intY;
        } else {
            intY = evt.getY();
            intPreviousYPosition = intY;
            intCurrentDrawHeight = intFixedYPosition - intY;
        }

        intPreviousDrawWidth = intCurrentDrawWidth;
        intPreviousDrawHeight = intCurrentDrawHeight;

        //lblScreenPreview.paintImmediately(intFixedXPosition, intFixedYPosition, intPreviousDrawWidth + 1, intPreviousDrawHeight + 1);
        objGraphics.drawRect(intX, intY, intCurrentDrawWidth, intCurrentDrawHeight);
    }

}
