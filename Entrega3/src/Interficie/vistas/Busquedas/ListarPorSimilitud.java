/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interficie.vistas.Busquedas;

import Interficie.vistas.FramePrincipal;
import java.awt.Color;
import javax.swing.JOptionPane;


public class ListarPorSimilitud extends javax.swing.JPanel {
    private final FramePrincipal framePrincipal;
    private String criterioSelect;
    /**
     * Creates new form ListarPorSimilitud
     * @param framePrincipal
     */
    public ListarPorSimilitud(FramePrincipal framePrincipal) {
        initComponents();
        this.framePrincipal = framePrincipal;
    }
    
    private boolean verificarK(String K){
        boolean isNumber = false;
        try{
            int n = Integer.parseInt(K);
            isNumber = true;
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return isNumber;
    }
    private boolean firstA = true;
    private boolean firstT = true;
    private boolean firstK = true;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoBusqueda = new javax.swing.JLabel();
        ButtonBuscar = new javax.swing.JButton();
        Titulo = new javax.swing.JTextField();
        NumeroK = new javax.swing.JTextField();
        NombreAutor = new javax.swing.JTextField();
        tipoOrdenacion = new javax.swing.JLabel();
        criterioOrdenar = new javax.swing.JComboBox<>();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        TipoBusqueda.setText("BÚSQUEDA POR SIMILITUD");
        TipoBusqueda.setToolTipText("");

        ButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonBuscar.setLabel("Buscar");
        ButtonBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        Titulo.setForeground(new java.awt.Color(102, 102, 102));
        Titulo.setText("Introduce un título");
        Titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TituloMousePressed(evt);
            }
        });

        NumeroK.setForeground(new java.awt.Color(102, 102, 102));
        NumeroK.setText("Introduce un número");
        NumeroK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NumeroKMousePressed(evt);
            }
        });
        NumeroK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumeroKKeyTyped(evt);
            }
        });

        NombreAutor.setForeground(new java.awt.Color(102, 102, 102));
        NombreAutor.setText("Introduce un nombre de autor");
        NombreAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreAutorMousePressed(evt);
            }
        });

        tipoOrdenacion.setText("Ordenar por:");

        criterioOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "similaridad descendente", "autor A-Z", "título A-Z" }));
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
                                        .addComponent(NumeroK)
                                        .addComponent(NombreAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 465,
                                                Short.MAX_VALUE)
                                        .addComponent(Titulo, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(tipoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ButtonBuscar))
                                        .addComponent(TipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NumeroK, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ButtonBuscar)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(criterioOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tipoOrdenacion)))
                                .addContainerGap()));

        layout.linkSize(javax.swing.SwingConstants.VERTICAL,
                new java.awt.Component[] { ButtonBuscar, NombreAutor, NumeroK });

        layout.linkSize(javax.swing.SwingConstants.VERTICAL,
                new java.awt.Component[] { criterioOrdenar, tipoOrdenacion });

    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ButtonBuscarActionPerformed
        // TODO add your handling code here:
        String error = "";
        String autor;
        String titulo;
        int k = 0;
        if (NombreAutor.getText().equals("Introduce un nombre de autor") || "".equals(NombreAutor.getText())) {
            error += "No se ha introducido autor \n";
        }
        if (Titulo.getText().equals("Introduce un titulo") || "".equals(Titulo.getText())) {
            error += "No se ha introducido titulo \n";
        }
        if (NumeroK.getText().equals("Introduce un titulo") || "".equals(NumeroK.getText())
                || !verificarK(NumeroK.getText())) {
            error += "No se ha introducido numero correctamente \n";
        }
        if(NumeroK.getText().equals("Introduce un titulo")
                || "".equals(NumeroK.getText())
                || !verificarK(NumeroK.getText())
                || Integer.parseInt(NumeroK.getText()) == 0
                ||  Integer.parseInt(NumeroK.getText()) >= this.framePrincipal.getDocSize()){
           error += "No se ha introducido número correctamente \n";
        }


        if ("".equals(error)) {
            autor = NombreAutor.getText();
            titulo = Titulo.getText();
            k = Integer.parseInt(NumeroK.getText());
            criterioSelect = criterioOrdenar.getSelectedItem().toString();
            framePrincipal.buscarPorSimilitud(autor, titulo, k, criterioSelect);
        } else {
            JOptionPane.showMessageDialog(null, error);
        }
        
        
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void NombreAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreAutorMousePressed
        // TODO add your handling code here:
         if (firstA) {
              firstA = false;
              NombreAutor.setEnabled(true);
              NombreAutor.setText("");
              NombreAutor.setForeground(new Color(0, 0, 0));
          }
    }//GEN-LAST:event_NombreAutorMousePressed

    private void TituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TituloMousePressed
        // TODO add your handling code here:
        if (firstT) {
            firstT = false;
            Titulo.setEnabled(true);
            Titulo.setText("");
            Titulo.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TituloMousePressed

    private void NumeroKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NumeroKMousePressed
        // TODO add your handling code here:
        if (firstK) {
            firstK = false;
            NumeroK.setEnabled(true);
            NumeroK.setText("");
            NumeroK.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_NumeroKMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         if ("".equals(NombreAutor.getText())) {
            NombreAutor.setText("Introduce un nombre de autor");
            NombreAutor.setForeground(new Color(102, 102, 102));
            firstA = true;
            NombreAutor.setEnabled(false);
        }
        
        if ("".equals(Titulo.getText())) {
            Titulo.setText("Introduce un titulo");
            Titulo.setForeground(new Color(102, 102, 102));
            firstT = true;
            Titulo.setEnabled(false);
        }
        
        if ("".equals(NumeroK.getText())) {
            NumeroK.setText("Introduce el numero de documento [0-100]");
            NumeroK.setForeground(new Color(102, 102, 102));
            firstK = true;
            NumeroK.setEnabled(false);
        }
    }//GEN-LAST:event_formMousePressed

    private void criterioOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criterioOrdenarActionPerformed
        // TODO add your handling code here:
        String error = "";
        int k = 0;
        if(NombreAutor.getText().equals("Introduce un nombre de autor") || "".equals(NombreAutor.getText())){
            error += "No se ha introducido autor \n";
        }
        if(Titulo.getText().equals("Introduce un titulo") || "".equals(Titulo.getText())){
            error += "No se ha introducido titulo \n";
        }
        if(NumeroK.getText().equals("Introduce un titulo") || "".equals(NumeroK.getText()) || !verificarK(NumeroK.getText())){
           error += "No se ha introducido numero correctamente \n";
        }

        if("".equals(error)){
            String autor = NombreAutor.getText();
            String titulo = NombreAutor.getText();
            k = Integer.parseInt(NumeroK.getText()) ;
            criterioSelect = criterioOrdenar.getSelectedItem().toString();
            framePrincipal.buscarPorSimilitud(autor,titulo,k,criterioSelect);
        }else{
            JOptionPane.showMessageDialog(null,error);
        }
    }//GEN-LAST:event_criterioOrdenarActionPerformed

    private void NumeroKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroKKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_NumeroKKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JTextField NumeroK;
    private javax.swing.JLabel TipoBusqueda;
    private javax.swing.JTextField Titulo;
    private javax.swing.JComboBox<String> criterioOrdenar;
    private javax.swing.JLabel tipoOrdenacion;
    // End of variables declaration//GEN-END:variables
}
