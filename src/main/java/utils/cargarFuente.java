package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Urdaneta
 */
public class cargarFuente {

  private cargarFuente() {
  }

  public static Font robotoRegular() {
    InputStream is = cargarFuente.class.getResourceAsStream("/fonts/Roboto/Roboto-Regular.ttf");
    Font roboto = null;

    try {
      roboto = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(24.0F);
    } catch (FontFormatException | IOException ex) {
      Logger.getLogger(cargarFuente.class.getName()).log(Level.SEVERE, null, ex);
    }
    return roboto;
  }
}
