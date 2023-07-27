package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static utils.consultarBase.consultarBase;

/**
 *
 * @author Juan Urdaneta
 */
public class populateLista {
  private populateLista() {
  }

  public static void populate(String entidad, JList<String> lista, String identificador) {
    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", entidad));

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String id = rs.getString("id");
        String nombre = rs.getString("nombre");
        String tipo = rs.getString("tipo");

        // Muestra territorio padre, si el territorio lo tiene
        ResultSet parent = consultarBase(String.format("SELECT t1.nombre FROM territorio_subdivide_en_territorio JOIN territorio t1 ON t1.id = territorio_subdivide_en_territorio.territorio_id JOIN territorio t2 ON t2.id = territorio_subdivide_en_territorio.territorio_id1 WHERE t2.id = %s;", id));

        if (parent.next()) {
          modeloLista.addElement(String.format("%s - %s (%s) - %s", id, nombre, tipo, parent.getString("nombre")));
        } else {
          modeloLista.addElement(String.format("%s - %s (%s)", id, nombre, tipo));
        }
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger(entidad).log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }
}