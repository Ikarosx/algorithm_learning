package leetcode.序号.n200;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为&nbsp; 1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 1<sup>2</sup> + 9<sup>2</sup> = 82
 * 8<sup>2</sup> + 2<sup>2</sup> = 68
 * 6<sup>2</sup> + 8<sup>2</sup> = 100
 * 1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2<sup>31</sup> - 1
 * <p>
 * <p>
 * 相关标签：
 * 哈希表
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/happy-number/
 *
 * @author Ikarosx
 * @date 2021/4/26
 */
public class N202快乐数 {
    @Test
    public void test() {
		Assert.assertTrue(isHappy(19));
		Assert.assertFalse(isHappy(2));
    }

    public boolean isHappy(int n) {
    	// 检测该数字是否已经出现
        HashSet<Integer> integers = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            // 计算平方和
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (!integers.add(n)) {
                return false;
            }
        }
        return true;
    }
}