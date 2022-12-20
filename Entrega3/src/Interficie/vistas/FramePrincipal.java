/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interficie.vistas;

import Interficie.ControladorInterficie;
import Interficie.vistas.VentanaSecundaria.VentAñadirAliaPrin;
import Interficie.vistas.VentanaSecundaria.VentEliminarAliaPrin;
import Interficie.vistas.VentanaSecundaria.VentModificarAliaPrin;
import Interficie.vistas.Busquedas.ListarPorSimilitud;
import Interficie.vistas.Busquedas.ListarPorAutor;
import Interficie.vistas.Busquedas.ListarPorPrefijo;
import Interficie.vistas.Busquedas.ListarPorExpresion;
import Interficie.vistas.Busquedas.ListarPorAutorYTitulo;
import Interficie.vistas.Items.ItemAutor;
import Interficie.vistas.Items.ItemContenido;
import Interficie.vistas.Items.ItemDocumento;
import Interficie.vistas.Items.ItemTitulo;
import Interficie.vistas.Items.PanelInfoAlia;
import Interficie.vistas.Items.PanelInfoDoc;
import Interficie.vistas.VentanaSecundaria.VentNuevoDocumentoFrame;
import java.awt.CardLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class FramePrincipal extends javax.swing.JFrame {
    private ControladorInterficie ctrlInterficie;
    //Ventanas
    private VentNuevoDocumentoFrame newDocumentFrame;
    private VentAñadirAliaPrin añadirAliaPrinFrame;
    private VentEliminarAliaPrin eliminarAliaPrinFrame;
    private VentModificarAliaPrin modificarAliaPrinFrame;

    
    public FramePrincipal(ControladorInterficie ctrInterficie) {
        this.ctrlInterficie = ctrInterficie;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        initComponents();
    }
    
    public ArrayList<String> getAlias(){
        ArrayList<String> result = new ArrayList<>();
        DefaultMutableTreeNode principalDirectory = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        DefaultMutableTreeNode aliasDirectory = (DefaultMutableTreeNode) principalDirectory.getChildAt(1);
        for(int i = 0; i< aliasDirectory.getChildCount();i++){
            result.add(aliasDirectory.getChildAt(i).toString());
        }
        return result;
    }
    
    public ArrayList<String> getDocumentos(){
        ArrayList<String> result = new ArrayList<>();
        DefaultMutableTreeNode principalDirectory = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        DefaultMutableTreeNode docDirectory = (DefaultMutableTreeNode) principalDirectory.getChildAt(0);
        for(int i = 0; i< docDirectory.getChildCount();i++){
            result.add(docDirectory.getChildAt(i).toString());
        }
        return result;
    }

    public void autorlist(ArrayList<String> authors){
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< authors.size(); i++ ){
            tmpPanel.add(new ItemAutor(this,authors.get(i)));
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
        tmpPanel.add(new ItemContenido(this,content));
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
            tmpPanel.add(new ItemTitulo(this,titles.get(i)));
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
            tmpPanel.add(new ItemDocumento(this,author,title));
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
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
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

        CardLayout card = (CardLayout)PanelBusquedas.getLayout();
        PanelItems.removeAll();
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

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO change for panel
        DefaultMutableTreeNode selected = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        String doc = null;
        String alia = null;
        PanelItems.removeAll();
        PanelInfoDoc infoDoc = new PanelInfoDoc(this);
        PanelInfoAlia infoAlia = new PanelInfoAlia(this);
        //System.out.print(selected.getUserObject().toString());
        if (selected.getChildCount()== 0 && "Documentos".equals(selected.getParent().toString())) {
            doc = selected.getUserObject().toString();
            infoDoc.setText("autor",doc,"contenido");
            PanelItems.add(infoDoc);
             
        } else if (selected.getChildCount()== 0 && "Alias".equals(selected.getParent().toString())) {
            alia = selected.getUserObject().toString();
            infoAlia.setText(alia,"expreiosn");
            System.out.print(alia);
            
            PanelItems.add(infoAlia);     
            
        }
        
     
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jTree1MouseClicked

    //** TODO:review
    /*
    public void openAñadirAliaExp() {
        Prueba1.vE.setVisible(true);
        this.setEnabled(false);
    }*/
    
    public boolean añadirAlia(String a) {
        DefaultMutableTreeNode alia = new DefaultMutableTreeNode(a);
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode c = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        DefaultMutableTreeNode d = (DefaultMutableTreeNode) c.getChildAt(1);
        
        if (d.getIndex(alia) != -1) {
            return false;
        }
        else {
                d.add(alia);
                //eliminarAliaPrinFrame.AñadirA(a);
                //System.out.print("Algo");
                //modificarAliaPrinFrame.AñadirA(a);
                //System.out.print("Algo");
                //modelo.reload();
                
        }
        return true;
    }
    
    public boolean añadirDocumento(String doc) {
        DefaultMutableTreeNode documento = new DefaultMutableTreeNode(doc);
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode c = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        DefaultMutableTreeNode d = (DefaultMutableTreeNode) c.getChildAt(0);
        if (d.getIndex(documento) != -1) {
            return false;
        }
        else {
                d.add(documento);
                modelo.reload();
                ctrlInterficie.createDocumento("alia","gafg","gsfdgsdf");
        }
        return true;
    }
    
    
    public void eliminarA(String a, int idx) {
        DefaultMutableTreeNode alia = null;
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode c = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        DefaultMutableTreeNode d = (DefaultMutableTreeNode) c.getChildAt(1);
        Enumeration<TreeNode> e = d.children();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode ali = (DefaultMutableTreeNode) e.nextElement();
            String g = ali.toString();
            if (g.equals(a)) alia = ali;
            System.out.println(g);
        }
        
        d.remove(alia);
        //modificarAliaPrinFrame.eliminarA(jcombo);
        modelo.reload();
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
