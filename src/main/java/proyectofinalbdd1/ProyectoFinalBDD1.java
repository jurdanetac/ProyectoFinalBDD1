package proyectofinalbdd1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Juan Urdaneta
 */
public class ProyectoFinalBDD1 {

  private static void inicializarBase() {
    // Crear base de datos `proyecto_final` si no existe
    Connection connection = null;
    Statement stmt = null;

    try {
      // Ruta del modelo SQL
      Path initSQLScript = Paths.get(System.getProperty("user.dir"), "src/main/resources/modelo-5.7.sql");

      // Conectarse a la base de datos como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");

      // Crear comando
      stmt = connection.createStatement();

      // Leer `modelo.sql` a una lista de Strings (líneas)
      List<String> modelo = Files.readAllLines(Paths.get(initSQLScript.toString()));

      String aux = "";

      for (String query : modelo) {
        if (query.contains("-") || query.trim().isEmpty()) {
          continue;
        }

        aux = aux.concat(query);

        if (query.endsWith(";")) {
          stmt.executeQuery(aux);
          aux = "";
        }
      }
    } catch (SQLException ex) {
      System.err.println("Couldn't connect to the database, do you have the correct privileges?");
      System.exit(0);
    } catch (IOException ex) {
      System.err.println("Init SQL Model not found.");
      System.exit(0);
    } finally {
      try {
        stmt.close();
        connection.close();
      } catch (SQLException e) {
        /* Ignored */ }
    }

  }

  public static void main(String[] args) {
    inicializarBase();
    // Crear frame principal
    JFrame ventanaPrincipal = new ventanas.principal();
    // Mostrar frame principal
    ventanaPrincipal.setVisible(true);
  }
}
