/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework;

/**
 *
 * @author userlinuxmint14
 */
public class FrmItemDetails extends javax.swing.JPanel {

    /**
     * Creates new form FrmItemDetails
     */
    private static FrmItemDetails objFrm=null;
    
    public FrmItemDetails() {
        initComponents();
    }
    
    public static FrmItemDetails getMe()
    {
        if(objFrm==null)
        {
            objFrm = new FrmItemDetails();
        }
        return objFrm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}