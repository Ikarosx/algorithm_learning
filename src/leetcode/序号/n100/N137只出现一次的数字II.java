package leetcode.序号.n100;

/**
 * 给你一个整数数组&nbsp;nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10<sup>4</sup>
 * -2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 相关标签：
 * 位运算
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/single-number-ii/
 *
 * @author Ikarosx
 * @date 2021/4/30
 */
public class N137只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            // 计算第i位上有多少个
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            // 如果余3，则将其置为1
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}