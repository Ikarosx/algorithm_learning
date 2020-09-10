package leetcode.剑指offer.N61_;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/9 21:13
 */
public class N56II数组中数字出现的次数 {

    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int singleNumber(int[] nums) {
        // 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
        // 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
        //

        // 建立一个长度为 32 的数组 countscounts ，通过以上方法可记录所有数字的各二进制位的 1 的出现次数。
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                // 更新第 j 位
                counts[j] += num & 1;
                // 第 j 位 --> 第 j + 1 位
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        // 利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上（循环区间是 i∈[0,31] ）
        for (int i = 0; i < 32; i++) {
            // 左移 1 位
            res <<= 1;
            // 恢复第 i 位的值到 res
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
