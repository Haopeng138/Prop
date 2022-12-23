/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Busquedas;


import Interficie.vistas.VentanaSecundaria.VentAñadirAliaExpre;
import Interficie.vistas.FramePrincipal;

import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class ListarPorExpresion extends javax.swing.JPanel {
     private final FramePrincipal framePrincipal;
     private VentAñadirAliaExpre ventAñadirAliaExpre;
    /**
     * Creates new form ListarPorExpresion
     * @param framePrincipal
     */
     
    public ListarPorExpresion(FramePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
        ArrayList<String> combo = framePrincipal.getAlias();
        AliasExist.setBounds(159, 81, 189, 41);
        AliasExist.removeAllItems();
        AliasExist.addItem("Selecciona una alia existente");
        AliasExist.setSelectedItem("Selecciona una alia existente");
        for (String c :combo){
            AliasExist.addItem(c);
        }
        
    }
    private boolean firstA = true;
    private boolean firstE = true;

    public String getExpresion(){
        return Expresion.getText();
    }
    public void closeAñadirAliaExpre(){
        ventAñadirAliaExpre = null;
    }

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
        NombreAlia = new javax.swing.JTextField();
        TextAlias = new javax.swing.JLabel();
        ButtonGuardar = new javax.swing.JButton();
        tipoOrdenacion = new javax.swing.JLabel();
        criterioOrdenar = new javax.swing.JComboBox<>();

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

        NombreAlia.setForeground(new java.awt.Color(102, 102, 102));
        NombreAlia.setText("Introduce una alia");
        NombreAlia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreAliaMousePressed(evt);
            }
        });

        TextAlias.setText("Busca una alia existente:");

        ButtonGuardar.setText("Guardar");
        ButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonGuardarMousePressed(evt);
            }
        });
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        tipoOrdenacion.setText("Ordenar por:");

        criterioOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "autor A-Z", "título A-Z" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(NombreAlia)
                    .addComponent(AliasExist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Expresion, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextAlias)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tipoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBuscar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ButtonBuscar, ButtonGuardar});

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
                .addComponent(NombreAlia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Expresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonGuardar)
                    .addComponent(ButtonBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipoOrdenacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AliasExist, Expresion, NombreAlia});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscar, ButtonGuardar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {criterioOrdenar, tipoOrdenacion});

    }// </editor-fold>//GEN-END:initComponents

    private void AliasExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AliasExistActionPerformed
        // TODO add your handling code here:
        AliasExist.removeAll();
    }//GEN-LAST:event_AliasExistActionPerformed

    private void NombreAliaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAliaMousePressed
        // TODO add your handling code here:
        if (firstA) {
              firstA = false;
              NombreAlia.setEnabled(true);
              NombreAlia.setText("");
              NombreAlia.setForeground(new Color(0, 0, 0));
          }
    }//GEN-LAST:event_NombreAliaMousePressed

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
        if ("".equals(NombreAlia.getText())) {
            NombreAlia.setText("Introduce una alia");
            NombreAlia.setForeground(new Color(102, 102, 102));
            firstA = true;
            NombreAlia.setEnabled(false);
        }
        
        if ("".equals(Expresion.getText())) {
            Expresion.setText("Introduce una expresion");
            Expresion.setForeground(new Color(102, 102, 102));
            firstE = true;
            Expresion.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_formMousePressed

    private void ButtonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonGuardarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonGuardarMousePressed

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
        // TODO add your handling code here:
        ventAñadirAliaExpre = new VentAñadirAliaExpre(this.framePrincipal,this); 
        ventAñadirAliaExpre.setVisible(true);
        ventAñadirAliaExpre.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_ButtonGuardarActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        String alia=null;
        if(AliasExist.getSelectedItem().toString().equals("Selecciona una alia existente")){
            if (!NombreAlia.getText().equals("Introduce una alia")
                    && !NombreAlia.getText().equals("")
                    && !Expresion.getText().equals("Introduce una expresion")
                    && !Expresion.getText().equals("")) {
                //
                String expresion = Expresion.getText();
                alia = NombreAlia.getText();
                try {
                    this.framePrincipal.addExpresion(alia, expresion);
                    System.out.println(alia);
                    this.framePrincipal.buscarPorAlia(alia);
                } catch (Exception e) {
                    System.out.println("entro en excep");
                    if (e.getMessage().equals("Error añadiendo alia")) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error no clasificado");
                    }

                }
            }else{
                JOptionPane.showMessageDialog(null, "Introduce alia y expresion");
            }

        }else{
            alia = AliasExist.getSelectedItem().toString();
            this.framePrincipal.buscarPorAlia(alia);
        }


    }//GEN-LAST:event_ButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AliasExist;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JTextField Expresion;
    private javax.swing.JTextField NombreAlia;
    private javax.swing.JLabel TextAlias;
    private javax.swing.JLabel TipoBusqueda;
    private javax.swing.JComboBox<String> criterioOrdenar;
    private javax.swing.JLabel tipoOrdenacion;
    // End of variables declaration//GEN-END:variables
}
