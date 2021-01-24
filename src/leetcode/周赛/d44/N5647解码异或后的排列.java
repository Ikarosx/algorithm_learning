package leetcode.周赛.d44;

import org.junit.Test;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * @author Ikarosx
 * @date 2021/1/23 22:36
 */
public class N5647解码异或后的排列 {

    @Test
    public void test() {
        System.out.println(decode(new int[]{3, 1}));
    }

    public int[] decode(int[] encoded) {
        int length = encoded.length + 1;
        int c1 = 0;
        for (int i = 1; i <= length; i++) {
            c1 ^= i;
        }
        int c2 = 0;
        for (int i = 0; i < encoded.length; i++) {
            if ((i & 1) == 1) {
                c2 ^= encoded[i];
            }
        }
        int a1 = c1 ^ c2;
        int[] ints = new int[encoded.length + 1];
        ints[0] = a1;
        for (int i = 1; i < ints.length; i++) {
            ints[i] = encoded[i - 1] ^ ints[i - 1];
        }
        return ints;
    }
}
