/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prueba1;

import java.awt.CardLayout;
import com.mycompany.prueba1.Prueba1;

public class framePrueba extends javax.swing.JFrame {

    /**
     * Creates new form framePrueba
     */
    VentAñadirAliaPrin aA;
    VentEliminarAliaPrin eA;
    VentModificarAliaPrin mA;
    
    public framePrueba() {
        aA = new VentAñadirAliaPrin();
        eA = new VentEliminarAliaPrin();
        mA = new VentModificarAliaPrin();
        this.add(aA);
        this.add(eA);
        this.add(mA);
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        IniciPanel = new javax.swing.JPanel();
        SizeMenu = new javax.swing.JScrollPane();
        SizeMenuBusqueda = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NuevoDoc = new javax.swing.JMenuItem();
        CargarDoc = new javax.swing.JMenuItem();
        AliasMenu = new javax.swing.JMenu();
        NuevaAlia = new javax.swing.JMenuItem();
        ModificarAlia = new javax.swing.JMenuItem();
        EliminarAlia = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout IniciPanelLayout = new javax.swing.GroupLayout(IniciPanel);
        IniciPanel.setLayout(IniciPanelLayout);
        IniciPanelLayout.setHorizontalGroup(
            IniciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        IniciPanelLayout.setVerticalGroup(
            IniciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mainPanel.add(IniciPanel, "card2");

        SizeMenuBusqueda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Listar por autor", "Listar por autor y título", "Listar por prefijo", "Listar por similitud", "Listar por expresión booleana" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SizeMenuBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SizeMenuBusquedaMouseClicked(evt);
            }
        });
        SizeMenu.setViewportView(SizeMenuBusqueda);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Principal");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Documentos");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("D1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("D2");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("D3");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("D4");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Alias");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("A1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("A2");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("A3");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        FileMenu.setText("File");

        NuevoDoc.setText("Nuevo");
        FileMenu.add(NuevoDoc);

        CargarDoc.setText("Cargar");
        FileMenu.add(CargarDoc);

        MenuBarPrincipal.add(FileMenu);

        AliasMenu.setText("Alias");

        NuevaAlia.setText("Añadir");
        NuevaAlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaAliaActionPerformed(evt);
            }
        });
        AliasMenu.add(NuevaAlia);

        ModificarAlia.setText("Modificar");
        ModificarAlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarAliaActionPerformed(evt);
            }
        });
        AliasMenu.add(ModificarAlia);

        EliminarAlia.setText("Eliminar");
        EliminarAlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAliaActionPerformed(evt);
            }
        });
        AliasMenu.add(EliminarAlia);

        MenuBarPrincipal.add(AliasMenu);

        HelpMenu.setText("Help");
        MenuBarPrincipal.add(HelpMenu);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SizeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SizeMenuBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SizeMenuBusquedaMouseClicked

        //ListarPorAutor.setVisible(true);// TODO add your handling code here:
        
        CardLayout card = (CardLayout)mainPanel.getLayout();
        if ("Listar por autor".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {    
            mainPanel.add(new ListarPorAutor(this), "listarAutor");
            card.show(mainPanel, "listarAutor");
        }
        
        if ("Listar por autor y título".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            mainPanel.add(new ListarPorAutorYTitulo(), "listarAutorTitulo");
            card.show(mainPanel, "listarAutorTitulo");
        }
        
        if ("Listar por prefijo".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            mainPanel.add(new ListarPorPrefijo(), "listarPrefijo");
            card.show(mainPanel, "listarPrefijo");
        }
        
        if ("Listar por similitud".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            mainPanel.add(new ListarPorSimilitud(), "listarSimilitud");
            card.show(mainPanel, "listarSimilitud");
        }
        
        if ("Listar por expresión booleana".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            mainPanel.add(new ListarPorExpresion(), "listarExpresion");
            card.show(mainPanel, "listarExpresion");
        }
    }//GEN-LAST:event_SizeMenuBusquedaMouseClicked

    private void NuevaAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaAliaActionPerformed
        // TODO add your handling code here:
        int x = (this.getWidth()/2) - (aA.getWidth()/2);
        int y = (this.getHeight()/2) - (aA.getHeight()/2);
        aA.setLocation(x, y);
        if (mA.isVisible()) mA.setVisible(false);
        if (eA.isVisible()) eA.setVisible(false);
        aA.setVisible(true);
    }//GEN-LAST:event_NuevaAliaActionPerformed

    private void ModificarAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarAliaActionPerformed
        // TODO add your handling code here:
        int x = (this.getWidth()/2) - (mA.getWidth()/2);
        int y = (this.getHeight()/2) - (mA.getWidth()/2);
        mA.setLocation(x, y);
        if (aA.isVisible()) aA.setVisible(false);
        if (eA.isVisible()) eA.setVisible(false);
        mA.setVisible(true);
    }//GEN-LAST:event_ModificarAliaActionPerformed

    private void EliminarAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAliaActionPerformed
        // TODO add your handling code here:

        //if (mA.isVisible()) mA.setVisible(false);
        //if (aA.isVisible()) aA.setVisible(false);
        //eA.setVisible(true);
        //this.setEnabled(false);
        Prueba1.p.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_EliminarAliaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(framePrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ListarPorAutor a = new ListarPorAutor(this);
                new framePrueba().setVisible(true);
                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AliasMenu;
    private javax.swing.JMenuItem CargarDoc;
    private javax.swing.JMenuItem EliminarAlia;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JPanel IniciPanel;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem ModificarAlia;
    private javax.swing.JMenuItem NuevaAlia;
    private javax.swing.JMenuItem NuevoDoc;
    private javax.swing.JScrollPane SizeMenu;
    private javax.swing.JList<String> SizeMenuBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
