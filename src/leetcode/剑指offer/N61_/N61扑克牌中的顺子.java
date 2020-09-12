package leetcode.剑指offer.N61_;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/11 8:38
 */
public class N61扑克牌中的顺子 {

    @Test
    public void test() {
        Assert.assertTrue(isStraight(new int[]{1, 2, 3, 4, 5}));
        Assert.assertTrue(isStraight(new int[]{0, 0, 1, 2, 5}));
        Assert.assertFalse(isStraight(new int[]{1, 2, 3, 4, 6}));
        Assert.assertTrue(isStraight(new int[]{0, 2, 3, 4, 6}));
        Assert.assertFalse(isStraight(new int[]{0, 1, 3, 4, 6}));
    }

    public boolean isStraight(int[] nums) {
        int dCount = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != 0) {
                // 可能存在相同数字
                if (nums[i - 1] == nums[i]) {
                    return false;
                }
                dCount += nums[i] - nums[i - 1];
            }
        }
        // --------------- 优化-可转化为最大值-最小值<=4 ---------------
        return dCount <= 4;
    }
}
