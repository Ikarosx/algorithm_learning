package leetcode.周赛.w225;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
 *
 * 操作的最终目标是满足下列三个条件 之一 ：
 *
 * a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
 * b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
 * a 和 b 都 由 同一个 字母组成。
 * 返回达成目标所需的 最少 操作数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = "aba", b = "caa"
 * 输出：2
 * 解释：满足每个条件的最佳方案分别是：
 * 1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
 * 2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
 * 3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
 * 最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。
 * 示例 2：
 *
 * 输入：a = "dabadd", b = "cda"
 * 输出：3
 * 解释：满足条件 1 的最佳方案是将 b 变为 "eee" 。
 *  
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 105
 * a 和 b 只由小写字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/24 12:24
 */
public class N5662满足三条件之一需改变的最少字符数 {

    @Test
    public void test() {
        Assert.assertEquals(2, minCharacters("aba", "caa"));
        Assert.assertEquals(3, minCharacters("dabadd", "cda"));
        Assert.assertEquals(2,
            minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    public int minCharacters(String a, String b) {
        int result = Integer.MAX_VALUE;
        int[] aints = new int[26];
        int[] bints = new int[26];
        for (char c : a.toCharArray()) {
            aints[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            bints[c - 'a']++;
        }
        // a严格小于b
        result = Math.min(result, cost(aints, bints));
        // b严格小于a
        result = Math.min(result, cost(bints, aints));
        // a、b字母相同

        for (int i = 0; i < bints.length; i++) {
            result = Math.min(result, a.length() - aints[i] + b.length() - bints[i]);
        }
        return result;
    }

    private int cost(int[] aints, int[] bints) {
        int result = Integer.MAX_VALUE;
        // 找到一个基准值，使得a中所有数都小于等于该值，b中所有数都大于该值
        // <25不能<26，因为没有不存在a中数小于等于z，b中数大于z
        for (int i = 0; i < 25; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                temp += bints[j];
            }
            for (int j = i + 1; j < 26; j++) {
                temp += aints[j];
            }
            result = Math.min(result, temp);
        }
        return result;
    }

}
