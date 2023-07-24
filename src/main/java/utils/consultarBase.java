package utils;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Juan Urdaneta
 */
public class consultarBase {

  public static ResultSet consultarBase(String consulta) {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      // Conectarse a la base de datos `proyecto_final` como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");

      stmt = connection.createStatement();
      rs = stmt.executeQuery(consulta);
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(consultarBase.class.getName()).log(Level.SEVERE, null, ex);
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
    return rs;
  }
}
