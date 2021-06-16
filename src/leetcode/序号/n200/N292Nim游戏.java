package leetcode.序号.n200;

/**
 * 你和你的朋友，两个人一起玩&nbsp;<a href="https://baike.baidu.com/item/Nim游戏/6737105">Nim 游戏</a>：

	桌子上有一堆石头。
	你们轮流进行自己的回合，你作为先手。
	每一回合，轮到的人拿掉&nbsp;1 - 3 块石头。
	拿掉最后一块石头的人就是获胜者。

假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。

示例 1：

输入：n = 4
输出：false 
解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
&nbsp;    因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

示例 2：

输入：n = 1
输出：true

示例 3：

输入：n = 2
输出：true

提示：

	1 <= n <= 2<sup>31</sup> - 1


相关标签：
	脑筋急转弯
	极小化极大

原题地址：https://leetcode-cn.com/problems/nim-game/
  
 *  
 * @author Ikarosx 
 * @date 2021/6/16 
 */ 
 public class N292Nim游戏 {
	/**
	 * 数学
	 * 每次使得堆中都是4的倍数就可以赢
	 * 反之如果一开始就是4的倍数，那么对手就可以使得每次你抽的时候都是4的倍数，你就会输
	 */
	public boolean canWinNim(int n) {
		return (n % 4 != 0);
	}
 } 