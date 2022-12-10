/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.prueba1.Busquedas;

import com.mycompany.prueba1.DocumentHeaderDemo;
import com.mycompany.prueba1.VentanaSecundaria.VentAñadirAliaExpre;
import com.mycompany.prueba1.framePrincipal;
import java.awt.Color;
import java.util.ArrayList;

public class ListarPorExpresion extends javax.swing.JPanel {
     private final framePrincipal framePrincipal;
    /**
     * Creates new form ListarPorExpresion
     */
     
    VentAñadirAliaExpre v;
    public ListarPorExpresion(framePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
        //v = new VentAñadirAliaExpre();
        //this.add(v);
    }
    private boolean firstA = true;
    private boolean firstE = true;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AliasExist = new javax.swing.JComboBox<>();
        TipoBusqueda = new javax.swing.JLabel();
        ButtonBuscar = new javax.swing.JButton();
        Expresion = new javax.swing.JTextField();
        NombreAutor = new javax.swing.JTextField();
        TextAlias = new javax.swing.JLabel();
        ButtonAñadir = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        AliasExist.setSelectedItem(null);
        AliasExist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AliasExistActionPerformed(evt);
            }
        });

        TipoBusqueda.setText("BÚSQUEDA POR EXPRESIÓN BOOLEANA");
        TipoBusqueda.setToolTipText("");

        ButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonBuscar.setLabel("Buscar");
        ButtonBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        Expresion.setForeground(new java.awt.Color(102, 102, 102));
        Expresion.setText("Introduce una expresión booleana");
        Expresion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExpresionMousePressed(evt);
            }
        });

        NombreAutor.setForeground(new java.awt.Color(102, 102, 102));
        NombreAutor.setText("Introduce una alia");
        NombreAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreAutorMousePressed(evt);
            }
        });

        TextAlias.setText("Busca una alia existente:");

        ButtonAñadir.setText("Guardar");
        ButtonAñadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonAñadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonAñadirMousePressed(evt);
            }
        });
        ButtonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(NombreAutor)
                    .addComponent(AliasExist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Expresion, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextAlias)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonAñadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBuscar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ButtonAñadir, ButtonBuscar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AliasExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Expresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonAñadir)
                    .addComponent(ButtonBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AliasExist, Expresion, NombreAutor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonAñadir, ButtonBuscar});

    }// </editor-fold>//GEN-END:initComponents

    private void AliasExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AliasExistActionPerformed
                // TODO add your handling code here:
                AliasExist.removeAll();
    }//GEN-LAST:event_AliasExistActionPerformed

    private void NombreAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMousePressed
        // TODO add your handling code here:
        if (firstA) {
              firstA = false;
              NombreAutor.setEnabled(true);
              NombreAutor.setText("");
              NombreAutor.setForeground(new Color(0, 0, 0));
          }
    }//GEN-LAST:event_NombreAutorMousePressed

    private void ExpresionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpresionMousePressed
        // TODO add your handling code here:
        if (firstE) {
              firstE = false;
              Expresion.setEnabled(true);
              Expresion.setText("");
              Expresion.setForeground(new Color(0, 0, 0));
          }
    }//GEN-LAST:event_ExpresionMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if ("".equals(NombreAutor.getText())) {
            NombreAutor.setText("Introduce una alia");
            NombreAutor.setForeground(new Color(102, 102, 102));
            firstA = true;
            NombreAutor.setEnabled(false);
        }
        
        if ("".equals(Expresion.getText())) {
            Expresion.setText("Introduce un nombre de autor");
            Expresion.setForeground(new Color(102, 102, 102));
            firstE = true;
            Expresion.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_formMousePressed

    private void ButtonAñadirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAñadirMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAñadirMousePressed

    private void ButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAñadirActionPerformed
        // TODO add your handling code here:
        int x = (this.getWidth()/2) - (v.getWidth()/2);
        int y = (this.getHeight()/2) - (v.getHeight()/2);
        v.setLocation(x, y);
        v.show();
        
    }//GEN-LAST:event_ButtonAñadirActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        ArrayList<DocumentHeaderDemo> documentHeaders = new ArrayList<DocumentHeaderDemo>();
        documentHeaders.add(new DocumentHeaderDemo("auto","tile"));
        documentHeaders.add(new DocumentHeaderDemo("autosgf","tilfdgsfde"));
        documentHeaders.add(new DocumentHeaderDemo("autogfdsg","tgfdigdfgle"));
        documentHeaders.add(new DocumentHeaderDemo("autgfdso","tigsdfgsdfle"));
        framePrincipal.documentlist(documentHeaders);
    }//GEN-LAST:event_ButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AliasExist;
    private javax.swing.JButton ButtonAñadir;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField Expresion;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JLabel TextAlias;
    private javax.swing.JLabel TipoBusqueda;
    // End of variables declaration//GEN-END:variables
}
