package leetcode.序号.n400;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。

<ol>
</ol>

示例 1：

输入：num = 5
输出：2
解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。

示例 2：

输入：num = 1
输出：0
解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。

提示：

	给定的整数 num 保证在 32 位带符号整数的范围内。
	num >= 1
	你可以假定二进制数不包含前导零位。
	本题与 1009 <a href="https://leetcode-cn.com/problems/complement-of-base-10-integer/">https://leetcode-cn.com/problems/complement-of-base-10-integer/</a> 相同


相关标签：
	位运算

原题地址：https://leetcode-cn.com/problems/number-complement/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/8 
 */ 
 public class N476数字的补数 {

 	@Test
 	public void test () {
		Assertions.assertEquals(2, findComplement(5));
		Assertions.assertEquals(0, findComplement(1));
 	}

	public int findComplement(int num) {
		// 异或上一个长度为len(num)全1
		int temp = num;
		// 全1串
		int xor = 0;
		while (temp != 0) {
			// 左移一位
			xor <<= 1;
			// 将最右边的置为1
			xor |= 1;
			temp >>= 1;
		}

		return num ^ xor;
	}
 } 