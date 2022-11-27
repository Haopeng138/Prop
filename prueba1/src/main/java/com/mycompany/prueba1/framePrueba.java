/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.prueba1;

/**
 *
 * @author flors
 */
public class framePrueba extends javax.swing.JFrame {

    /**
     * Creates new form framePrueba
     */
    public framePrueba() {
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

        SizeMenu = new javax.swing.JScrollPane();
        SizeMenuBusqueda = new javax.swing.JList<>();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NuevoDoc = new javax.swing.JMenuItem();
        CargarDoc = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SizeMenuBusqueda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Listar por autor", "Listar por autor y título", "Listar por prefijo", "Listar por similitud", "Listar por expresión" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SizeMenuBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SizeMenuBusquedaMouseClicked(evt);
            }
        });
        SizeMenu.setViewportView(SizeMenuBusqueda);

        FileMenu.setText("File");

        NuevoDoc.setText("Nuevo");
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
                .addContainerGap(579, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(SizeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SizeMenuBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SizeMenuBusquedaMouseClicked

        //ListarPorAutor.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_SizeMenuBusquedaMouseClicked

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
                ListarPorAutor a = new ListarPorAutor();
                new framePrueba().setVisible(true);
                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargarDoc;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem NuevoDoc;
    private javax.swing.JScrollPane SizeMenu;
    private javax.swing.JList<String> SizeMenuBusqueda;
    // End of variables declaration//GEN-END:variables
}
