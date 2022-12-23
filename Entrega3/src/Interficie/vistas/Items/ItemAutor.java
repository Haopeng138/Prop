/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Items;

import Interficie.vistas.FramePrincipal;
import Interficie.vistas.VentanaSecundaria.VentTitulos;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author linhaopeng
 */
public class ItemAutor extends javax.swing.JPanel {
    private FramePrincipal framePrincipal;
    
    private VentTitulos titulosframe = null;
    /**
     * Creates new form AutorItem
     * @param framePrincipal
     * @param Autor
     */
    public ItemAutor(FramePrincipal framePrincipal,String Autor) {
        initComponents();
        NombreAutor.setText(Autor);
        this.framePrincipal = framePrincipal;
        this.titulosframe = null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AutorLabel = new javax.swing.JLabel();
        NombreAutor = new javax.swing.JLabel();
        ButtonVerObras = new javax.swing.JButton();

        AutorLabel.setText("Autor :");

        NombreAutor.setText("jLabel2");

        ButtonVerObras.setText("Ver Sus Obras");
        ButtonVerObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVerObrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(AutorLabel)
                .addGap(18, 18, 18)
                .addComponent(NombreAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonVerObras)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutorLabel)
                    .addComponent(NombreAutor)
                    .addComponent(ButtonVerObras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonVerObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVerObrasActionPerformed
        // TODO add your handling code here:
        ArrayList<String> titulos = framePrincipal.getTitulos(NombreAutor.getText());
        
            
            titulosframe = new VentTitulos(this.framePrincipal,NombreAutor.getText(),titulos);
            titulosframe.setVisible(true);
            //Center the frame
            titulosframe.setLocationRelativeTo(null);
            
        
        
        
    }//GEN-LAST:event_ButtonVerObrasActionPerformed
    
    
    public void closeItemTitulo() {
        if (titulosframe != null) {
            titulosframe.dispose();
            titulosframe = null;
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AutorLabel;
    private javax.swing.JButton ButtonVerObras;
    private javax.swing.JLabel NombreAutor;
    // End of variables declaration//GEN-END:variables
}
