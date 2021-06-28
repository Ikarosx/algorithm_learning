package leetcode.序号.n300;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从&nbsp;1&nbsp;到&nbsp;<em>n</em> 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <p>
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1&nbsp;或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <p>
 * 返回我选出的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2<sup>31</sup> - 1
 * 1 <= pick <= n
 * <p>
 * <p>
 * 相关标签：
 * 二分查找
 * 交互
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 *
 * @author Ikarosx
 * @date 2021/6/28
 */
public class N374猜数字大小 {
	public int guessNumber(int n) {
		// 二分
		int l = 1;
		int r = n;
		while(l <= r) {
			int mid = (r - l) / 2 + l;
			int g = guess(mid);
			if(g == 0) {
				return mid;
			}
			if(g == 1) {
				l = mid + 1;
				continue;
			}
			if(g == -1) {
				r = mid - 1;
				continue;
			}
		}
		return -1;
	}

	private int guess(int mid) {
		return 0;
	}


}