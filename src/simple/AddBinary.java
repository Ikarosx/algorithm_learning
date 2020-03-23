package simple;

import org.junit.jupiter.api.Test;

/** @author x5322 */
public class AddBinary {
  @Test
  public void solution() {
    System.out.println(addBinary("11", "1"));
  }

  public String addBinary(String a, String b) {
    int temp = 0;
    StringBuilder res = new StringBuilder();
    int al = a.length() - 1;
    int bl = b.length() - 1;
    while (al >= 0 || bl >= 0) {
      int sum = temp;
      sum += al >= 0 ? a.charAt(al) - '0' : 0;
      sum += bl >= 0 ? b.charAt(bl) - '0' : 0;
      al--;
      bl--;
      res.append(sum % 2);
      temp = sum / 2;
    }
    if (temp != 0) {
      res.append(temp);
    }
    return res.reverse().toString();
  }
}
