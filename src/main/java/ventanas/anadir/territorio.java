package ventanas.anadir;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.ComboItem;
import static utils.consultarBase.consultarBase;
import utils.populateLista;

/**
 *
 * @author Juan Urdaneta
 */
public class territorio extends javax.swing.JFrame {

  /**
   * Creates new form territorio
   */
  public static Font font = null;

  public territorio() {
    font = utils.cargarFuente.robotoRegular();
    initComponents();
    // Center frame
    this.setLocationRelativeTo(null);
    this.setResizable(false);

    // Populate all JLists in form
    populateLista.populateSerVivo(listaSerVivo);
    populateLista.populateRelieve(listaRelieve);
    populateLista.populateIdioma(listaIdioma);
    populateLista.populateCuerpoDeAgua(listaCuerpoDeAgua);
    populateLista.populateActividadEconomica(listaActividadEconomica);
    populateLista.populate("territorio", listaVecinos, "nombre");
    populateLista.populate("territorio", listaSubterritorios, "nombre");

    ResultSet territorios = consultarBase("SELECT * FROM territorio;");

    // remove default 'item 1, item2...' in capital JForm and add default one
    capital.removeAllItems();
    capital.addItem("Seleccione");

    try {
      while (territorios.next()) {
        // there are no 'country' capitals, remove unnecessary entries from list
        if (territorios.getString("tipo").toLowerCase().equals("pais") || territorios.getString("tipo").toLowerCase().equals("país")) {
          return;
        }
        capital.addItem(territorios.getString("id") + " - " + new ComboItem(territorios.getString("nombre"), territorios.getString("tipo")));
      }
    } catch (SQLException ex) {
      Logger.getLogger(territorio.class.getName()).log(Level.SEVERE, null, ex);
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

    jPanel1 = new javax.swing.JPanel();
    volver = new javax.swing.JButton();
    anadir = new javax.swing.JButton();
    title = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    nombre = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    ubicacion = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    superficie = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    tipo = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    capital = new javax.swing.JComboBox<String>();
    jLabel7 = new javax.swing.JLabel();
    habitantes = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    listaCuerpoDeAgua = new javax.swing.JList<>();
    jLabel9 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    listaActividadEconomica = new javax.swing.JList<>();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    listaRelieve = new javax.swing.JList<>();
    jScrollPane4 = new javax.swing.JScrollPane();
    listaSerVivo = new javax.swing.JList<>();
    jLabel12 = new javax.swing.JLabel();
    clima = new javax.swing.JTextField();
    jLabel13 = new javax.swing.JLabel();
    jScrollPane6 = new javax.swing.JScrollPane();
    listaIdioma = new javax.swing.JList<>();
    porcentaje = new javax.swing.JTextField();
    JLabel15 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    oficial = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jScrollPane5 = new javax.swing.JScrollPane();
    listaVecinos = new javax.swing.JList<>();
    jScrollPane7 = new javax.swing.JScrollPane();
    listaSubterritorios = new javax.swing.JList<>();
    limpiar = new javax.swing.JButton();
    jLabel16 = new javax.swing.JLabel();
    gentilicio = new javax.swing.JTextField();

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
    getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

    anadir.setText("Añadir");
    anadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anadirActionPerformed(evt);
      }
    });
    getContentPane().add(anadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

    title.setFont(font);
    title.setText("Nuevo Territorio");
    getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 14, -1, -1));

    jLabel2.setText("Nombre");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, -1, -1));

    nombre.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nombreActionPerformed(evt);
      }
    });
    getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 76, 272, -1));

    jLabel3.setText("Ubicación");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 107, -1, -1));

    ubicacion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ubicacionActionPerformed(evt);
      }
    });
    getContentPane().add(ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 132, 130, -1));

    jLabel4.setText("Superficie");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));
    getContentPane().add(superficie, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 132, 130, -1));

    jLabel5.setText("Tipo");
    getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 163, -1, -1));
    getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 188, 130, -1));

    jLabel6.setText("Capital");
    getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

    capital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    capital.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        capitalActionPerformed(evt);
      }
    });
    getContentPane().add(capital, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 90, -1));

    jLabel7.setText("Habitantes");
    getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));
    getContentPane().add(habitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 188, 130, -1));

    jLabel8.setText("Cuerpo de Agua");
    getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

    listaCuerpoDeAgua.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(listaCuerpoDeAgua);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 170, 67));

    jLabel9.setText("Actividad Económica");
    getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

    listaActividadEconomica.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane2.setViewportView(listaActividadEconomica);

    getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 170, 67));

    jLabel10.setText("Relieve");
    getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

    jLabel11.setText("Ser Vivo");
    getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

    listaRelieve.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane3.setViewportView(listaRelieve);

    getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 170, 65));

    listaSerVivo.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane4.setViewportView(listaSerVivo);

    getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 170, 65));

    jLabel12.setText("Clima");
    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 219, -1, -1));

    clima.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        climaActionPerformed(evt);
      }
    });
    getContentPane().add(clima, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 238, 272, -1));

    jLabel13.setText("Idioma");
    getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

    listaIdioma.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane6.setViewportView(listaIdioma);

    getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 160, 91));
    getContentPane().add(porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 240, 170, -1));

    JLabel15.setText("Porcentajes (,)");
    getContentPane().add(JLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

    jLabel14.setText("Oficiales (,)");
    getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));
    getContentPane().add(oficial, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 310, 170, -1));

    jLabel1.setText("Vecinos");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

    jLabel15.setText("Subterritorios");
    getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

    listaVecinos.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane5.setViewportView(listaVecinos);

    getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 170, 110));

    listaSubterritorios.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane7.setViewportView(listaSubterritorios);

    getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 170, 140));

    limpiar.setText("Limpiar");
    limpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        limpiarActionPerformed(evt);
      }
    });
    getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

    jLabel16.setText("Gentilicio");
    getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

    gentilicio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        gentilicioActionPerformed(evt);
      }
    });
    getContentPane().add(gentilicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
    JFrame territorio = new ventanas.entidades.territorio();
    this.setVisible(false);
    territorio.setVisible(true);
  }//GEN-LAST:event_volverActionPerformed

  private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
  }//GEN-LAST:event_nombreActionPerformed

  private void ubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacionActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ubicacionActionPerformed

  private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
    JTextField[] camposDeTexto = {tipo, nombre, ubicacion, superficie, habitantes, clima};
    String[] camposDeTextoContenido = new String[camposDeTexto.length + 1];
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

    String territorio = String.format("('%s', '%s', '%s', %s, %s, '%s', %s)", (Object[]) camposDeTextoContenido);

    if (capital.getSelectedIndex() != 0) {
      territorio = territorio.substring(0, territorio.lastIndexOf(",")) + String.format(", %s)", camposDeTextoContenido[camposDeTextoContenido.length - 1]);
    }

    utils.actualizarBase.insertar("territorio", territorio);

    ResultSet rs = consultarBase("SELECT * FROM territorio ORDER BY id DESC LIMIT 1;");

    String territorio_creado_id = null;

    try {
      rs.next();
      territorio_creado_id = rs.getString("id");
    } catch (SQLException ex) {
      Logger.getLogger(territorio.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }

    List<String> actividadesEconomicas = listaActividadEconomica.getSelectedValuesList();
    List<String> cuerposDeAgua = listaCuerpoDeAgua.getSelectedValuesList();
    List<String> vecinos = listaVecinos.getSelectedValuesList();
    List<String> subterritorios = listaSubterritorios.getSelectedValuesList();
    List<String> idiomas = listaIdioma.getSelectedValuesList();
    List<String> seresVivos = listaSerVivo.getSelectedValuesList();
    List<String> relieves = listaRelieve.getSelectedValuesList();

    if (!relieves.isEmpty()) {
      for (String rlv : relieves) {
        utils.actualizarBase.insertar("territorio_tiene_relieve", String.format("(%s, '%s')", territorio_creado_id, rlv.trim()));
      }
    }

    if (!cuerposDeAgua.isEmpty()) {
      for (String c : cuerposDeAgua) {
        utils.actualizarBase.insertar("territorio_tiene_cuerpo_de_agua", String.format("(%s, '%s')", territorio_creado_id, c.trim()));
      }
    }

    if (!seresVivos.isEmpty()) {
      for (String str : seresVivos) {
        str = str.trim();
        String[] aux = str.split(" ");
        utils.actualizarBase.insertar("territorio_tiene_ser_vivo", String.format("(%s, '%s', '%s')", territorio_creado_id, aux[aux.length - 2], aux[aux.length - 1]));
      }
    }

    if (!idiomas.isEmpty()) {
      String[] porcentajes = porcentaje.getText().trim().split(",");
      String[] oficiales = oficial.getText().trim().split(",");

      if (porcentajes.length == 0) {
        JOptionPane.showMessageDialog(null, "No debe dejar los porcentajes en blanco");
        return;
      } else {
        for (int i = 0; i < idiomas.size(); i++) {
          String idioma = idiomas.get(i).trim();
          int oficial = 0;

          for (String ofic : oficiales) {
            if (ofic.equals(idioma)) {
              oficial = 1;
            }
          }

          utils.actualizarBase.insertar("idioma_es_utilizado_en_territorio", String.format("('%s', %s, %s, %s)", idioma, territorio_creado_id, porcentajes[i], oficial));
        }
      }
    }

    if (!actividadesEconomicas.isEmpty()) {
      for (String act : actividadesEconomicas) {
        utils.actualizarBase.insertar("territorio_desarrolla_actividad_economica", String.format("('%s', %s)", act.trim().split(" ")[0], territorio_creado_id));
      }
    }

    String[] gentilicios = gentilicio.getText().trim().split(",");

    for (String gentilicio : gentilicios) {
      if (!gentilicio.isEmpty()) {
        utils.actualizarBase.insertar("gentilicio", String.format("('%s', %s)", gentilicio, territorio_creado_id));
      }
    }

    if (!subterritorios.isEmpty()) {
      String[] subterIds = new String[subterritorios.size()];

      for (int i = 0; i < subterritorios.size(); i++) {
        subterIds[i] = subterritorios.get(i).split(" ")[0];
      }

      for (String subterritorio : subterIds) {
        utils.actualizarBase.insertar("territorio_subdivide_en_territorio", String.format("(%s, %s)", territorio_creado_id, subterritorio));
      }

      if (!vecinos.isEmpty()) {
        String[] vcsIds = new String[vecinos.size()];

        for (int i = 0; i < vecinos.size(); i++) {
          vcsIds[i] = vecinos.get(i).split(" ")[0];
        }

        for (String vecino : vcsIds) {
          // x linda con y
          utils.actualizarBase.insertar("territorio_linda_con_territorio", String.format("(%s, %s)", territorio_creado_id, vecino));
          // y linda con x
          utils.actualizarBase.insertar("territorio_linda_con_territorio", String.format("(%s, %s)", vecino.toString(), territorio_creado_id));
        }
      }

      JFrame entidadesTerritorio = new ventanas.entidades.territorio();
      this.setVisible(false);
      entidadesTerritorio.setVisible(true);
    }
  }//GEN-LAST:event_anadirActionPerformed

  private void climaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_climaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_climaActionPerformed

  private void capitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitalActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_capitalActionPerformed

  private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    JFrame anadirTerritorio = new ventanas.anadir.territorio();
    this.setVisible(false);
    anadirTerritorio.setVisible(true);
  }//GEN-LAST:event_limpiarActionPerformed

  private void gentilicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gentilicioActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_gentilicioActionPerformed

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
      java.util.logging.Logger.getLogger(territorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(territorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(territorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(territorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new territorio().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel JLabel15;
  private javax.swing.JButton anadir;
  private javax.swing.JComboBox<String> capital;
  private javax.swing.JTextField clima;
  private javax.swing.JTextField gentilicio;
  private javax.swing.JTextField habitantes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JScrollPane jScrollPane6;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JButton limpiar;
  private javax.swing.JList<String> listaActividadEconomica;
  private javax.swing.JList<String> listaCuerpoDeAgua;
  private javax.swing.JList<String> listaIdioma;
  private javax.swing.JList<String> listaRelieve;
  private javax.swing.JList<String> listaSerVivo;
  private javax.swing.JList<String> listaSubterritorios;
  private javax.swing.JList<String> listaVecinos;
  private javax.swing.JTextField nombre;
  private javax.swing.JTextField oficial;
  private javax.swing.JTextField porcentaje;
  private javax.swing.JTextField superficie;
  private javax.swing.JTextField tipo;
  private javax.swing.JLabel title;
  private javax.swing.JTextField ubicacion;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}
