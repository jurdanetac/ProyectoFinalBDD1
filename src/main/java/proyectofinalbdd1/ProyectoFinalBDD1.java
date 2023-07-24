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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Juan Urdaneta
 */
public class ProyectoFinalBDD1 {

  private static void inicializarBase() {
    // Crear base de datos `proyecto_final` si no existe
    try {
      // Ruta del modelo SQL
      Path initSQLScript = Paths.get(System.getProperty("user.dir"), "src/main/resources/modelo.sql");

      // Conectarse a la base de datos como usuario root
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");

      // Crear comando
      Statement stmt = connection.createStatement();

      // Leer `modelo.sql` a una lista de Strings (líneas)
      List<String> modelo = Files.readAllLines(Paths.get(initSQLScript.toString()));

      String aux = "";

      for (String query : modelo) {
        if (query.contains("-") || query.isBlank()) {
          continue;
        }

        aux = aux.concat(query);

        if (query.endsWith(";")) {
          stmt.executeQuery(aux);
          aux = "";
        }
      }
    } catch (SQLException | IOException ex) {
      Logger.getLogger(ProyectoFinalBDD1.class
          .getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void main(String[] args) {
    // Crear frame principal
    JFrame ventanaPrincipal = new ventanas.principal();
    // Mostrar frame principal
    ventanaPrincipal.setVisible(true);
    inicializarBase();
  }
}
