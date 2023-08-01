package ventanas.anadir;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Juan Urdaneta
 */
public class relieve extends javax.swing.JFrame {

  /**
   * Creates new form relieve
   */
  public static Font font = null;

  public relieve() {
    font = utils.cargarFuente.robotoRegular();
    initComponents();
    // Center frame
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    volver = new javax.swing.JButton();
    anadir = new javax.swing.JButton();
    title = new javax.swing.JLabel();
    limpiar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    descripcion = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    tipo = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    volver.setText("Volver");
    volver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        volverActionPerformed(evt);
      }
    });
    getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

    anadir.setText("Añadir");
    anadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anadirActionPerformed(evt);
      }
    });
    getContentPane().add(anadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

    title.setFont(font);
    title.setText("Nuevo Relieve");
    getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

    limpiar.setText("Limpiar");
    limpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        limpiarActionPerformed(evt);
      }
    });
    getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

    jLabel3.setText("Descripción");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
    getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, -1));

    jLabel1.setText("Tipo");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
    getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 340, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
    JFrame relieve = new ventanas.entidades.relieve();
    this.setVisible(false);
    relieve.setVisible(true);
  }//GEN-LAST:event_volverActionPerformed

  private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
    JTextField[] columnas = {tipo, descripcion};
    String[] relieve = new String[columnas.length];

    int index = 0;

    for (JTextField columna : columnas) {
      if (columna.getText().trim().isEmpty()) {
        // Notificar al usuario si dejó algún campo en blanco
        JOptionPane.showMessageDialog(null, "No debe dejar campos de texto en blanco");
        return;
      }
      relieve[index] = columna.getText().trim();
      index++;
    }

    utils.actualizarBase.insertar("relieve", String.format("('%s', '%s')", relieve));

    JFrame relieves = new ventanas.entidades.relieve();
    this.setVisible(false);
    relieves.setVisible(true);
  }//GEN-LAST:event_anadirActionPerformed

  private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    JFrame anadirRelieve = new ventanas.anadir.relieve();
    this.setVisible(false);
    anadirRelieve.setVisible(true);
  }//GEN-LAST:event_limpiarActionPerformed

  private void gentilicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gentilicioActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_gentilicioActionPerformed

  private void climaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_climaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_climaActionPerformed

  private void capitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitalActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_capitalActionPerformed

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
      java.util.logging.Logger.getLogger(relieve.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(relieve.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(relieve.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(relieve.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
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
        new relieve().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton anadir;
  private javax.swing.JTextField descripcion;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JButton limpiar;
  private javax.swing.JTextField tipo;
  private javax.swing.JLabel title;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}
