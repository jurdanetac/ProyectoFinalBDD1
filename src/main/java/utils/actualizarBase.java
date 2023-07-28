package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Urdaneta
 */
public class actualizarBase {

  /*
  private static void anadir(String entidad, String id, String idd) {
    Connection connection = null;
    Statement stmt = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      stmt = connection.createStatement();
      stmt.executeUpdate(String.format("INSERT INTO %s VALUES()", ));

    } catch (SQLException ex) {
      Logger.getLogger(actualizarBase.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        stmt.close();
      } catch (SQLException e) {
      }
try {
        connection.close();
      } catch (SQLException e) {
      }
    }
   */
  public static void insertar(String entidad, String values) {
    String valores = "";

    if ("actividad_economica".equals(entidad)) {
      valores = "(nombre, tipo_recurso, descripcion)";
    } else if ("cuerpo_de_agua".equals(entidad)) {
      valores = "(nombre, ubicacion, area, extension, profundidad)";
    } else if ("gentilicio".equals(entidad)) {
      valores = "(nombre , territorio_id )";
    } else if ("idioma".equals(entidad)) {
      valores = "(nombre)";
    } else if ("idioma_es_utilizado_en_territorio".equals(entidad)) {
      valores = "(idioma_nombre ,territorio_id ,porcentaje ,oficial)";
    } else if ("relieve".equals(entidad)) {
      valores = "(tipo ,descripcion )";
    } else if ("ser_vivo".equals(entidad)) {
      valores = "(nombre_comun,descripcion,estado_de_conservacion,reino,filo_o_division,clase,orden,familia,genero,especie)";
    } else if ("simbolo_patrio".equals(entidad)) {
      valores = "(id,nombre,descripcion,territorio_id)";
    } else if ("territorio".equals(entidad)) {
      valores = "(tipo,nombre,ubicacion,superficie,nro_habitantes,clima,territorio_capital_id)";
    } else if ("territorio_desarrolla_actividad_economica".equals(entidad)) {
      valores = "(actividad_economica_nombre,territorio_id)";
    } else if ("territorio_linda_con_territorio".equals(entidad)) {
      valores = "(territorio_id,territorio_id1)";
    } else if ("territorio_subdivide_en_territorio".equals(entidad)) {
      valores = "(territorio_id,territorio_id1)";
    } else if ("territorio_tiene_cuerpo_de_agua".equals(entidad)) {
      valores = "(territorio_id,cuerpo_de_agua_nombre)";
    } else if ("territorio_tiene_relieve".equals(entidad)) {
      valores = "(territorio_id,relieve_tipo)";
    } else if ("territorio_tiene_ser_vivo".equals(entidad)) {
      valores = "(territorio_id,ser_vivo_genero,ser_vivo_especie)";
    }

    Connection connection = null;
    Statement stmt = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      stmt = connection.createStatement();
      System.out.println("INSERT INTO " + entidad + " " + valores + " VALUES " + values + ";");
      stmt.executeUpdate("INSERT INTO " + entidad + " " + valores + " VALUES " + values + ";");
    } catch (SQLException ex) {
      Logger.getLogger(actualizarBase.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Revise los dominios de los datos ingresados");
    }
  }

  private static void eliminar(String entidad, String id, String idd) {
    Connection connection = null;
    Statement stmt = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      stmt = connection.createStatement();
      stmt.executeUpdate(String.format("DELETE FROM %s WHERE %s = %s;", entidad, id, idd));

    } catch (SQLException ex) {
      Logger.getLogger(actualizarBase.class
          .getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        stmt.close();
      } catch (SQLException e) {
        /* Ignored */ }
      try {
        connection.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }

  public static void eliminar_territorio(String id) {
    Connection connection = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      eliminar("territorio_linda_con_territorio", "territorio_id", id);
      eliminar("territorio_linda_con_territorio", "territorio_id1", id);
      eliminar("simbolo_patrio", "territorio_id", id);
      eliminar("gentilicio", "territorio_id", id);
      eliminar("territorio_subdivide_en_territorio", "territorio_id", id);
      eliminar("territorio_subdivide_en_territorio", "territorio_id1", id);
      eliminar("territorio_desarrolla_actividad_economica", "territorio_id", id);
      eliminar("idioma_es_utilizado_en_territorio", "territorio_id", id);
      eliminar("territorio_tiene_ser_vivo", "territorio_id", id);
      eliminar("territorio_tiene_cuerpo_de_agua", "territorio_id", id);
      eliminar("territorio_tiene_relieve", "territorio_id", id);
      eliminar("territorio", "id", id);

    } catch (SQLException ex) {
      Logger.getLogger(actualizarBase.class
          .getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }
}
