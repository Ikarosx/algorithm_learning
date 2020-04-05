package 剑指offer.字符串.替换空格;

import org.junit.jupiter.api.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author Ikaros
 * @date 2020/03/07 10:31
 */
class SolutionTest {
  private String replaceSpace(StringBuffer str) {
    int count = 0;
    /*
     * 思路：
     * 从后往前，先计算好空格数量
     * 如果后面开始不为空格，则顺推 空格*2的位置
     * 如果为空格，则 (count - 1) + 当前下标 开始为%20
     *
     */
    // 计算空格
    int oldLength = str.length();
    for (int i = 0; i < oldLength; i++) {
      if (str.charAt(i) == ' ') {
        count++;
      }
    }
    // 没有空格提前返回
    if (count == 0) {
      return str.toString();
    }
    // 设置新长度
    str.setLength(oldLength + count * 2);
    // 从后往前移动
    for (int i = oldLength - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (c == ' ') {
        // 如果等于空格，那么(count - 1) + 当前下标开始为%20
        count--;
        str.setCharAt(i + 2 * count + 2, '0');
        str.setCharAt(i + 2 * count + 1, '2');
        str.setCharAt(i + 2 * count, '%');
      } else {
        // 如果不等于空格，那么往后移动count*2个位置
        str.setCharAt(i + count * 2, c);
      }
    }
    return str.toString();
  }

  @Test
  void solution() {
    //    System.out.println(
    //        find(15, new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}));
    String str = replaceSpace(new StringBuffer("We Are Happy"));
    System.out.println(str);
  }
}
