package ventanas.editar;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Juan Urdaneta
 */
public class serVivo extends javax.swing.JFrame {

  /**
   * Creates new form serVivo
   */
  public static Font font = null;

  String id;

  public serVivo(String nombreCientifico) {
    this.id = nombreCientifico;
    font = utils.cargarFuente.robotoRegular();
    initComponents();
    // Center frame
    this.setLocationRelativeTo(null);
    this.setResizable(false);

    genero.setText(id.split(" ")[0]);
    especie.setText(id.split(" ")[1]);
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
    modificar = new javax.swing.JButton();
    title = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    nombreComun = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    descripcion = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    estadoDeConservacion = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    reino = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    filo_o_division = new javax.swing.JTextField();
    limpiar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    clase = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    orden = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    familia = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    genero = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    especie = new javax.swing.JTextField();

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
    getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

    modificar.setText("Modificar");
    modificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        modificarActionPerformed(evt);
      }
    });
    getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, -1));

    title.setFont(font);
    title.setText("Nuevo Ser Vivo");
    getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

    jLabel2.setText("Nombre común");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 100, -1));

    nombreComun.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nombreComunActionPerformed(evt);
      }
    });
    getContentPane().add(nombreComun, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 150, -1));

    jLabel3.setText("Descripción");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

    descripcion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        descripcionActionPerformed(evt);
      }
    });
    getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 160, -1));

    jLabel4.setText("Estado de Conservación");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));
    getContentPane().add(estadoDeConservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 150, -1));

    jLabel5.setText("Reino");
    getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
    getContentPane().add(reino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 160, -1));

    jLabel7.setText("Filo o división");
    getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));
    getContentPane().add(filo_o_division, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 150, -1));

    limpiar.setText("Limpiar");
    limpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        limpiarActionPerformed(evt);
      }
    });
    getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

    jLabel1.setText("Clase");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
    getContentPane().add(clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, -1));

    jLabel6.setText("Orden");
    getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));
    getContentPane().add(orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 150, -1));

    jLabel8.setText("Familia");
    getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));
    getContentPane().add(familia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 160, -1));

    jLabel10.setText("Género");
    getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
    getContentPane().add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, -1));

    jLabel9.setText("Especie");
    getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));
    getContentPane().add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 150, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
    JFrame serVivo = new ventanas.entidades.serVivo();
    this.setVisible(false);
    serVivo.setVisible(true);
  }//GEN-LAST:event_volverActionPerformed

  private void nombreComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreComunActionPerformed
  }//GEN-LAST:event_nombreComunActionPerformed

  private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_descripcionActionPerformed

  private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
    JTextField[] camposDeTexto = {nombreComun, descripcion, estadoDeConservacion, reino, filo_o_division, clase, orden, familia, genero, especie};
    String[] camposDeTextoContenido = new String[camposDeTexto.length];

    int index = 0;

    for (JTextField campoDeTexto : camposDeTexto) {
      String campoDeTextoContenido = campoDeTexto.getText().trim();

      if (campoDeTextoContenido.isEmpty()) {
        // Notificar al usuario si dejó algún campo en blanco
        JOptionPane.showMessageDialog(null, "No debe dejar campos de texto en blanco");
        return;
      }

      camposDeTextoContenido[index] = campoDeTextoContenido;
      index++;
    }

    // genero
    camposDeTextoContenido[camposDeTextoContenido.length - 1] = id.split(" ")[0];
    // especie
    camposDeTextoContenido[camposDeTextoContenido.length - 2] = id.split(" ")[1];

    String serVivo = String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", (Object[]) camposDeTextoContenido);

    utils.actualizarBase.eliminarSerVivo(camposDeTextoContenido[camposDeTextoContenido.length - 1], camposDeTextoContenido[camposDeTextoContenido.length - 2]);
    utils.actualizarBase.insertar("ser_vivo", serVivo);

    JFrame entidadesSerVivo = new ventanas.entidades.serVivo();
    this.setVisible(false);
    entidadesSerVivo.setVisible(true);
  }//GEN-LAST:event_modificarActionPerformed

  private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    JFrame anadirSerVivo = new ventanas.anadir.serVivo();
    this.setVisible(false);
    anadirSerVivo.setVisible(true);
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
      java.util.logging.Logger.getLogger(serVivo.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(serVivo.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(serVivo.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(serVivo.class
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

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        // new serVivo().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField clase;
  private javax.swing.JTextField descripcion;
  private javax.swing.JTextField especie;
  private javax.swing.JTextField estadoDeConservacion;
  private javax.swing.JTextField familia;
  private javax.swing.JTextField filo_o_division;
  private javax.swing.JTextField genero;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JButton limpiar;
  private javax.swing.JButton modificar;
  private javax.swing.JTextField nombreComun;
  private javax.swing.JTextField orden;
  private javax.swing.JTextField reino;
  private javax.swing.JLabel title;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}
