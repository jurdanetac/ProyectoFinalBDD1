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
        String item = rs.getString(identificador);
        modeloLista.addElement(item);
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