/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prueba1.VentanaSecundaria;

import com.mycompany.prueba1.FramePrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class VentAñadirAliaPrin extends javax.swing.JFrame {
    private FramePrincipal framePrincipal;
    /**
     * Creates new form VentAñadirAliaPrin
     * @param framePrincipal
     */
    public VentAñadirAliaPrin(FramePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                framePrincipal.closeAñadirAlia();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonCancelar1 = new javax.swing.JButton();
        ButtonAñadir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Añadir una nueva alia:");

        jLabel5.setText("Nombre de alia:");

        ButtonCancelar1.setText("Cancelar");
        ButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelar1ActionPerformed(evt);
            }
        });

        ButtonAñadir.setText("Añadir");
        ButtonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAñadirActionPerformed(evt);
            }
        });

        jLabel1.setText("Expresión booleana:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonAñadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonCancelar1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancelar1)
                    .addComponent(ButtonAñadir))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel5, jTextField1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelar1ActionPerformed

        dispose();
        framePrincipal.closeAñadirAlia();
    }//GEN-LAST:event_ButtonCancelar1ActionPerformed

    private void ButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAñadirActionPerformed
        // TODO add your handling code here:
         System.out.print("algo");
        if ("".equals(jTextArea1.getText()) && "".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce una expresión booleana!!!\nIntroduce una alia!!!");
        }
        else if ("".equals(jTextArea1.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce una expresión booleana!!!");
        }
        else if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce una alia!!!");
        }
        else {
            if (framePrincipal.añadirAlia(jTextField1.getText())) {
                //framePrincipal.setVisible(true);
                //framePrincipal.setEnabled(true);
                
                this.dispose();
                framePrincipal.closeAñadirAlia();
            }
            else {
                JOptionPane.showMessageDialog(null, "Alia ya existe!!!");
            }
        }

    }//GEN-LAST:event_ButtonAñadirActionPerformed

    public void clear() {
        jTextField1.setText("");
        jTextArea1.setText("");
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAñadir;
    private javax.swing.JButton ButtonCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
