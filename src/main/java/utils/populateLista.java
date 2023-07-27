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

  public static void populateCuerpoDeAgua(JList<String> lista) {
    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", "cuerpo_de_agua"));

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String nombre = rs.getString("nombre");

        modeloLista.addElement(String.format("%s", nombre));
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger("cuerpo_de_agua").log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }

  public static void populateSimboloPatrio(JList<String> lista) {
    ResultSet rs = consultarBase("SELECT simbolo_patrio.id, simbolo_patrio.nombre, territorio_id, territorio.nombre FROM simbolo_patrio INNER JOIN territorio on simbolo_patrio.territorio_id = territorio.id");

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String idSimboloPatrio = rs.getString("simbolo_patrio.id");
        String nombreSimboloPatrio = rs.getString("simbolo_patrio.nombre");
        String nombreTerritorio = rs.getString("territorio.nombre");
        String territorioId = rs.getString("territorio_id");

        modeloLista.addElement(String.format("%s - %s (%s - %s)", idSimboloPatrio, nombreSimboloPatrio, territorioId, nombreTerritorio));
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger("simbolo_patrio").log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }

  public static void populateRelieve(JList<String> lista) {
    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", "relieve"));

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String tipo = rs.getString("tipo");

        modeloLista.addElement(String.format("%s", tipo));
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger("relieve").log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }

  public static void populateActividadEconomica(JList<String> lista) {
    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", "actividad_economica"));

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String nombre = rs.getString("nombre");
        String tipoRecurso = rs.getString("tipo_recurso");

        modeloLista.addElement(String.format("%s (Recurso %s)", nombre, tipoRecurso));
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger("actividad_economica").log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }

  public static void populateSerVivo(JList<String> lista) {
    ResultSet rs = consultarBase(String.format("SELECT * FROM %s;", "ser_vivo"));

    DefaultListModel modeloLista = new DefaultListModel();

    try {
      while (rs.next()) {
        String nombre_comun = rs.getString("nombre_comun");
        String genero = rs.getString("genero");
        String especie = rs.getString("especie");

        modeloLista.addElement(String.format("(%s) - %s %s", nombre_comun, genero, especie));
      }
      lista.setModel(modeloLista);
    } catch (SQLException ex) {
      Logger.getLogger("ser_vivo").log(Level.SEVERE, null, ex);
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
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