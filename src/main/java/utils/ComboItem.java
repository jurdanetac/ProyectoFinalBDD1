package utils;

/**
 *
 * @author Juan Urdaneta
 */
public class ComboItem {

  private final String key;
  private final String value;

  public ComboItem(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return key;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
