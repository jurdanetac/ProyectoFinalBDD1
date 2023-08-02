package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Urdaneta
 */
public class ConsultaPane {

  public static void consultaPane(String entidad, String id, String id2) {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      // Conectarse a la base de datos como usuario root
      connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyecto_final", "root", "");
      // Crear comando
      stmt = connection.createStatement();

      if (entidad.equals("actividad_economica")) {
        rs = stmt.executeQuery(String.format("SELECT nombre, tipo_recurso, descripcion FROM actividad_economica WHERE nombre = '%s';", id));

        rs.first();

        JOptionPane.showMessageDialog(null,
            String.format("Nombre:\n%s\n\nTipo de Recurso:\n%s\n\nDescripción:\n%s",
                rs.getString("nombre"),
                rs.getString("tipo_recurso"),
                rs.getString("descripcion")),
            "Actividad Económica", JOptionPane.INFORMATION_MESSAGE);
      } else if (entidad.equals("cuerpo_de_agua")) {
        rs = stmt.executeQuery(String.format("SELECT nombre, ubicacion, area, extension, profundidad FROM cuerpo_de_agua WHERE nombre = '%s';", id));

        rs.first();

        JOptionPane.showMessageDialog(null,
            String.format("Nombre:\n%s\n\nUbicación:\n%s\n\nÁrea:\n%s\n\nExtensión:\n%s\n\nProfundidad:\n%s",
                rs.getString("nombre"),
                rs.getString("ubicacion"),
                rs.getString("area"),
                rs.getString("extension"),
                rs.getString("profundidad")),
            "Cuerpo de Agua", JOptionPane.INFORMATION_MESSAGE);
      } else if (entidad.equals("idioma")) {
        rs = stmt.executeQuery(String.format("SELECT nombre, porcentaje, oficial FROM idioma WHERE nombre = '%s';", id));

        rs.first();
        String oficial;
        if (rs.getString("oficial").equals("1")) {
          oficial = "Es un idioma oficial";
        } else {
          oficial = "No es un idioma oficial";
        }

        JOptionPane.showMessageDialog(null,
            String.format("Nombre:\n%s\n\nPorcentaje de hablantes:\n%s\n\n%s",
                rs.getString("nombre"),
                rs.getString("porcentaje"),
                oficial,
                "Idioma"));
      } else if (entidad.equals("relieve")) {
        rs = stmt.executeQuery(String.format("SELECT tipo, descripcion FROM relieve WHERE tipo = '%s';", id));

        rs.first();

        JOptionPane.showMessageDialog(null,
            String.format("Tipo de Relieve:\n%s\n\nDescripción:\n%s",
                rs.getString("tipo"),
                rs.getString("descripcion")),
            "Relieve", JOptionPane.INFORMATION_MESSAGE);

      } else if (entidad.equals("simbolo_patrio")) {
        rs = stmt.executeQuery(String.format("SELECT simbolo_patrio.nombre, simbolo_patrio.descripcion, territorio.nombre FROM simbolo_patrio JOIN territorio on territorio.id = simbolo_patrio.territorio_id WHERE simbolo_patrio.id = %s;", id));

        rs.first();

        JOptionPane.showMessageDialog(null,
            String.format("Nombre del Símbolo:\n%s\n\nPerteneciente a:\n%s\n\nDescripción:\n%s",
                rs.getString("simbolo_patrio.nombre"),
                rs.getString("territorio.nombre"),
                rs.getString("descripcion")),
            "Símbolo Patrio", JOptionPane.INFORMATION_MESSAGE);

      } else if (entidad.equals("ser_vivo")) {
        rs = stmt.executeQuery(String.format("SELECT nombre_comun, reino, filo_o_division, clase, orden, familia, genero, especie, estado_de_conservacion, descripcion FROM ser_vivo WHERE genero = '%s' AND especie = '%s';", id, id2));

        rs.first();

        JOptionPane.showMessageDialog(null,
            String.format("Nombre común:\n%s\n\nTaxonomía:\n\nReino:\n%s\n\nFilo o división:\n%s\n\nClase:\n%s\n\nOrden:\n%s\n\nFamilia:\n%s\n\nGénero:\n%s\n\nEspecie:\n%s\n\nEstado de Conservación:\n%s\n\nDescripción:\n%s",
                rs.getString("nombre_comun"),
                rs.getString("reino"),
                rs.getString("filo_o_division"),
                rs.getString("clase"),
                rs.getString("orden"),
                rs.getString("familia"),
                rs.getString("genero"),
                rs.getString("especie"),
                rs.getString("estado_de_conservacion"),
                rs.getString("descripcion")),
            "Ser Vivo", JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConsultaPane.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        stmt.close();
        connection.close();
      } catch (SQLException ex) {
        Logger.getLogger(ConsultaPane.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
