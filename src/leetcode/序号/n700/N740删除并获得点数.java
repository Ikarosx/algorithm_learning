package leetcode.序号.n700;

/**
 * 给你一个整数数组&nbsp;nums&nbsp;，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个&nbsp;nums[i]&nbsp;，删除它并获得&nbsp;nums[i]&nbsp;的点数。之后，你必须删除每个等于&nbsp;nums[i] - 1&nbsp;或&nbsp;nums[i] + 1&nbsp;的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例&nbsp;2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10<sup>4</sup>
 * 1 <= nums[i] <= 10<sup>4</sup>
 * <p>
 * <p>
 * 相关标签：
 * 动态规划
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/delete-and-earn/
 *
 * @author Ikarosx
 * @date 2021/5/6
 */
public class N740删除并获得点数 {
	/**
	 * 打家劫舍无优化版本 4ms 30%
	 * @param nums
	 * @return
	 */
    public int deleteAndEarnFirst(int[] nums) {
        int[] ints = new int[10000 + 1];
        for (int num : nums) {
            ints[num]++;
        }
        for (int i = 2; i < 10001; i++) {
            ints[i] = Math.max(ints[i - 1], ints[i - 2] + ints[i] * i);
        }
		return ints[10000];
    }

	/**
	 * 优化版本 1ms 100%
	 * @param nums
	 * @return
	 */
	public int deleteAndEarn(int[] nums) {
		int maxVal = 0;
		for (int val : nums) {
			maxVal = Math.max(maxVal, val);
		}
		int[] sum = new int[maxVal + 1];
		for (int val : nums) {
			sum[val] += val;
		}
		return rob(sum);
	}

	public int rob(int[] nums) {
		int size = nums.length;
		int first = nums[0], second = Math.max(nums[0], nums[1]);
		for (int i = 2; i < size; i++) {
			int temp = second;
			second = Math.max(first + nums[i], second);
			first = temp;
		}
		return second;
	}

}