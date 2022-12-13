/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.prueba1.Busquedas;

import com.mycompany.prueba1.FramePrincipal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class ListarPorAutor extends javax.swing.JPanel {
    private final FramePrincipal framePrincipal;
    /**
     * Creates new form ListarAutor
     * @param framePrincipal
     */
    public ListarPorAutor(FramePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
    }

    private boolean first = true;
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        TipoBusqueda.setText("BÚSQUEDA POR NOMBRE DE AUTOR");
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
        NombreAutor.setText("Introduce un nombre de autor");
        NombreAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreAutorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 436, Short.MAX_VALUE)
                        .addComponent(ButtonBuscar))
                    .addComponent(NombreAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(ButtonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscar, NombreAutor});

    }// </editor-fold>//GEN-END:initComponents

    private void NombreAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMousePressed
        // TODO add your handling code here:
        if (first) {
            first = false;
            NombreAutor.setText("");
            NombreAutor.setForeground(new Color(0, 0, 0));
            NombreAutor.setEnabled(true);
        }
    }//GEN-LAST:event_NombreAutorMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if ("".equals(NombreAutor.getText())) {
            NombreAutor.setText("Introduce un nombre de autor");
            NombreAutor.setForeground(new Color(102, 102, 102));
            first = true;
            NombreAutor.setEnabled(false);
        }
    }//GEN-LAST:event_formMousePressed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        ArrayList<String> titulos = new ArrayList<>(Arrays.asList("La nave", "tres cuerpos", "sobrevivir","34","4234","La nave", "tres cuerpos", "sobrevivir","34","4234","La nave", "tres cuerpos", "sobrevivir","34","4234","La nave", "tres cuerpos", "sobrevivir","34","4234"));
        framePrincipal.titlelist(titulos);
    }//GEN-LAST:event_ButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JLabel TipoBusqueda;
    // End of variables declaration//GEN-END:variables
}
