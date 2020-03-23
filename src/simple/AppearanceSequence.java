package simple;

import common.IQuestion;
import org.junit.jupiter.api.Test;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * <p>1. 1 2. 11 3. 21 4. 1211 5. 111221 1 被读作  "one 1"  ("一个一") , 即 11。 11 被读作 "two 1s" ("两个一"）,
 * 即 21。 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * <p>给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * <p>注意：整数序列中的每一项将表示为一个字符串。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: 1 输出: "1" 示例 2:
 *
 * <p>输入: 4 输出: "1211"
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author x5322
 */
public class AppearanceSequence implements IQuestion {
  @Override
  public void solution() {
    countAndSay(5);
  }

  public String countAndSay(int n) {
    String res = "1";
    for (int i = 0; i < n - 1; i++) {
      res = countAndSayImpl(res);
    }
    System.out.println(res);
    return res;
  }

  public String countAndSayImpl(String str) {
    StringBuilder res = new StringBuilder();
    char[] chars = str.toCharArray();
    int count = 0;
    char temp = '1';
    for (char c : chars) {
      if (c != temp) {
        if (count != 0) {
          res.append(count).append(temp);
        }
        count = 1;
        temp = c;
      } else {
        count++;
      }
    }
    res.append(count).append(temp);
    return res.toString();
  }

  @Test
  public void test() {
    countAndSay(4);
  }
}
