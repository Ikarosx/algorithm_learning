package leetcode.序号.n600;

/**
 * 集合 s 包含从 1 到&nbsp;n&nbsp;的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10<sup>4</sup>
 * 1 <= nums[i] <= 10<sup>4</sup>
 * <p>
 * <p>
 * 相关标签：
 * 位运算
 * 数组
 * 哈希表
 * 排序
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/set-mismatch/
 *
 * @author Ikarosx
 * @date 2021/7/13
 */
public class N645错误的集合 {
    public int[] findErrorNums(int[] nums) {
    	// 位运算
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            xor ^= i;
        }
        // 此时xor = 重复的数字 ^ 丢失的数字
		// lowbit是xor最低位1
        int lowbit = xor & -xor;

        // a和b是重复的数字或丢失的数字
        int a = 0;
        int b = 0;
        // 将数&低位，最后再&上1-n，即可消去重复的，那么a和b就是其中一个结果
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1; i <= length; i++) {
            if ((i & lowbit) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
		// 遍历判断，如果相等说明是重复的那个值
        for (int num : nums) {
            if (b == num) {
                return new int[]{b, a};
            }
        }
        return new int[]{a, b};
    }

}