/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Busquedas;

import Interficie.vistas.FramePrincipal;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

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
    
    private String criterioSelect;
    private boolean first = true;
    private boolean firstSearch = true;
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
        NombreAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreAutorKeyPressed(evt);
            }
        });

        tipoOrdenacion.setText("Ordenar por:");

        criterioOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "título A-Z", "tamaño descendente" }));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tipoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipoOrdenacion)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscar, NombreAutor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {criterioOrdenar, tipoOrdenacion});

    }// </editor-fold>//GEN-END:initComponents

    private void NombreAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMousePressed

        if (first) {
            first = false;
            NombreAutor.setText("");
            NombreAutor.setForeground(new Color(0, 0, 0));
            NombreAutor.setEnabled(true);
        }
    }//GEN-LAST:event_NombreAutorMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       
        if ("".equals(NombreAutor.getText())) {
            NombreAutor.setText("Introduce un nombre de autor");
            NombreAutor.setForeground(new Color(102, 102, 102));
            first = true;
            NombreAutor.setEnabled(false);
        }
    }//GEN-LAST:event_formMousePressed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO change titles  arrays
        String autor = NombreAutor.getText();
        if ("".equals(autor) || "Introduce un nombre de autor".equals(autor)) {
            framePrincipal.closePanelItems();
            JOptionPane.showMessageDialog(null, "Introduce un nombre de autor!!!");
            firstSearch = true;
        }
        else {
            ArrayList<String> titulos = framePrincipal.getTitulos(autor);
            if (titulos == null) {
                framePrincipal.closePanelItems();
                JOptionPane.showMessageDialog(null, "No existe este autor");
            }
            else {
                criterioSelect = criterioOrdenar.getSelectedItem().toString();
                if("tamaño descendente".equals(criterioSelect)){
                    titulos = framePrincipal.ordenaDecreContent(autor);
                }
                else {
                    titulos = framePrincipal.getTitulos(autor);
                    Collections.sort(titulos);
                }
                framePrincipal.titlelist(titulos, autor);
            }
        }
        
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void criterioOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criterioOrdenarActionPerformed
        // TODO add your handling code here:

        if (! firstSearch && ! ("Introduce un nombre de autor".equals(NombreAutor.getText()) ||"".equals(NombreAutor.getText()))) {
            String autor = NombreAutor.getText();
            ArrayList<String> titulos = framePrincipal.getTitulos(autor);
            if (titulos == null) {
                framePrincipal.closePanelItems();
                JOptionPane.showMessageDialog(null, "No existe este autor");
            }
            else {
                criterioSelect = criterioOrdenar.getSelectedItem().toString();
                if("tamaño descendente".equals(criterioSelect)){
                    titulos = framePrincipal.ordenaDecreContent(autor);
                }
                else {
                    titulos = framePrincipal.getTitulos(autor);
                    Collections.sort(titulos);
                }
                framePrincipal.titlelist(titulos, autor);
            }
        }
    }//GEN-LAST:event_criterioOrdenarActionPerformed

    private void NombreAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreAutorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonBuscar.doClick();
        }
    }//GEN-LAST:event_NombreAutorKeyPressed

    public void reload() {
        ButtonBuscar.doClick();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JLabel TipoBusqueda;
    private javax.swing.JComboBox<String> criterioOrdenar;
    private javax.swing.JLabel tipoOrdenacion;
    // End of variables declaration//GEN-END:variables
}
