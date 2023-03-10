/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interficie.vistas;

import Interficie.ControladorInterficie;
import Interficie.vistas.VentanaSecundaria.VentA├▒adirAliaPrin;
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
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class FramePrincipal extends javax.swing.JFrame {
    private ControladorInterficie ctrlInterficie;
    //Ventanas
    private VentNuevoDocumentoFrame newDocumentFrame;
    private VentA├▒adirAliaPrin a├▒adirAliaPrinFrame;
    private VentEliminarAliaPrin eliminarAliaPrinFrame;
    private VentModificarAliaPrin modificarAliaPrinFrame;
    private String autorList;
    private int indexPanel = -1;
    private boolean isPanelAutor = false;
    private boolean isPanelPrefijo = false;

    public FramePrincipal(ControladorInterficie ctrInterficie) {
        this.ctrlInterficie = ctrInterficie;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ctrlInterficie.persit();
                System.out.println("Se ha hecho persistencia");
                System.exit(0);

            }
        });
        initComponents();
    }
    
    public ArrayList<String> ordenaDecreContent (String nameAutor) {
        ArrayList<String> titulos = getTitulos(nameAutor);
        if (titulos == null) return null;
        
        HashMap<String,Integer> TitCont = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < titulos.size(); ++i) {
            String cont = getContenidoPorAutorTitulo(nameAutor, titulos.get(i));
            TitCont.put(titulos.get(i), cont.length());
        }
        for (Map.Entry<String, Integer> entry : TitCont.entrySet()) {
            list.add(entry.getValue());
        }
        
        Collections.sort(list);
        Collections.reverse(list);
       
        ArrayList<String> titOrdenado = new ArrayList<>();
        for (int size : list) {
            for (Entry<String, Integer> entry : TitCont.entrySet()) {
                if (entry.getValue().equals(size) && !titOrdenado.contains(entry.getKey())) {
                    titOrdenado.add(entry.getKey());
                }
            }
        }
        return titOrdenado;
    }
    
    public ArrayList<String> ordenaRelevanciaAutor (String prefijo) {
        ArrayList<String> autores = buscarPorPrefijo(prefijo);
        if (autores.isEmpty()) return null;
        HashMap<String,Integer> autNumTit = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < autores.size(); ++i) {
            ArrayList<String> titulos = getTitulos(autores.get(i));
            autNumTit.put(autores.get(i), titulos.size());
        }
        for (Map.Entry<String, Integer> entry : autNumTit.entrySet()) {
            list.add(entry.getValue());
        }
        
        Collections.sort(list);
        Collections.reverse(list);
       
        ArrayList<String> autOrdenado = new ArrayList<>();
        for (int size : list) {
            for (Entry<String, Integer> entry : autNumTit.entrySet()) {
                if (entry.getValue().equals(size) && !autOrdenado.contains(entry.getKey())) {
                    autOrdenado.add(entry.getKey());
                }
            }
        }
        return autOrdenado;
    }

    public ArrayList<String[]> ordenaSimilitudAutor(ArrayList<String[]> documents) {
        Collections.sort(documents, new Comparator<String[]> () {
            public int compare(String[] a, String[] b) {
                return a[0].compareTo(b[0]);
            }
        });
        return documents;
    }

    public ArrayList<String[]> ordenaSimilitudTitulo (ArrayList<String[]> documents) {
        Collections.sort(documents, new Comparator<String[]> () {
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });
        return documents;
    }
    
    public ArrayList<String> getAlias(){
        ArrayList<String> result = new ArrayList<>();
        int index = -1;
        DefaultMutableTreeNode principalDirectory = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        for (int i = 0; i < principalDirectory.getChildCount(); ++i) {
            if ("Alias".equals(principalDirectory.getChildAt(i).toString())) index = i;
        }
        if (index == -1) return null;
        DefaultMutableTreeNode aliasDirectory = (DefaultMutableTreeNode) principalDirectory.getChildAt(index);
        for(int i = 0; i< aliasDirectory.getChildCount();++i){
            result.add(aliasDirectory.getChildAt(i).toString());
        }
        return result;
    }
    
    public int getDocSize(){
        return ctrlInterficie.getDocSize();
    }
    
    public ArrayList<String> getDocumentos(){
        ArrayList<String> result = new ArrayList<>();
        int index = -1;
        DefaultMutableTreeNode principalDirectory = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        for (int i = 0; i < principalDirectory.getChildCount(); ++i) {
            if ("Documentos".equals(principalDirectory.getChildAt(i).toString())) index = i;
        }
        if (index == -1) return null;
        DefaultMutableTreeNode docDirectory = (DefaultMutableTreeNode) principalDirectory.getChildAt(index);
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

    public void contentlist(String autor, String titulo) {
        PanelItems.removeAll();
        String content = getContenidoPorAutorTitulo(autor, titulo);
        if (content != null) {
            JPanel tmpPanel = new JPanel();
            tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
            tmpPanel.add(new ItemContenido(this, content));
            JScrollPane pane = new JScrollPane(tmpPanel);
            PanelItems.add(pane);
            PanelItems.setVisible(true);
            SwingUtilities.updateComponentTreeUI(this);
        } else {
            JOptionPane.showMessageDialog(null, "No existe el documento buscado!");
        }
    }
    
    public void titlelist(ArrayList<String> titles, String autor){
        autorList = autor;
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< titles.size(); i++ ){
            tmpPanel.add(new ItemTitulo(this,titles.get(i), autor));
        }
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public String getAutorList() {
        return autorList;
    }
    /**
     *
     * @param documents
     */
    public void documentlist(ArrayList<String[]> documents) {
        PanelItems.removeAll();
        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< documents.size(); i++ ){
            String author = documents.get(i)[0];
            String title = documents.get(i)[1];
            tmpPanel.add(new ItemDocumento(this,author,title));
        }
        JScrollPane pane = new JScrollPane(tmpPanel);
        PanelItems.add(pane);
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void closeNewDocument() {
       newDocumentFrame = null;
    }
    
    public void closeA├▒adirAlia() {
        a├▒adirAliaPrinFrame = null;
    }

    public void closeEliminarAlia() {
        eliminarAliaPrinFrame = null;
    }

    public void closeModificarAlia() {
        modificarAliaPrinFrame = null;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SizeMenu = new javax.swing.JScrollPane();
        SizeMenuBusqueda = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        PanelBusquedas = new javax.swing.JPanel();
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
        Manual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SizeMenuBusqueda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Listar por autor", "Listar por autor y t├ştulo", "Listar por prefijo", "Listar por similitud", "Listar por expresi├│n booleana" };
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
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Alias");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Selecciona el tipo de b├║squeda:");

        PanelBusquedas.setLayout(new java.awt.CardLayout());

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

        NuevaAlia.setText("A├▒adir");
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

        Manual.setText("Manual");
        Manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualActionPerformed(evt);
            }
        });
        HelpMenu.add(Manual);

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
                    .addComponent(SizeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBusquedas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SizeMenuBusquedaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_SizeMenuBusquedaMouseClicked

        CardLayout card = (CardLayout) PanelBusquedas.getLayout();
        PanelItems.removeAll();
        if ("Listar por autor".equals((String) SizeMenuBusqueda.getSelectedValue())) {
            PanelBusquedas.add(new ListarPorAutor(this), "listarAutor");
            card.show(PanelBusquedas, "listarAutor");
            isPanelPrefijo = false;
            PanelItems.setVisible(false);
            ++indexPanel;
            isPanelAutor = true;
           
        }

        if ("Listar por autor y t├ştulo".equals((String) SizeMenuBusqueda.getSelectedValue())) {
            PanelBusquedas.add(new ListarPorAutorYTitulo(this), "listarAutorTitulo");
            card.show(PanelBusquedas, "listarAutorTitulo");
            ++indexPanel;
            PanelItems.setVisible(false);
            isPanelPrefijo = false;
            isPanelAutor = false;
        }

        if ("Listar por prefijo".equals((String) SizeMenuBusqueda.getSelectedValue())) {
            PanelBusquedas.add(new ListarPorPrefijo(this), "listarPrefijo");
            card.show(PanelBusquedas, "listarPrefijo");
            ++indexPanel;
            PanelItems.setVisible(false);
            isPanelPrefijo = true;
            isPanelAutor = false;
        }

        if ("Listar por similitud".equals((String) SizeMenuBusqueda.getSelectedValue())) {
            PanelBusquedas.add(new ListarPorSimilitud(this), "listarSimilitud");
            card.show(PanelBusquedas, "listarSimilitud");
            ++indexPanel;
            PanelItems.setVisible(false);
            isPanelPrefijo = false;
            isPanelAutor = false;
        }

        if ("Listar por expresi├│n booleana".equals((String) SizeMenuBusqueda.getSelectedValue())) {
            PanelBusquedas.add(new ListarPorExpresion(this), "listarExpresion");
            card.show(PanelBusquedas, "listarExpresion");
            ++indexPanel;
            isPanelAutor = false;
            isPanelPrefijo = false;
            PanelItems.setVisible(false);
        }
    }                                             

    private void NuevaAliaActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
        if (a├▒adirAliaPrinFrame == null){
            a├▒adirAliaPrinFrame = new VentA├▒adirAliaPrin(this);
            a├▒adirAliaPrinFrame.show();
        }
        /*
         * if (modificarAliaPrinFrame.isVisible())
         * modificarAliaPrinFrame.setVisible(false);
         * if (eliminarAliaPrinFrame.isVisible())
         * eliminarAliaPrinFrame.setVisible(false);
         * a├▒adirAliaPrinFrame.setVisible(true);
         */
    }// GEN-LAST:event_NuevaAliaActionPerformed

    private void ModificarAliaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ModificarAliaActionPerformed

        ArrayList<String> alias = getAlias();
        if (modificarAliaPrinFrame == null && alias != null) {
            modificarAliaPrinFrame = new VentModificarAliaPrin(this);
            modificarAliaPrinFrame.show();
        }
        else if (alias == null) {
            JOptionPane.showMessageDialog(null, "No hay alias");
        }
    }                                             

    private void EliminarAliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAliaActionPerformed
        
        ArrayList<String> alias = getAlias();
        if (eliminarAliaPrinFrame == null && alias != null) {
            eliminarAliaPrinFrame = new VentEliminarAliaPrin(this);
            eliminarAliaPrinFrame.show();
        }
        else if (alias != null) {
            JOptionPane.showMessageDialog(null, "No hay alias");
        }
    }//GEN-LAST:event_EliminarAliaActionPerformed

    private void NuevoDocActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
         if(newDocumentFrame == null) {
            newDocumentFrame = new VentNuevoDocumentoFrame(this);
            newDocumentFrame.show();
        } else {
            System.out.println("Ya hay una ventana abierta");
        }

    }// GEN-LAST:event_NuevoDocActionPerformed

    private void CargarDocActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CargarDocActionPerformed

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt files", "txt");

        FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(" .xml files", "xml");

        fileChooser.setFileFilter(restrict);

        fileChooser.setFileFilter(restrict2); 

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile =  fileChooser.getSelectedFile();
            try{
                ctrlInterficie.createDocumento(selectedFile);
            }catch (Exception e){
                if(e.getMessage().equals("No se ha creado")){
                    JOptionPane.showMessageDialog(null,"No se ha cargado el documento,");
                }
                e.printStackTrace();
            }
            System.out.print(selectedFile.toString());
        }
    }                                         

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTree1MouseClicked
        // TODO change for panel
        DefaultMutableTreeNode selected = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        String docHeader = null;
        String alia = null;
        PanelItems.removeAll();
        PanelInfoDoc infoDoc = new PanelInfoDoc(this);
        PanelInfoAlia infoAlia = new PanelInfoAlia(this);
        if (selected != null && selected.getChildCount() == 0 && "Documentos".equals(selected.getParent().toString())) {
            docHeader = selected.getUserObject().toString();
            String[] doc = docHeader.split("-");
            String autor = doc[0];
            String titulo = doc[1];
            System.out.println(autor + " " + titulo);

            String contenido = ctrlInterficie.busquedaPorAutorTitulo(autor, titulo);

            infoDoc.setText(autor, titulo, contenido);
            PanelItems.add(infoDoc);

        } else if (selected != null && selected.getChildCount() == 0 && "Alias".equals(selected.getParent().toString())) {
            alia = selected.getUserObject().toString();
            String expresion = getExpresion(alia);
            infoAlia.setText(alia, expresion);
            System.out.print(alia);
            PanelItems.add(infoAlia);
        }
        PanelItems.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }                                   

    private void ManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ManualActionPerformed

    public String getExpresion(String alia) {
        return ctrlInterficie.getExpresion(alia);
    }
    //** TODO:review
    /*
     * public void openA├▒adirAliaExp() {
     * Prueba1.vE.setVisible(true);
     * this.setEnabled(false);
     * }
     */

    public boolean a├▒adirAlia(String ali, String expresion) {
        DefaultMutableTreeNode alia = new DefaultMutableTreeNode(ali);
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        if (root.getChildCount() == 1 && "Documentos".equals(root.getChildAt(0).toString())) {
            root.add(new DefaultMutableTreeNode("Alias"));
        }
        else if (root.getChildCount() == 0) {
            root.add(new DefaultMutableTreeNode("Alias"));
        }
        int index = 0;
        for (int i = 0; i < root.getChildCount(); ++i) {
            if ("Alias".equals(root.getChildAt(i).toString()))
                index = i;
        }
        
        DefaultMutableTreeNode alias = (DefaultMutableTreeNode) root.getChildAt(index);
        
        boolean trobat = false;
        for (int i = 0; i < alias.getChildCount(); ++i) {
            if (alias.getChildAt(i).toString().equals(ali))
                trobat = true;
        }
        boolean create = false;
        if (trobat) {
            return false;
        }
        else {
            
            try {
                create = addExpresion(ali, expresion);
                if (create) alias.add(alia);
                
            } catch (Exception ex) {
                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        modelo.reload();
        return create;
    }
    
    public boolean a├▒adirDocumento(String titulo, String autor, String cont) {
        String docHeader = autor + "-" + titulo;

        DefaultMutableTreeNode documento = new DefaultMutableTreeNode(docHeader);
        DefaultTreeModel modelo = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        
        if (root.getChildCount() == 1 && "Alias".equals(root.getChildAt(0).toString())) {
            root.add(new DefaultMutableTreeNode("Documentos"));
        }
        else if (root.getChildCount() == 0) {
            root.add(new DefaultMutableTreeNode("Documentos"));
        }
        int index = 0;
        for (int i = 0; i < root.getChildCount(); ++i) {
            if ("Documentos".equals(root.getChildAt(i).toString()))
                index = i;
        }
        
        DefaultMutableTreeNode docs = (DefaultMutableTreeNode) root.getChildAt(index);
        boolean trobat = false;
        for (int i = 0; i < docs.getChildCount(); ++i) {
            if (docs.getChildAt(i).toString().equals(docHeader))
                trobat = true;
        }
        if (trobat) {
            return false;
        }
        else {
            docs.add(documento);
            modelo.reload();
            ctrlInterficie.createDocumento(autor, titulo, cont);
        }
        return true;
    }

    public boolean cargarDocument(String autor, String titulo) {
        String docHeader = autor + "-" + titulo;

        DefaultMutableTreeNode documento = new DefaultMutableTreeNode(docHeader);
        DefaultTreeModel modelo = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();

        if (root.getChildCount() == 1 && "Alias".equals(root.getChildAt(0).toString())) {
            root.add(new DefaultMutableTreeNode("Documentos"));
        }
        else if (root.getChildCount() == 0) {
            root.add(new DefaultMutableTreeNode("Documentos"));
        }
        int index = 0;
        for (int i = 0; i < root.getChildCount(); ++i) {
            if ("Documentos".equals(root.getChildAt(i).toString())) index = i;
        }

        DefaultMutableTreeNode docs = (DefaultMutableTreeNode) root.getChildAt(index);
        boolean trobat = false;
        for (int i = 0; i < docs.getChildCount(); ++i) {
            if (docs.getChildAt(i).toString().equals(titulo)) trobat = true;
        }
        if (trobat) {
            return false;
        }
        else {
            docs.add(documento);
            modelo.reload();
        }
        return true;
    }

    public void removeDocumento(String autor, String titulo) {
        ctrlInterficie.removeDocument(autor, titulo);
    }

    public void eliminarDoc(String titulo, String autor) {
        String docHeader = autor + "-" + titulo;
        DefaultMutableTreeNode doc = null;
        DefaultTreeModel modelo = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        int index = 0;
        for (int i = 0; i < root.getChildCount(); ++i) {
            if ("Documentos".equals(root.getChildAt(i).toString()))
                index = i;
        }
        DefaultMutableTreeNode docs = (DefaultMutableTreeNode) root.getChildAt(index);
        Enumeration<TreeNode> cont = docs.children();
        while (cont.hasMoreElements()) {
            DefaultMutableTreeNode aut = (DefaultMutableTreeNode) cont.nextElement();
            
            if (aut.toString().equals(docHeader)) doc = aut;
        }
        docs.remove(doc);
        
        removeDocumento(autor, titulo);
        if (docs.getChildCount() == 0)
            root.remove(docs);
        

        modelo.reload();
    }
    
    public String getContent(String autor, String titulo) {
        return ctrlInterficie.busquedaPorAutorTitulo(autor, titulo);
    }

    public void modificarDoc(String titulo, String autor, String cont) {
        ctrlInterficie.modifyDocument(autor, titulo, cont);
    }
    
    public void removeExpresion(String a) {
        ctrlInterficie.removeExpresion(a);
    }

    public void eliminarAlia(String a) {
        DefaultMutableTreeNode alia = null;
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        int index = 0;
        for (int i = 0; i < root.getChildCount(); ++i) {
            if ("Alias".equals(root.getChildAt(i).toString()))
                index = i;
        }
        DefaultMutableTreeNode alias = (DefaultMutableTreeNode) root.getChildAt(index);
        Enumeration<TreeNode> cont = alias.children();
        while (cont.hasMoreElements()) {
            DefaultMutableTreeNode ali = (DefaultMutableTreeNode) cont.nextElement();
            
            if (ali.toString().equals(a)) alia = ali;
        }
        alias.remove(alia);
        removeExpresion(a);
        if (alias.getChildCount() == 0)
            root.remove(alias);

        modelo.reload();
    }
    
    public void modificarExpresion(String alia, String expresion) {
        ctrlInterficie.updateExpresion(alia, expresion);
    }

    public void buscarPorAlia(String alia, String criterioSelect) {
        ArrayList<String[]> documents = ctrlInterficie.busquedaPorExpresion(alia);
        if (documents != null) {
            ArrayList<String[]> docsOrdenats = new ArrayList<String[]>();
            if (criterioSelect == "autor A-Z") {
                docsOrdenats = ordenaSimilitudAutor(documents);
            } else docsOrdenats = ordenaSimilitudTitulo(documents);
            documentlist(docsOrdenats);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado documentos, revisa la expresi├│n");
        }
    }

    public void buscarPorSimilitud(String autor, String titulo, int k, String criterioSelect) {
        ArrayList<String[]> documents = ctrlInterficie.busquedaPorSimilitud(autor, titulo, k);
        if (documents != null) {
            ArrayList<String[]> docsOrdenats = new ArrayList<String[]>();
            if (criterioSelect == "autor A-Z") {
                docsOrdenats = ordenaSimilitudAutor(documents);
            } else if (criterioSelect == "t├ştulo A-Z") {
                docsOrdenats = ordenaSimilitudTitulo(documents);
            } else docsOrdenats = documents;
            documentlist(docsOrdenats);
        } else {
            JOptionPane.showMessageDialog(null, "No existe el documento!");
        }
    }

    public String getContenidoPorAutorTitulo(String autor, String titulo) {
        return ctrlInterficie.busquedaPorAutorTitulo(autor, titulo);
    }

    public void removeDocument(String autor, String titulo) {
        ctrlInterficie.removeDocument(autor, titulo);
    }

    public void modifyDocument(String autor, String titulo, String contenido) {
        ctrlInterficie.modifyDocument(autor, titulo, contenido);
    }

    public boolean addExpresion(String alia, String expresion)  {
        boolean added = false;
        try {
            ctrlInterficie.addExpresion(alia, expresion);
            added = true;
        }
        catch(Exception e){     
        }
        
        return added;
        
    }

    public ArrayList<String> buscarPorPrefijo(String prefijo) {
        return ctrlInterficie.busquedaPorPrefijo(prefijo);
    }

    public ArrayList<String> getTitulos(String autor) {
        ArrayList<String> autores = buscarPorPrefijo(autor);
        if (autores.isEmpty() || !autores.contains(autor))
            return null;
        return ctrlInterficie.getTitles(autor);
    }

    public void export(String autor, String titulo, File path, String type) {
        if (type.equals("txt")) {
            ctrlInterficie.exportTxt(autor, titulo, path);
        } else {
            ctrlInterficie.exportXml(autor, titulo, path);
        }
    }
    
    public void reload(String index) {
        if (isPanelPrefijo) {
            ListarPorPrefijo panel =(ListarPorPrefijo)PanelBusquedas.getComponent(indexPanel);
            if ("prefijo".equals(index)) {
                JScrollPane panelItems = (JScrollPane) PanelItems.getComponent(0);
                JViewport view = (JViewport) panelItems.getComponent(0);

                JPanel panelTit = (JPanel) view.getComponent(0);
                BoxLayout box = (BoxLayout)panelTit.getLayout();
                panelTit = (JPanel) box.getTarget();
                for (int i = 0; i < panelTit.getComponentCount(); ++i) {
                    ItemAutor autor = (ItemAutor) panelTit.getComponent(i);
                    autor.closeItemTitulo();
                }
                panel.reload();
            }

        }

        if (isPanelAutor && "autor".equals(index)) {
            ListarPorAutor panel =(ListarPorAutor)PanelBusquedas.getComponent(indexPanel);
            panel.reload();
        }
    }

    public void closePanelItems() {
        PanelItems.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AliasMenu;
    private javax.swing.JMenuItem CargarDoc;
    private javax.swing.JMenuItem EliminarAlia;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem Manual;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem ModificarAlia;
    private javax.swing.JMenuItem NuevaAlia;
    private javax.swing.JMenuItem NuevoDoc;
    private javax.swing.JPanel PanelBusquedas;
    private javax.swing.JPanel PanelItems;
    private javax.swing.JScrollPane SizeMenu;
    private javax.swing.JList<String> SizeMenuBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    

}
