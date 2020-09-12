package leetcode.剑指offer.N61_;

import java.util.Arrays;
import org.junit.Test;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/10 21:58
 */
public class N60n个骰子的点数 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(1)));
        System.out.println(Arrays.toString(twoSum(2)));
        System.out.println(Arrays.toString(twoSum(3)));
    }

    public double[] twoSum(int n) {

        // --------------- 优化-空间 ---------------
        int[] ints = new int[n * 6 + 1];
        // 初始化状态
        for (int i = 1; i <= 6; i++) {
            ints[i] = 1;
        }
        // 第i个骰子
        for (int i = 2; i <= n; i++) {
            // 从上一个骰子的前6个相加而来
            for (int j = 6 * i; j >= i; j--) {
                // 需要将值置为0
                ints[j] = 0;
                for (int cur = 1; cur <= 6 && j - cur >= i - 1; cur++) {
                    ints[j] += ints[j - cur];
                }
            }

        }
        double[] doubles = new double[6 * n - n + 1];
        // 总次数
        double pow = Math.pow(6, n);
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = ints[i + n] / pow;
        }
        return doubles;
    }

}
