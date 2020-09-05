package leetcode.剑指offer.N41_60;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
 * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: 12258 输出: 5 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * <p>提示：
 *
 * <p>0 <= num < 231
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/5 7:59
 */
public class N46把数字翻译成字符串 {

    @Test
    public void test() {
        Assert.assertEquals(5, translateNum(12258));
    }


    public int translateNum(int num) {
        String string = String.valueOf(num);

        int[] results = new int[string.length() + 1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 1; i < string.length(); i++) {
            // 若 x_ix
            // i
            //​           // 和 x_{i-1}x
            // i−1
            //​           // 组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]dp[i]=dp[i−1]+dp[i−2] ；否则 dp[i] = dp[i - 1]dp[i]=dp[i−1] 。

            if (canTrans(string.charAt(i - 1), string.charAt(i))) {
                results[i + 1] = results[i] + results[i - 1];
            } else {
                results[i + 1] = results[i];
            }
        }
        return results[string.length()];
    }

    private boolean canTrans(char j, char k) {
        if (j == '1') {
            return true;
        }
        if (j == '2') {
            return k <= '5';
        }
        return false;
    }
}
