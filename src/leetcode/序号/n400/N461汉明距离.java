package leetcode.序号.n400;

import org.junit.Assert;
import org.junit.Test;

/**
 * 两个整数之间的<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E8%B7%9D%E7%A6%BB">汉明距离</a>指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：<br>
 * 0 ≤ x, y < 2<sup>31</sup>.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * <p>
 * 相关标签：
 * 位运算
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author Ikarosx
 * @date 2021/5/28
 */
public class N461汉明距离 {
    @Test
    public void test() {
        Assert.assertEquals(2, hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        // 异或之后计算c上1的数量
        int c = x ^ y;
        int result = 0;
        while (c != 0) {
            result++;
            c &= c - 1;
        }
        return result;
    }
}