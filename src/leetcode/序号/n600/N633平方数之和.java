package leetcode.序号.n600;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非负整数&nbsp;c&nbsp;，你要判断是否存在两个整数 a 和 b，使得&nbsp;a<sup>2</sup> + b<sup>2</sup> = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 2<sup>31</sup> - 1
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/sum-of-square-numbers/
 *
 * @author Ikarosx
 * @date 2021/4/29
 */
public class N633平方数之和 {

	/**
	 * 费马平方和定理
	 */

	/**
	 * 双指针 时间复杂度：根号C
	 * @param c
	 * @return
	 */
	public boolean judgeSquareSumDouble(int c) {
		long left = 0;
		long right = (long) Math.sqrt(c);
		while (left <= right) {
			long sum = left * left + right * right;
			if (sum == c) {
				return true;
			} else if (sum > c) {
				right--;
			} else {
				left++;
			}
		}
		return false;
	}

	/**
	 * sqrt 时间复杂度：根号C
	 * 4ms 34.27%
	 * 35.2MB 64.88%
	 * @param c
	 * @return
	 */
	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int) b) {
				return true;
			}
		}
		return false;
	}

	/**
	 * set加上sqrt
	 * 63ms
	 * 46.6MB
	 * @param c
	 * @return
	 */
    public boolean judgeSquareSumSet(int c) {
		if (c == 0) {
			return true;
		}
		double sqrt = Math.sqrt(c);
		// 平方数<=n才不会大于c
        int n = (int) sqrt;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
        	// 计算平方数
            int e = i * i;
            // 添加到集合中
            set.add(e);
            // 判断集合是否存在一个数加上当前的平方和等于c
			// 存在特殊情况是自己的平方和等于c
            if (set.contains(c - e) || e == c) {
                return true;
            }
        }
        return false;
    }
}