/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Items;

import Interficie.vistas.FramePrincipal;
import Interficie.vistas.VentanaSecundaria.VentInfoDoc;
import java.util.ArrayList;

/**
 *
 * @author linhaopeng
 */
public class ItemTitulo extends javax.swing.JPanel {
    private FramePrincipal framePrincipal;
    /**
     * Creates new form TituloItem
     * @param framePrincipal
     * @param titulo
     */
    private String autor;
    public ItemTitulo(FramePrincipal framePrincipal,String titulo, String autor) {
        
        initComponents();
        this.autor = autor;
        jLabel2.setText(titulo);
        this.framePrincipal = framePrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ButtonVer = new javax.swing.JButton();

        jLabel1.setText("Titulo:");

        jLabel2.setText("jLabel2");

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonVer.setText("Ver");
        ButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(ButtonVer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonVer, jButton1, jLabel1, jLabel2});

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> titulos = framePrincipal.getTitulos(autor);
        framePrincipal.eliminarDoc(jLabel2.getText(), autor);
       
        if (titulos.size() == 1) framePrincipal.reload("prefijo");
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVerActionPerformed
        // TODO add your handling code here:
        
        VentInfoDoc infoDoc = new VentInfoDoc(this.framePrincipal, autor,jLabel2.getText());
        infoDoc.setVisible(true);
        //Center the frame
        infoDoc.setLocationRelativeTo(null);
    }//GEN-LAST:event_ButtonVerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonVer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
