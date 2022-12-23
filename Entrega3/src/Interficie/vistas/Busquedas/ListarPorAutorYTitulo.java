/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Busquedas;

import Interficie.vistas.FramePrincipal;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ListarPorAutorYTitulo extends javax.swing.JPanel {
    private final FramePrincipal framePrincipal;
    /**
     * Creates new form ListarPorAutorYTitulo
     * @param framePrincipal
     */
    public ListarPorAutorYTitulo(FramePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
    }

    private boolean firstA = true;
    private boolean firstT = true;
    
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
        Titulo = new javax.swing.JTextField();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        TipoBusqueda.setText("BÚSQUEDA POR NOMBRE DE AUTOR Y TÍTULO");
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreAutorMouseClicked(evt);
            }
        });
        NombreAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAutorActionPerformed(evt);
            }
        });
        NombreAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreAutorKeyPressed(evt);
            }
        });

        Titulo.setForeground(new java.awt.Color(102, 102, 102));
        Titulo.setText("Introduce un título");
        Titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TituloMousePressed(evt);
            }
        });
        Titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TituloKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NombreAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(Titulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonBuscar))
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonBuscar, NombreAutor, Titulo});

    }// </editor-fold>//GEN-END:initComponents

    private void NombreAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAutorActionPerformed
        // TODO falta cosas:
    }//GEN-LAST:event_NombreAutorActionPerformed

    private void NombreAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMouseClicked
    
          if (firstA) {
              firstA = false;
              NombreAutor.setEnabled(true);
              NombreAutor.setText("");
              NombreAutor.setForeground(new Color(0, 0, 0));
          }
        
    }//GEN-LAST:event_NombreAutorMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       
        if ("".equals(NombreAutor.getText())) {
            NombreAutor.setText("Introduce un nombre de autor");
            NombreAutor.setForeground(new Color(102, 102, 102));
            firstA = true;
            NombreAutor.setEnabled(false);
        }
        
        if ("".equals(Titulo.getText())) {
            Titulo.setText("Introduce un título");
            Titulo.setForeground(new Color(102, 102, 102));
            firstT = true;
            Titulo.setEnabled(false);
        }
    }//GEN-LAST:event_formMousePressed

    private void TituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TituloMousePressed
       
        if (firstT) {
            firstT = false;
            Titulo.setEnabled(true);
            Titulo.setText("");
            Titulo.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TituloMousePressed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        String autor = NombreAutor.getText();
        String titulo = Titulo.getText();
        if (("".equals(NombreAutor.getText()) && "".equals(Titulo.getText())) || "Introduce un nombre de autor".equals(NombreAutor.getText()) && "Introduce un título".equals(Titulo.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce un autor!!!\nIntroduce un título!!!");
        }
        else if ("".equals(NombreAutor.getText()) || "Introduce un nombre de autor".equals(NombreAutor.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce un autor!!!");
        }
        
        else if ("".equals(Titulo.getText()) || "Introduce un título".equals(Titulo.getText())) {
            JOptionPane.showMessageDialog(null, "Introduce un título!!!");
        }
        else {
            String content = framePrincipal.getContenidoPorAutorTitulo(autor, titulo);
            if (content == null) {
                framePrincipal.closePanelItems();
                JOptionPane.showMessageDialog(null, "No existe el documento!!!");
            }
            else framePrincipal.contentlist(autor, titulo);
        }
        
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void NombreAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreAutorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonBuscar.doClick();
        }
    }//GEN-LAST:event_NombreAutorKeyPressed

    private void TituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TituloKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ButtonBuscar.doClick();
        }
    }//GEN-LAST:event_TituloKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JLabel TipoBusqueda;
    private javax.swing.JTextField Titulo;
    // End of variables declaration//GEN-END:variables
}
