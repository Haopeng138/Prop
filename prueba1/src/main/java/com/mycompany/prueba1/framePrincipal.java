/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prueba1;

import com.mycompany.prueba1.VentanaSecundaria.VentAñadirAliaPrin;
import com.mycompany.prueba1.VentanaSecundaria.VentEliminarAliaPrin;
import com.mycompany.prueba1.VentanaSecundaria.VentModificarAliaPrin;
import com.mycompany.prueba1.Busquedas.ListarPorSimilitud;
import com.mycompany.prueba1.Busquedas.ListarPorAutor;
import com.mycompany.prueba1.Busquedas.ListarPorPrefijo;
import com.mycompany.prueba1.Busquedas.ListarPorExpresion;
import com.mycompany.prueba1.Busquedas.ListarPorAutorYTitulo;
import com.mycompany.prueba1.Items.ItemAutor;
import com.mycompany.prueba1.Items.ItemContenido;
import com.mycompany.prueba1.Items.ItemDocumento;
import com.mycompany.prueba1.Items.ItemTitulo;
import com.mycompany.prueba1.VentanaSecundaria.VentNuevoDocumentoFrame;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class framePrincipal extends javax.swing.JFrame {

    //Ventanas
    private VentNuevoDocumentoFrame newDocumentFrame;
    private VentAñadirAliaPrin añadirAliaPrinFrame;
    private VentEliminarAliaPrin eliminarAliaPrinFrame;
    private VentModificarAliaPrin modificarAliaPrinFrame;
    /**
     * Creates new form framePrueba
     */
   
    
    /*
    // TODO: Return type change after merge with CDominio 
    
    //Similud & Expresion
    ArrayList<String> documentheaders;
    
    //Prefijo 
    ArrayList<String> authors;
    
    //Titulos
    ArrayList<String> titulos;
    
    //Contenido 
    String contenido;
    */
    public framePrincipal() {
        /* Can´t add windows to fram
        aA = new VentAñadirAliaPrin();
        eA = new VentEliminarAliaPrin();
        mA = new VentModificarAliaPrin();
        this.add(aA);
        this.add(eA);
        this.add(mA);*/
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        initComponents();
    }

    public void autorlist(ArrayList<String> authors){
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< authors.size(); i++ ){
            tmpPanel.add(new ItemAutor(authors.get(i)));
        }
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
  
    }
    
    public void contentlist(String content){
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        tmpPanel.add(new ItemContenido(content));
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void titlelist(ArrayList<String> titles){
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< titles.size(); i++ ){
            tmpPanel.add(new ItemTitulo(titles.get(i)));
        }
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    /**
     *
     * @param documentHeaders
     */
    public void documentlist(ArrayList<DocumentHeaderDemo> documentHeaders){
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< documentHeaders.size(); i++ ){
            String author = documentHeaders.get(i).author;
            String title = documentHeaders.get(i).title;
            tmpPanel.add(new ItemDocumento(author,title));
        }
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void closeNewDocument(){
       newDocumentFrame = null;
    }
    
    public void closeAñadirAlia(){
        añadirAliaPrinFrame = null;
    }
    
    public void closeEliminarAlia(){
        eliminarAliaPrinFrame = null;
    }
    
    public void closeModificarAlia(){
        modificarAliaPrinFrame = null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBusquedas = new javax.swing.JPanel();
        SizeMenu = new javax.swing.JScrollPane();
        SizeMenuBusqueda = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        PanelItems = new javax.swing.JPanel();
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

        PanelBusquedas.setLayout(new java.awt.CardLayout());

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

        PanelItems.setLayout(new javax.swing.BoxLayout(PanelItems, javax.swing.BoxLayout.Y_AXIS));

        FileMenu.setText("File");

        NuevoDoc.setText("Nuevo");
        NuevoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoDocActionPerformed(evt);
            }
        });
        FileMenu.add(NuevoDoc);

        CargarDoc.setText("Cargar");
        CargarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarDocActionPerformed(evt);
            }
        });
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(SizeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBusquedas, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(PanelBusquedas, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SizeMenuBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SizeMenuBusquedaMouseClicked

        //ListarPorAutor.setVisible(true);// TODO add your handling code here:
        
        CardLayout card = (CardLayout)PanelBusquedas.getLayout();
        if ("Listar por autor".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {    
            PanelBusquedas.add(new ListarPorAutor(this), "listarAutor");
            card.show(PanelBusquedas, "listarAutor");
        }
        
        if ("Listar por autor y título".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            PanelBusquedas.add(new ListarPorAutorYTitulo(this), "listarAutorTitulo");
            card.show(PanelBusquedas, "listarAutorTitulo");
        }
        
        if ("Listar por prefijo".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            PanelBusquedas.add(new ListarPorPrefijo(this), "listarPrefijo");
            card.show(PanelBusquedas, "listarPrefijo");
        }
        
        if ("Listar por similitud".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            PanelBusquedas.add(new ListarPorSimilitud(this), "listarSimilitud");
            card.show(PanelBusquedas, "listarSimilitud");
        }
        
        if ("Listar por expresión booleana".equals((String)SizeMenuBusqueda.getSelectedValue()) ) {
            PanelBusquedas.add(new ListarPorExpresion(this), "listarExpresion");
            card.show(PanelBusquedas, "listarExpresion");
        }
    }//GEN-LAST:event_SizeMenuBusquedaMouseClicked

    private void NuevaAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaAliaActionPerformed
        // TODO add your handling code here:
        if (añadirAliaPrinFrame == null){
            añadirAliaPrinFrame = new VentAñadirAliaPrin(this);
            añadirAliaPrinFrame.show();
            int x = (this.getWidth()/2) - (añadirAliaPrinFrame.getWidth()/2);
            int y = (this.getHeight()/2) - (añadirAliaPrinFrame.getHeight()/2);
            añadirAliaPrinFrame.setLocation(x, y);
        }
        /*
        if (modificarAliaPrinFrame.isVisible()) modificarAliaPrinFrame.setVisible(false);
        if (eliminarAliaPrinFrame.isVisible()) eliminarAliaPrinFrame.setVisible(false);
        añadirAliaPrinFrame.setVisible(true);*/
    }//GEN-LAST:event_NuevaAliaActionPerformed

    private void ModificarAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarAliaActionPerformed
        // TODO add your handling code here:
        if (modificarAliaPrinFrame == null){
            modificarAliaPrinFrame = new VentModificarAliaPrin(this);
            modificarAliaPrinFrame.show();
            int x = (this.getWidth()/2) - (modificarAliaPrinFrame.getWidth()/2);
            int y = (this.getHeight()/2) - (modificarAliaPrinFrame.getWidth()/2);
            modificarAliaPrinFrame.setLocation(x, y);
        }
    }//GEN-LAST:event_ModificarAliaActionPerformed

    private void EliminarAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAliaActionPerformed
        if (eliminarAliaPrinFrame == null){
            eliminarAliaPrinFrame = new VentEliminarAliaPrin(this);
            eliminarAliaPrinFrame.show();
            int x = (this.getWidth()/2) - (eliminarAliaPrinFrame.getWidth()/2);
            int y = (this.getHeight()/2) - (eliminarAliaPrinFrame.getWidth()/2);
            eliminarAliaPrinFrame.setLocation(x, y);
        }
    }//GEN-LAST:event_EliminarAliaActionPerformed

    private void NuevoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoDocActionPerformed
        // TODO add your handling code here:
         if(newDocumentFrame == null){
            newDocumentFrame = new VentNuevoDocumentoFrame(this);
            newDocumentFrame.show();
            int x = (this.getWidth()/2) - (newDocumentFrame.getWidth()/2);
            int y = (this.getHeight()/2) - (newDocumentFrame.getWidth()/2);
            newDocumentFrame.setLocation(x, y);
       }else{
           System.out.println("Ya hay una ventana abierta");
       }
              
    }//GEN-LAST:event_NuevoDocActionPerformed

    private void CargarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarDocActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt files", "txt");
        FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(" .xml files", "xml");
        fileChooser.setFileFilter(restrict);
        fileChooser.setFileFilter(restrict2); 
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // TODO: Hacer logica de insert aqui
            System.out.print(selectedFile.toString());
        }
    }//GEN-LAST:event_CargarDocActionPerformed

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
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //ListarPorAutor a = new ListarPorAutor(this);
                new framePrincipal().setVisible(true);
                
                //a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AliasMenu;
    private javax.swing.JMenuItem CargarDoc;
    private javax.swing.JMenuItem EliminarAlia;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem ModificarAlia;
    private javax.swing.JMenuItem NuevaAlia;
    private javax.swing.JMenuItem NuevoDoc;
    private javax.swing.JPanel PanelBusquedas;
    private javax.swing.JPanel PanelItems;
    private javax.swing.JScrollPane SizeMenu;
    private javax.swing.JList<String> SizeMenuBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
