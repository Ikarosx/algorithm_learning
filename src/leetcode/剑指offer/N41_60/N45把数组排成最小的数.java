package leetcode.剑指offer.N41_60;

import java.util.Arrays;
import org.junit.Test;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: [10,2] 输出: "102" 示例 2:
 *
 * <p>输入: [3,30,34,5,9] 输出: "3033459"
 *
 * <p>提示:
 *
 * <p>0 < nums.length <= 100 说明:
 *
 * <p>输出结果可能非常大，所以你需要返回一个字符串而不是整数 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/4 20:49
 */
public class N45把数组排成最小的数 {
  public String minNumber(int[] nums) {
    String[] strings = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(
        strings,
        (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
    StringBuilder builder = new StringBuilder();
    for (String string : strings) {
      builder.append(string);
    }
    return builder.toString();
  }

  @Test
  public void test() {
    System.out.println(minNumber(new int[] {121, 12}));
  }
}
