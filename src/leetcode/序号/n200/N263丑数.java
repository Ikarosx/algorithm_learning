package leetcode.序号.n200;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 丑数 就是只包含质因数&nbsp;2、3 和/或&nbsp;5&nbsp;的正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数&nbsp;7 。
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * <p>
 * -2<sup>31</sup> <= n <= 2<sup>31</sup> - 1
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/ugly-number/
 *
 * @author Ikarosx
 * @date 2021/5/8
 */
public class N263丑数 {
    @Test
    public void test() {
        System.out.println(isUgly(8));
    }

    /**
     * 数学
	 *
	 * 根据丑数的定义，00 和负整数一定不是丑数。
	 *
	 * 当 n>0n>0 时，若 nn 是丑数，则 nn 可以写成 n = 2^a \times 3^b \times 5^cn=2
	 * a
	 *  ×3
	 * b
	 *  ×5
	 * c
	 *   的形式，其中 a,b,ca,b,c 都是非负整数。特别地，当 a,b,ca,b,c 都是 00 时，n=1n=1。
	 *
	 * 为判断 nn 是否满足上述形式，可以对 nn 反复除以 2,3,52,3,5，直到 nn 不再包含质因数 2,3,52,3,5。若剩下的数等于 11，则说明 nn 不包含其他质因数，是丑数；否则，说明 nn 包含其他质因数，不是丑数。
	 *
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode-cn.com/problems/ugly-number/solution/chou-shu-by-leetcode-solution-fazd/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }


    /**
     * 超时
     *
     * @param n
     * @return
     */
    public boolean isUglyTLM(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(5);
        int cur = 1;
        while (cur <= n) {
            Integer ceiling = treeSet.higher(cur);
            HashSet<Integer> set = new HashSet<>();
            for (Integer integer : treeSet) {
                if (integer <= ceiling) {
                    set.add(ceiling * integer);
                } else {
                    break;
                }
            }
            treeSet.addAll(set);
            cur = ceiling;
        }
        return treeSet.contains(n);
    }
}