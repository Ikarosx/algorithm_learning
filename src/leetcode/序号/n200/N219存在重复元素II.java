package leetcode.序号.n200;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数&nbsp;<em>k</em>，判断数组中是否存在两个不同的索引<em>&nbsp;i</em>&nbsp;和<em>&nbsp;j</em>，使得&nbsp;nums [i] = nums [j]，并且 <em>i</em> 和 <em>j</em>&nbsp;的差的 绝对值 至多为 <em>k</em>。
 * <p>
 * 示例&nbsp;1:
 * <p>
 * 输入: nums = [1,2,3,1], k<em> </em>= 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k<em> </em>=<em> </em>1
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k<em> </em>=<em> </em>2
 * 输出: false
 * <p>
 * 相关标签：
 * 数组
 * 哈希表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * @author Ikarosx
 * @date 2021/4/27
 */
public class N219存在重复元素II {
	/**
	 * 10ms 59.42%
	 * 41.8MB 61.46%
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	// set，
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
        	// 如果存在返回true
            if (set.contains(nums[i])) {
                return true;
            }
            // 添加当前值
            set.add(nums[i]);
            // 移除之前最左边窗口的值
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}