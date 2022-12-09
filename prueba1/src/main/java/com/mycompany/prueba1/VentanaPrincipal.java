/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prueba1;

import com.mycompany.prueba1.VentanaSecundaria.VentNuevoDocumentoFrame;
import com.mycompany.prueba1.Busquedas.ListarPorSimilitud;
import com.mycompany.prueba1.Busquedas.ListarPorAutor;
import com.mycompany.prueba1.Busquedas.ListarPorPrefijo;
import com.mycompany.prueba1.Busquedas.ListarPorExpresion;
import com.mycompany.prueba1.Busquedas.ListarPorAutorYTitulo;
import com.mycompany.prueba1.Items.ItemAutor;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author flors
 */
public final class VentanaPrincipal extends javax.swing.JFrame {

    private final ListarPorAutor listaAutor = new ListarPorAutor();
    private final ListarPorAutorYTitulo listaAutorTitulo = new ListarPorAutorYTitulo();
    private final ListarPorExpresion listaExpresion = new ListarPorExpresion();
    private final ListarPorPrefijo listaPrefijo = new ListarPorPrefijo();
    private final ListarPorSimilitud listaSimilitud = new ListarPorSimilitud();
    private VentNuevoDocumentoFrame newDocument ;
    
    /**
     * Creates new form framePrueba
     */
    public VentanaPrincipal() {
        initComponents();
        init2();
    }
    
    private void init2(){
        PanelBusquedas.add(listaAutor,"listaAutor");
        PanelBusquedas.add(listaAutorTitulo,"listaAutorTitulo");
        PanelBusquedas.add(listaExpresion,"listaExpresion");
        PanelBusquedas.add(listaPrefijo,"listaPrefijo");
        PanelBusquedas.add(listaSimilitud,"listaSimilitud");
    }
    
    public void autorlist(){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i< 30; i++ ){
            newPanel.add(new ItemAutor("autor"+i));
            System.out.println("autor"+i);
        }
        JScrollPane pane = new JScrollPane(newPanel);
        PanelItems.add(pane);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SizeMenu = new javax.swing.JScrollPane();
        SizeMenuBusqueda = new javax.swing.JList<>();
        PanelBusquedas = new javax.swing.JPanel();
        PanelItems = new javax.swing.JPanel();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NuevoDoc = new javax.swing.JMenuItem();
        CargarDoc = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SizeMenuBusqueda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Listar por autor", "Listar por autor y título", "Listar por expresion", "Listar por prefijo", "Listar por similitud" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SizeMenuBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SizeMenuBusquedaMouseClicked(evt);
            }
        });
        SizeMenu.setViewportView(SizeMenuBusqueda);

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
        FileMenu.add(CargarDoc);

        MenuBarPrincipal.add(FileMenu);

        HelpMenu.setText("Help");
        MenuBarPrincipal.add(HelpMenu);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SizeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBusquedas, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SizeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SizeMenuBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SizeMenuBusquedaMouseClicked

        //ListarPorAutor.setVisible(true);// TODO add your handling code here:
        int idx = SizeMenuBusqueda.getSelectedIndex();
        CardLayout card = (CardLayout)PanelBusquedas.getLayout();
        switch (idx){
            case 0:
                card.show(PanelBusquedas, "listaAutor");
                break;
            case 1:
                card.show(PanelBusquedas, "listaAutorTitulo");
                break;
            case 2:
                card.show(PanelBusquedas, "listaExpresion");
                break;
            case 3:
                card.show(PanelBusquedas, "listaPrefijo");
                break;
            case 4:
                card.show(PanelBusquedas, "listaSimilitud");
                break;
        }
                
                    
    }//GEN-LAST:event_SizeMenuBusquedaMouseClicked

    private void NuevoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoDocActionPerformed
        // TODO add your handling code here:
       if(newDocument == null){
           newDocument = new VentNuevoDocumentoFrame();
           newDocument.show();
       }else{
           System.out.println("Ya hay una ventana abierta");
       }
              
    }//GEN-LAST:event_NuevoDocActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargarDoc;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem NuevoDoc;
    private javax.swing.JPanel PanelBusquedas;
    private javax.swing.JPanel PanelItems;
    private javax.swing.JScrollPane SizeMenu;
    private javax.swing.JList<String> SizeMenuBusqueda;
    // End of variables declaration//GEN-END:variables
}
