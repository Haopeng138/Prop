/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Busquedas;

import Interficie.vistas.FramePrincipal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

public class ListarPorPrefijo extends javax.swing.JPanel {
    private final FramePrincipal framePrincipal;
    private boolean first = true;
    /**
     * Creates new form ListarPorTitulo
     * @param framePrincipal
     */
    public ListarPorPrefijo(FramePrincipal framePrincipal) {
        initComponents();
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

        TipoBusqueda = new javax.swing.JLabel();
        ButtonBuscar = new javax.swing.JButton();
        NombreAutor = new javax.swing.JTextField();
        tipoOrdenacion = new javax.swing.JLabel();
        criterioOrdenar = new javax.swing.JComboBox<>();

        TipoBusqueda.setText("BÚSQUEDA POR PREFIJO");
        TipoBusqueda.setToolTipText("");

        ButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonBuscar.setLabel("Buscar");
        ButtonBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        NombreAutor.setForeground(new java.awt.Color(102, 102, 102));
        NombreAutor.setText("Introduce un prefijo");
        NombreAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreAutorMousePressed(evt);
            }
        });

        tipoOrdenacion.setText("Ordenar por:");

        criterioOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "autor A-Z", "relevancia" }));
        criterioOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criterioOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tipoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonBuscar))
                    .addComponent(NombreAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipoOrdenacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscar, NombreAutor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {criterioOrdenar, tipoOrdenacion});

    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        String prefijo = NombreAutor.getText();
        if ("Introduce un prefijo".equals(prefijo)) JOptionPane.showMessageDialog(null, "Introduce un prefijo!!!");
        else {
            if ("".equals(prefijo)) {
                prefijo = "";
            }
            ArrayList<String> autores = framePrincipal.buscarPorPrefijo(prefijo);
            Collections.sort(autores);
            framePrincipal.autorlist(autores);
        }
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void NombreAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMousePressed
        // TODO add your handling code here:
        if (first) {
            first = false;
            NombreAutor.setText("");
            NombreAutor.setForeground(new Color(0, 0, 0));
            NombreAutor.setEnabled(true);
        }
    }//GEN-LAST:event_NombreAutorMousePressed

    private void criterioOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criterioOrdenarActionPerformed
        // TODO add your handling code here:
        String prefijo = NombreAutor.getText();
        if ("Introduce un prefijo".equals(prefijo)) JOptionPane.showMessageDialog(null, "Introduce un prefijo!!!");
        else {
            if ("".equals(prefijo)) prefijo = "";
            
            ArrayList<String> autores = framePrincipal.buscarPorPrefijo(prefijo);
            if (autores.isEmpty()) JOptionPane.showMessageDialog(null, "No existe ningun autor con este prefijo");
            else {
                if("relevancia".equals(criterioOrdenar.getSelectedItem().toString())){
                    autores = framePrincipal.ordenaRelevanciaAutor(prefijo);
                }
                else Collections.sort(autores);
                framePrincipal.autorlist(autores);
            }
        }
    }//GEN-LAST:event_criterioOrdenarActionPerformed
     
    public void reload(){
        String prefijo = NombreAutor.getText();
        ArrayList<String> autores = framePrincipal.buscarPorPrefijo(prefijo);
        Collections.sort(autores);    
        framePrincipal.autorlist(autores);
       
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JLabel TipoBusqueda;
    private javax.swing.JComboBox<String> criterioOrdenar;
    private javax.swing.JLabel tipoOrdenacion;
    // End of variables declaration//GEN-END:variables
}
