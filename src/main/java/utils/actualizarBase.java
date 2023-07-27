package utils;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Juan Urdaneta
 */
public class actualizarBase {

  private static void eliminar(String entidad, String id, String idd) {
    Connection connection = null;
    Statement stmt = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      stmt = connection.createStatement();
      stmt.executeUpdate(String.format("DELETE FROM %s WHERE %s = %s;", entidad, id, idd));

    } catch (SQLException ex) {
      Logger.getLogger(actualizarBase.class.getName()).log(Level.SEVERE, null, ex);
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
      Logger.getLogger(actualizarBase.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }
  }
}
