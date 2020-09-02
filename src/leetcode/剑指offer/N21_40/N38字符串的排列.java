package leetcode.剑指offer.N21_40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * <p>
 *
 * <p>你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入：s = "abc" 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/1 10:15
 */
public class N38字符串的排列 {
  @Test
  public void test() {
    System.out.println(Arrays.toString(permutation("abc")));
  }

  List<String> res = new LinkedList<>();
  char[] c;

  public String[] permutation(String s) {
    c = s.toCharArray();
    dfs(0);
    return res.toArray(new String[res.size()]);
  }

  private void dfs(int i) {
    if (i == c.length) {
      res.add(new String(c));
      return;
    }
    HashSet<Character> set = new HashSet<>();
    for (int j = i; j < c.length; j++) {
      if (set.contains(c[j])) {
        continue;
      }
      set.add(c[j]);
      swap(i, j);
      dfs(i + 1);
      swap(i, j);
    }
  }

  private void swap(int i, int j) {
    char temp = c[i];
    c[i] = c[j];
    c[j] = temp;
  }
}
