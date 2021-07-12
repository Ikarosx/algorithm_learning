package leetcode.序号.n500;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 对于一个&nbsp;正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。

给定一个&nbsp;整数&nbsp;n，&nbsp;如果是完美数，返回 true，否则返回 false

示例 1：

输入：28
输出：True
解释：28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, 和 14 是 28 的所有正因子。

示例 2：

输入：num = 6
输出：true

示例 3：

输入：num = 496
输出：true

示例 4：

输入：num = 8128
输出：true

示例 5：

输入：num = 2
输出：false

提示：

	1 <= num <= 10<sup>8</sup>


相关标签：
	数学

原题地址：https://leetcode-cn.com/problems/perfect-number/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N507完美数 {
     @Test
     public void test () {
         Assertions.assertTrue(checkPerfectNumber(28));
         Assertions.assertTrue(checkPerfectNumber(6));
         Assertions.assertTrue(checkPerfectNumber(496));
         Assertions.assertTrue(checkPerfectNumber(8128));
         Assertions.assertFalse(checkPerfectNumber(2));
     }

    public boolean checkPerfectNumber(int num) {
        int perfectNum = 0;
        int mid = (int) Math.sqrt(num);
        for (int i = 1; i <= mid; i++) {
            if (num % i != 0) {
                continue;
            }
            int j = num / i;
            perfectNum += i;
            if (i != j) {
                perfectNum += j;
            }
        }
        return perfectNum == num * 2;
    }
 } 