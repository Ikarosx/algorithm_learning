package simple;

import common.IQuestion;

import java.util.HashMap;

/**
 * @author x5322 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *     <p>字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12
 *     写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *     <p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值
 *     4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *     <p>I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *     <p>示例 1:
 *     <p>输入: "III" 输出: 3 示例 2:
 *     <p>输入: "IV" 输出: 4 示例 3:
 *     <p>输入: "IX" 输出: 9 示例 4:
 *     <p>输入: "LVIII" 输出: 58 解释: L = 50, V= 5, III = 3. 示例 5:
 *     <p>输入: "MCMXCIV" 输出: 1994 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/roman-to-integer
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *     正解：首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值； 否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
 */
public class String_13 implements IQuestion {
  //  public String_13(TimeType timeType) {
  //    super(timeType);
  //  }

  @Override
  public void solution() {
    // 初始化映射
    HashMap<Character, Integer> map = new HashMap<>(8);
    int[] ints = {1, 5, 10, 50, 100, 500, 1000};
    char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    for (int i = 0; i < ints.length; i++) {
      map.put(chars[i], ints[i]);
    }
    String str = "III";
    /*
     设str为输入字符串  MCMXCIV
     ①若字符串为空则返回0
     ②字符串长度为1直接返回映射
     ③字符串长度大于1

       3.1 左指针l下标为0，当前字符数量count为0，总值sum为0
       while(左指针<=长度)
         3.2 得到当前字符c
         3.3 判断是否有下一字符
           3.3.1 有：跳3.4
           3.3.2 无：count*映射值 + sum
         3.4 判断下一字符n与当前字符c关系
           3.4.1 n=c：count++，l++跳3.2
           3.4.2 n<c：sum += count*映射值，count = 0, l+2跳3.2
           3.4.3 n>c：sum += n映射值-c映射值,count = 0, l+2跳3.2
    */
    // ①
    if (str == null || "".equals(str)) {
      System.out.println(0);
      return;
    }
    // ②
    if (str.length() == 1) {
      System.out.println(map.get(str.charAt(0)));
      return;
    }
    // 左指针
    int l = 0;
    // 当前字符数
    int count = 0;
    // 总值
    int sum = 0;
    // 确保当前指针在有效范围内
    while (l < str.length()) {
      count++;
      char c = str.charAt(l);
      // 如果没有下一个值
      if (str.length() == l + 1) {
        sum += count * map.get(c);
        break;
      }
      char n = str.charAt(l + 1);
      int nn = map.get(n);
      int cn = map.get(c);
      if (nn == cn) {
        l++;
        continue;
      }
      if (nn < cn) {
        sum += count * cn;
        count = 0;
        l += 1;
        continue;
      }
      // nn > cn
      sum += nn - cn;
      count = 0;
      l += 2;
    }
    System.out.println(sum);
  }
}
