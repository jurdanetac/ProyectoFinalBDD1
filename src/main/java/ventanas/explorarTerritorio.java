package ventanas;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static utils.consultarBase.consultarBase;

/**
 *
 * @author Juan Urdaneta
 */
public class explorarTerritorio extends javax.swing.JFrame {

  /**
   * Creates new form territorio
   */
  public static Font font = null;

  public explorarTerritorio() {
    font = utils.cargarFuente.robotoRegular();
    initComponents();
    // Center frame
    this.setLocationRelativeTo(null);

    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", "territorio"));

    try {
      utils.populateLista.populate("territorio", lista, "nombre");
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(explorarTerritorio.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    subterritorios = new javax.swing.JButton();
    scroll = new javax.swing.JScrollPane();
    lista = new javax.swing.JList<>();
    volver = new javax.swing.JButton();
    colinda = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    title.setFont(font);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText("Territorio");
    bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 310, -1));

    subterritorios.setText("Subdivide");
    subterritorios.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        subterritoriosActionPerformed(evt);
      }
    });
    bg.add(subterritorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, -1));

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
    bg.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 90, -1));

    colinda.setText("Vecinos");
    colinda.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colindaActionPerformed(evt);
      }
    });
    bg.add(colinda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 90, -1));

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

  private void subterritoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subterritoriosActionPerformed
    if (lista.getSelectedValue() != null) {
      String[] fila_seleccionada = lista.getSelectedValue().split(" ");
      String territorio_seleccionado = fila_seleccionada[0];
      String territorio_nombre = new String();

      for (int i = 2; i < fila_seleccionada.length; i++) {
        if (fila_seleccionada[i].contains("(")) {
          break;
        }
        territorio_nombre = territorio_nombre.concat(fila_seleccionada[i] + " ");
      }
      territorio_nombre = territorio_nombre.trim();

      ResultSet rs = consultarBase(String.format("select t2.nombre from territorio_subdivide_en_territorio join territorio t1 on t1.id = territorio_subdivide_en_territorio.territorio_id join territorio t2 on t2.id = territorio_subdivide_en_territorio.territorio_id1 where t1.id = %s;", territorio_seleccionado));
      ArrayList<String> subterritorios = new ArrayList<String>();
      try {
        while (rs.next()) {
          subterritorios.add(rs.getString("nombre"));
        }
      } catch (SQLException ex) {
        Logger.getLogger(explorarTerritorio.class.getName()).log(Level.SEVERE, null, ex);
      }
      if (subterritorios.isEmpty()) {
        JOptionPane.showMessageDialog(null, String.format("%s no tiene subterritorios agregados\n", territorio_nombre));
      } else {
        JOptionPane.showMessageDialog(null, String.format("(%s) %s se subdivide en los siguientes territorios:\n%s", territorio_seleccionado, territorio_nombre, subterritorios.toString()));
      }
    } else {
      JOptionPane.showMessageDialog(null, "No ha seleccionado un territorio");
    }
  }//GEN-LAST:event_subterritoriosActionPerformed

  private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
    JFrame principal = new ventanas.principal();
    this.setVisible(false);
    principal.setVisible(true);
  }//GEN-LAST:event_volverActionPerformed

  private void colindaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colindaActionPerformed
    if (lista.getSelectedValue() != null) {
      String[] fila_seleccionada = lista.getSelectedValue().split(" ");
      String territorio_seleccionado = fila_seleccionada[0];
      String territorio_nombre = new String();

      for (int i = 2; i < fila_seleccionada.length; i++) {
        if (fila_seleccionada[i].contains("(")) {
          break;
        }
        territorio_nombre = territorio_nombre.concat(fila_seleccionada[i] + " ");
      }
      territorio_nombre = territorio_nombre.trim();

      ResultSet rs = consultarBase(String.format("select t2.nombre from territorio_linda_con_territorio join territorio t1 on t1.id = territorio_linda_con_territorio.territorio_id join territorio t2 on t2.id = territorio_linda_con_territorio.territorio_id1 where t1.id = %s;", territorio_seleccionado));

      ArrayList<String> vecinos = new ArrayList<String>();
      try {
        while (rs.next()) {
          vecinos.add(rs.getString("nombre"));
        }
      } catch (SQLException ex) {
        Logger.getLogger(explorarTerritorio.class.getName()).log(Level.SEVERE, null, ex);
      }
      if (vecinos.isEmpty()) {
        JOptionPane.showMessageDialog(null, String.format("%s no tiene territorios vecinos agregados\n", territorio_nombre));
      } else {
        JOptionPane.showMessageDialog(null, String.format("(%s) %s linda con los siguientes territorios:\n%s", territorio_seleccionado, territorio_nombre, vecinos.toString()));
      }
    } else {
      JOptionPane.showMessageDialog(null, "No ha seleccionado un territorio");
    }
  }//GEN-LAST:event_colindaActionPerformed

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
      java.util.logging.Logger.getLogger(explorarTerritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(explorarTerritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(explorarTerritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(explorarTerritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new explorarTerritorio().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel bg;
  private javax.swing.JButton colinda;
  private javax.swing.JList<String> lista;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JButton subterritorios;
  private javax.swing.JLabel title;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}
