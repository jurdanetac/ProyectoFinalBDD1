package ventanas.entidades;

import java.awt.Font;
import javax.swing.JFrame;
import utils.populateLista;

/**
 *
 * @author Juan Urdaneta
 */
public class idioma extends javax.swing.JFrame {

  /**
   * Creates new form relieve
   */
  public static Font font = null;

  public idioma() {
    font = utils.cargarFuente.robotoRegular();
    initComponents();
    // Center frame
    this.setLocationRelativeTo(null);
    populateLista.populateIdioma(lista);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bg = new javax.swing.JPanel();
    title = new javax.swing.JLabel();
    anadir = new javax.swing.JButton();
    scroll = new javax.swing.JScrollPane();
    lista = new javax.swing.JList<>();
    volver = new javax.swing.JButton();
    editar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    title.setFont(font);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText("Idioma");
    bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 310, -1));

    anadir.setText("Añadir");
    anadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anadirActionPerformed(evt);
      }
    });
    bg.add(anadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, -1));

    lista.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    scroll.setViewportView(lista);

    bg.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 310, 180));

    volver.setText("Volver");
    volver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        volverActionPerformed(evt);
      }
    });
    bg.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, -1));

    editar.setText("Editar");
    editar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editarActionPerformed(evt);
      }
    });
    bg.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 90, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_anadirActionPerformed

  private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
    JFrame menuEntidades = new ventanas.menuEntidades();
    this.setVisible(false);
    menuEntidades.setVisible(true);
  }//GEN-LAST:event_volverActionPerformed

  private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_editarActionPerformed

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
      java.util.logging.Logger.getLogger(idioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(idioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(idioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(idioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        new idioma().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton anadir;
  private javax.swing.JPanel bg;
  private javax.swing.JButton editar;
  private javax.swing.JList<String> lista;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JLabel title;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}